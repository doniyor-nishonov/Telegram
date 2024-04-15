package uz.pdp.frontend.view.channel;

import uz.pdp.backend.enums.ChannelType;
import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.service.channel.ChannelService;
import uz.pdp.backend.service.channel.ChannelServiceImp;
import uz.pdp.backend.service.post.PostService;
import uz.pdp.backend.service.post.PostServiceImp;
import uz.pdp.backend.service.subscribe.SubscribeService;
import uz.pdp.backend.service.subscribe.SubscribeServiceImp;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static uz.pdp.frontend.ui.UI.curUser;
import static uz.pdp.frontend.utils.MenuUtils.*;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.utils.Utils.notificationMessage;

public class ChannelView {
    public static ChannelService channelService = ChannelServiceImp.getInstance();
    public static PostService postService = PostServiceImp.getInstance();
    public static SubscribeService subscribeService = SubscribeServiceImp.getInstance();

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
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice" + STOP);
            }
        }
    }

    private static String getChannelId() {
        List<Channel> channelByUser = channelService.getChannelByUser(curUser.getId());
        checkData(channelByUser);
        if (channelByUser.isEmpty())
            return null;
        AtomicInteger i = new AtomicInteger();
        channelByUser.forEach(channel -> System.out.printf("%d. %s%n", i.incrementAndGet(), channel.getName()));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > channelByUser.size())
            return null;
        return channelByUser.get(index).getId();
    }

    private static void writePost(String id) {
        String title = inputStr("Enter title");
        boolean isWorked = postService.add(new Post(title, id));
        notificationMessage("Post","added",isWorked);
    }

    private static void deletePost(String id) {
        List<Post> postChannels = postService.getPostChannels(id);
        checkData(postChannels);
        if (postChannels.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        postChannels.forEach(post-> System.out.printf("%d. %s%n", i.incrementAndGet(), post));
        int index = inputInt("Choose") - 1;
        if(index < 0 || index > postChannels.size())
            return;
        boolean delete = postService.delete(postChannels.get(index).getId());
        notificationMessage("Post","deleted",delete);
    }

    private static void updatePost(String id) {
        List<Post> postChannels = postService.getPostChannels(id);
        checkData(postChannels);
        if (postChannels.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        postChannels.forEach(post-> System.out.printf("%d. %s%n", i.incrementAndGet(), post));
        int index = inputInt("Choose") - 1;
        if(index < 0 || index > postChannels.size())
            return;
        String title = inputStr("New title");
        boolean isWorked = postService.update(postChannels.get(index).getId(),new Post(title, id));
        notificationMessage("Post","deleted",isWorked);
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
        String name = inputStr("Enter name: ");
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
        boolean isWorked = channelService.add(new Channel(name, curUser.getId(), type));
        notificationMessage("Channel", "created", isWorked);
    }
}
