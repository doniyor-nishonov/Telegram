package uz.pdp.frontend.view.channel;

import uz.pdp.backend.enums.ChannelType;
import uz.pdp.backend.enums.Role;
import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.service.channel.ChannelService;
import uz.pdp.backend.service.channel.ChannelServiceImp;
import uz.pdp.backend.service.post.PostService;
import uz.pdp.backend.service.post.PostServiceImp;
import uz.pdp.backend.service.subscribe.SubscribeService;
import uz.pdp.backend.service.subscribe.SubscribeServiceImp;
import uz.pdp.backend.service.user.UserService;
import uz.pdp.backend.service.user.UserServiceImp;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static uz.pdp.frontend.ui.UI.curUser;
import static uz.pdp.frontend.utils.MenuUtils.*;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.utils.Utils.notificationMessage;

public class ChannelView {
    private static final ChannelService channelService = ChannelServiceImp.getInstance();
    private static final PostService postService = PostServiceImp.getInstance();
    private static final SubscribeService subscribeService = SubscribeServiceImp.getInstance();
    private static final UserService userService = UserServiceImp.getInstance();


    //MyChannel codes
    public static void myChannels() {
        String id = getChannelId();
        if (id == null) return;
        while (true) {
            int menu = menu(MY_CHANNEL);
            switch (menu) {
                case 1 -> writePost(id);
                case 2 -> deletePost(id);
                case 3 -> updatePost(id);
                case 4 -> showPost(id);
                case 5 -> subscribes(id);
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice" + STOP);
            }
        }
    }

    private static void subscribes(String id) {
        List<Subscribe> subscribes = subscribeService.fetchChannelMembers(id);
        checkData(subscribes);
        if (subscribes.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        subscribes.forEach(s -> System.out.printf("%d. %s -> %s%n", i.incrementAndGet()
                , userService.get(s.getUserId()).getName(), s.getRole()));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > subscribes.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        Subscribe subscribe = subscribes.get(index);
        if (Objects.equals(subscribe.getUserId(), curUser.getId())) {
            System.out.println(RED + "You cannot changed yourself" + STOP);
            return;
        }
        permission(subscribe);
    }

    private static void permission(Subscribe subscribe) {
        int menu = menu("1.Appointment to Admin\t2.Removal to Admin\t3.Block user\t4.Unblock user");
        switch (menu) {
            case 1 -> appointmentAdmin(subscribe);
            case 2 -> removalAdmin(subscribe);
            case 3 -> block(subscribe);
            case 4 -> unblock(subscribe);
            case 0 -> {
            }
            default -> System.out.println(RED + "Invalid choice" + STOP);
        }
    }

    private static void appointmentAdmin(Subscribe subscribe) {
        Channel channel = channelService.get(subscribe.getChannelId());
        if (Objects.equals(channel.getOwnerId(), subscribe.getUserId())) {
            System.out.println(RED + "This channel owner" + STOP);
            return;
        }
        if (Objects.equals(subscribe.getRole(), Role.ADMIN)) {
            System.out.println(RED + "This is already an administrator" + STOP);
            return;
        }
        subscribe.setRole(Role.ADMIN);
        boolean update = subscribeService.update(subscribe);
        notificationMessage("Admin", "appointment", update);
    }

    private static void removalAdmin(Subscribe subscribe) {
        Channel channel = channelService.get(subscribe.getChannelId());
        if (Objects.equals(channel.getOwnerId(), subscribe.getUserId())) {
            System.out.println(RED + "This channel owner" + STOP);
            return;
        }
        if (Objects.equals(subscribe.getUserId(), curUser.getId())) {
            System.out.println(RED + "You cannot removal yourself" + STOP);
            return;
        }
        if (Objects.equals(subscribe.getRole(), Role.USER)) {
            System.out.println(RED + "This is already an User" + STOP);
            return;
        }
        subscribe.setRole(Role.USER);
        boolean update = subscribeService.update(subscribe);
        notificationMessage("Admin", "removal", update);
    }

    private static void block(Subscribe subscribe) {
        Channel channel = channelService.get(subscribe.getChannelId());
        if (Objects.equals(channel.getOwnerId(), subscribe.getUserId())) {
            System.out.println(RED + "This channel owner" + STOP);
            return;
        }
        if (Objects.equals(subscribe.getUserId(), curUser.getId())) {
            System.out.println(RED + "You cannot blocked yourself" + STOP);
            return;
        }
        if (Objects.equals(subscribe.getRole(), Role.BLOCK)) {
            System.out.println(RED + "This is already an blocked" + STOP);
            return;
        }
        subscribe.setRole(Role.BLOCK);
        boolean update = subscribeService.update(subscribe);
        notificationMessage("User", "blocked", update);
    }

    private static void unblock(Subscribe subscribe) {
        Channel channel = channelService.get(subscribe.getChannelId());
        if (Objects.equals(channel.getOwnerId(), subscribe.getUserId())) {
            System.out.println(RED + "This channel owner" + STOP);
            return;
        }
        if (Objects.equals(subscribe.getUserId(), curUser.getId())) {
            System.out.println(RED + "You cannot unblocked yourself" + STOP);
            return;
        }
        if (Objects.equals(subscribe.getRole(), Role.USER)) {
            System.out.println(RED + "This is already an unblock" + STOP);
            return;
        }
        subscribe.setRole(Role.USER);
        boolean update = subscribeService.update(subscribe);
        notificationMessage("User", "unblocked", update);
    }

    private static String getChannelId() {
        List<Subscribe> subscribes = subscribeService.fetchChannelUser(curUser.getId());
        checkData(subscribes);
        if (subscribes.isEmpty())
            return null;
        AtomicInteger i = new AtomicInteger();
        subscribes.forEach(s -> System.out.printf("%d. %s%n", i.incrementAndGet(), channelService.get(s.getChannelId())));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > subscribes.size())
            return null;
        return subscribes.get(index).getChannelId();
    }

    private static void writePost(String id) {
        String title = inputStr("Enter title");
        boolean isWorked = postService.add(new Post(title, id));
        notificationMessage("Post", "added", isWorked);
    }

    private static void deletePost(String id) {
        List<Post> postChannels = postService.getPostChannels(id);
        checkData(postChannels);
        if (postChannels.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        postChannels.forEach(post -> System.out.printf("%d. %s%n", i.incrementAndGet(), post));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > postChannels.size())
            return;
        boolean delete = postService.delete(postChannels.get(index).getId());
        notificationMessage("Post", "deleted", delete);
    }

    private static void updatePost(String id) {
        List<Post> postChannels = postService.getPostChannels(id);
        checkData(postChannels);
        if (postChannels.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        postChannels.forEach(post -> System.out.printf("%d. %s%n", i.incrementAndGet(), post));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > postChannels.size())
            return;
        String title = inputStr("New title");
        Post post = postChannels.get(index);
        post.setTitle(title);
        boolean isWorked = postService.update(post);
        notificationMessage("Post", "deleted", isWorked);
    }

    private static void showPost(String id) {
        List<Post> postChannels = postService.getPostChannels(id);
        checkData(postChannels);
        if (postChannels.isEmpty())
            return;
        postChannels.forEach(System.out::println);
    }

    //Channels codes
    public static void channels() {
        while (true) {
            int menu = menu(CHANNEL);
            switch (menu) {
                case 1 -> createChannel();
                case 2 -> joinChannel();
                case 3 -> leaveChannel();
                case 4 -> showChannels();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + STOP);
            }
        }
    }


    private static void showChannels() {
        List<Subscribe> subscribes = subscribeService.getUserSubscribes(curUser.getId());
        checkData(subscribes);
        if (subscribes.isEmpty())
            return;
        AtomicInteger i = new AtomicInteger();
        subscribes.forEach((c) -> System.out.println(i.incrementAndGet() + ". " + channelService.get(c.getChannelId())));
        int choose = inputInt("Choose") - 1;
        if (choose < 0 || choose > subscribes.size()) {
            System.out.println(RED + "Invalid choice!" + STOP);
            return;
        }
        List<Post> posts = postService.getPostChannels(subscribes.get(choose).getChannelId());
        checkData(posts);
        posts.forEach(System.out::println);
    }

    private static void leaveChannel() {
        List<Subscribe> subscribes = subscribeService.getUserSubscribes(curUser.getId());
        checkData(subscribes);
        if (subscribes.isEmpty())
            return;
        AtomicInteger i = new AtomicInteger();
        subscribes.forEach((c) -> System.out.println(i.incrementAndGet() + ". " + channelService.get(c.getChannelId())));
        int choose = inputInt("Choose") - 1;
        if (choose < 0 || choose > subscribes.size()) {
            System.out.println(RED + "Invalid choice!" + STOP);
            return;
        }
        boolean isWorked = subscribeService.delete(subscribes.get(choose).getId());
        notificationMessage("Channel", "leaved", isWorked);
    }

    private static void joinChannel() {
        String name = inputStr("Enter name");
        List<Channel> channels = channelService.findWithName(name);
        checkData(channels);
        if (channels.isEmpty())
            return;
        for (int i = 0; i < channels.size(); i++)
            System.out.printf("%d. %s%n", (i + 1), channels.get(i).getName());
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > channels.size()) {
            System.out.println(RED + "Invalid choice!" + STOP);
            return;
        }
        Channel channel = channels.get(index);
        if (Objects.equals(channel.getOwnerId(), curUser.getId())) {
            System.out.println(RED + "This channel is yours" + STOP);
            return;
        }
        String id = channel.getId();
        boolean isWorked = subscribeService.add(new Subscribe(curUser.getId(), id));
        notificationMessage("Channel", "subscribe", isWorked);
    }

    private static void createChannel() {
        String name = inputStr("Enter name");
        ChannelType type = ChannelType.choose();
        Channel channel = new Channel(name, curUser.getId(), type);
        Subscribe subscribe = new Subscribe(curUser.getId(), channel.getId());
        subscribe.setRole(Role.ADMIN);
        subscribeService.add(subscribe);
        boolean isWorked = channelService.add(channel);
        notificationMessage("Channel", "created", isWorked);
    }
}
