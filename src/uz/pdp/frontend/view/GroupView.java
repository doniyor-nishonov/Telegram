package uz.pdp.frontend.view;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.enums.Role;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.model.member.Member;
import uz.pdp.backend.service.chat.ChatService;
import uz.pdp.backend.service.chat.ChatServiceImp;
import uz.pdp.backend.service.group.GroupService;
import uz.pdp.backend.service.group.GroupServiceImp;
import uz.pdp.backend.service.message.MessageService;
import uz.pdp.backend.service.message.MessageServiceImp;
import uz.pdp.backend.service.user.UserService;
import uz.pdp.backend.service.user.UserServiceImp;
import uz.pdp.backend.service.member.MemberService;
import uz.pdp.backend.service.member.MemberServiceImp;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static uz.pdp.frontend.utils.MenuUtils.*;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.ui.UI.*;
import static uz.pdp.frontend.view.ChatView.chatMessage;

public class GroupView {
    private static final GroupService groupService = GroupServiceImp.getInstance();
    private static final MemberService memberService = MemberServiceImp.getInstance();
    private static final ChatService chatService = ChatServiceImp.getInstance();
    private static final MessageService messageService = MessageServiceImp.getInstance();
    private static final UserService userService = UserServiceImp.getInstance();

    //My Group codes
    public static void myGroup() {
        List<Member> groups = memberService.fetchUserGroups(curUser.getId());
        checkData(groups);
        if (groups.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        groups.forEach(m -> System.out.printf("%d. %s%n", i.incrementAndGet()
                , groupService.get(m.getGroupId()).getName()));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > groups.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        String groupId = groups.get(index).getGroupId();
        while (true) {
            int menu = menu(MY_GROUP);
            switch (menu) {
                case 1 -> addAdmin(groupId);
                case 2 -> deleteAdmin(groupId);
                case 3 -> blockUser(groupId);
                case 4 -> unBlockUser(groupId);
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice" + STOP);
            }
        }
    }

    private static void addAdmin(String groupId) {
        List<Member> members = memberService.getMembers(groupId);
        checkData(members);
        if (members.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        members.forEach(m -> System.out.printf("%d. %s%n", i.incrementAndGet(), userService.get(m.getUserId()).getName()));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > members.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        Member member = members.get(index);
        if (member.getRole() == Role.ADMIN) {
            System.out.println(RED + "You are already an admin" + STOP);
            return;
        }
        member.setRole(Role.ADMIN);
        boolean update = memberService.update(member);
        notificationMessage("Admin", "added", update);
    }

    private static void deleteAdmin(String groupId) {
        List<Member> members = memberService.getMembers(groupId);
        checkData(members);
        if (members.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        members.forEach(m -> System.out.printf("%d. %s%n", i.incrementAndGet(), userService.get(m.getUserId()).getName()));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > members.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        Member member = members.get(index);
        String userId = groupService.get(member.getGroupId()).getUserId();
        if (Objects.equals(member.getUserId(), userId)) {
            System.out.println(RED + "Owner cannot be deleted" + STOP);
            return;
        }
        if (member.getRole() == Role.USER) {
            System.out.println(RED + "You are not already an admin" + STOP);
            return;
        }
        member.setRole(Role.USER);
        boolean update = memberService.update(member);
        notificationMessage("Admin", "deleted", update);
    }

    private static void blockUser(String groupId) {
        List<Member> members = memberService.getMembers(groupId);
        checkData(members);
        if (members.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        members.forEach(m -> System.out.printf("%d. %s%n", i.incrementAndGet(), userService.get(m.getUserId()).getName()));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > members.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        Member member = members.get(index);
        String userId = groupService.get(member.getGroupId()).getUserId();
        if (Objects.equals(member.getUserId(), userId)) {
            System.out.println(RED + "Owner cannot be blocked" + STOP);
            return;
        }
        if ((member.getRole() == Role.BLOCK)) {
            System.out.println(RED + "You are already blocked" + STOP);
            return;
        }
        member.setRole(Role.BLOCK);
        boolean update = memberService.update(member);
        notificationMessage("User", "blocked", update);
    }

    private static void unBlockUser(String groupId) {
        List<Member> members = memberService.getMembers(groupId);
        checkData(members);
        if (members.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        members.forEach(m -> System.out.printf("%d. %s%n", i.incrementAndGet(), userService.get(m.getUserId()).getName()));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > members.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        Member member = members.get(index);
        if (member.getRole() == Role.ADMIN || member.getRole() == Role.USER) {
            System.out.println(RED + "You are already unblocked" + STOP);
            return;
        }
        member.setRole(Role.USER);
        boolean update = memberService.update(member);
        notificationMessage("Admin", "unblocked", update);
    }

    ///Group codes
    public static void group() {
        while (true) {
            int menu = menu(GROUP);
            switch (menu) {
                case 1 -> createGroup();
                case 2 -> joinGroup();
                case 3 -> leaveGroup();
                case 4 -> showGroups();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice" + STOP);
            }
        }
    }

    private static void createGroup() {
        String name = inputStr("Name");
        Group group = new Group(curUser.getId(), name);
        boolean isWorked = groupService.add(group);
        Member member = new Member(curUser.getId(), group.getId());
        member.setRole(Role.ADMIN);
        memberService.add(member);
        notificationMessage("Group", "created", isWorked);
    }

    private static void joinGroup() {
        String name = inputStr("Name");
        List<Group> groups = groupService.findByName(name);
        checkData(groups);
        if (groups.isEmpty()) return;
        int i = 1;
        for (Group group : groups)
            System.out.printf("%d. %s%n", i++, group);
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > groups.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        Group group = groups.get(index);
        if (Objects.equals(group.getUserId(), curUser.getId())) {
            System.out.println(RED + "You are already subscribed" + STOP);
            return;
        }
        boolean isWorked = memberService.add(new Member(curUser.getId(), group.getId()));
        if (isWorked)
            messageService.add(new Message("Joined group", group.getId(), chatService.findOrCreate(curUser.getId(), group.getId(), MessageType.GROUP).getId(), MessageType.GROUP));
        notificationMessage("Group", "joined", isWorked);
    }

    private static void leaveGroup() {
        List<Member> groups = memberService.getUserByGroups(curUser.getId());
        checkData(groups);
        if (groups.isEmpty())
            return;
        AtomicInteger i = new AtomicInteger();
        groups.forEach(g -> System.out.printf("%d. %s%n", i.incrementAndGet(), groupService.get(g.getGroupId())));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > groups.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        String groupId = groups.get(index).getGroupId();
        boolean delete = memberService.delete(groups.get(index).getId());
        if (delete)
            messageService.add(new Message("Left group", groupId,
                    chatService.findOrCreate(curUser.getId(), groupId, MessageType.GROUP).getId(), MessageType.GROUP));
        notificationMessage("Group", "leaved", delete);
    }

    private static void showGroups() {
        List<Member> groups = memberService.getUserByGroups(curUser.getId());
        checkData(groups);
        if (groups.isEmpty())
            return;
        AtomicInteger i = new AtomicInteger();
        groups.forEach(g -> System.out.printf("%d. %s%n", i.incrementAndGet(), groupService.get(g.getGroupId())));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > groups.size())
            return;
        String groupId = groups.get(index).getGroupId();
        GroupMessage(groupId);
    }

    private static void GroupMessage(String groupId) {
        while (true) {
            int menu = menu(GROUP_CHAT);
            switch (menu) {
                case 1 -> send(groupId);
                case 2 -> update(groupId);
                case 3 -> delete(groupId);
                case 4 -> members(groupId);
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice" + STOP);
            }
        }
    }

    private static void send(String groupId) {
        Chat chat = chatService.findOrCreate(curUser.getId(), groupId, MessageType.GROUP);
        while (true) {
            showHistory(groupId);
            String text = inputStr("[0.Back]  Text");
            if (Objects.equals(text, "0")) {
                return;
            }
            boolean isWorked = messageService.add(new Message(text, groupId, chat.getId(), MessageType.GROUP));
            notificationMessage("Message", "sent", isWorked);
        }
    }

    private static void update(String groupId) {
        String chatId = chatService.findOrCreate(curUser.getId(), groupId, MessageType.GROUP).getId();
        List<Message> messages = messageService.getByGroupMyMessages(chatId, groupId);
        if (messages.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        messages.forEach(m -> System.out.printf("%d. %s%n", i.incrementAndGet(), m));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > messages.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        String newText = inputStr("New text");
        Message message = messages.get(index);
        message.setText(newText);
        boolean isWorked = messageService.update(message);
        notificationMessage("Message", "updated", isWorked);
    }

    private static void delete(String groupId) {
        String chatId = chatService.findOrCreate(curUser.getId(), groupId, MessageType.GROUP).getId();
        List<Message> messages = messageService.getByGroupMyMessages(chatId, groupId);
        if (messages.isEmpty()) return;
        AtomicInteger i = new AtomicInteger();
        messages.forEach(m -> System.out.printf("%d. %s%n", i.incrementAndGet(), m));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > messages.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        boolean isWorked = messageService.delete(messages.get(index).getId());
        notificationMessage("Message", "updated", isWorked);
    }

    private static void showHistory(String groupId) {
        String chatId = chatService.findOrCreate(curUser.getId(), groupId, MessageType.GROUP).getId();
        List<Message> messages = messageService.getGroupMessage(chatId, groupId);
        if (messages.isEmpty()) return;
        printMessage(messages);
    }

    private static void members(String groupId) {
        List<Member> members = memberService.getMembers(groupId);
        AtomicInteger i = new AtomicInteger();
        for (Member member : members)
            System.out.printf("%d. %s%n", i.incrementAndGet(), userService.get(member.getUserId()).getName());
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > members.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        String memberId = members.get(index).getUserId();
        if (Objects.equals(curUser.getId(), memberId)) {
            System.out.println(RED + "You cannot send messages to yourself" + STOP);
            return;
        }
        chatMessage(memberId);
    }

    private static void printMessage(List<Message> messages) {
        for (Message message : messages) {
            Chat chat = chatService.get(message.getChatId());
            if (Objects.equals(chat.getId1(), curUser.getId()))
                System.out.println("                    " + message);
            else
                System.out.printf("""
                                %s
                                %s
                                %s
                                %n""", userService.get(chat.getId1()).getName()
                        , message.getText(), message.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        }
    }

}
