package uz.pdp.frontend.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.model.user.User;

import java.util.List;
import java.util.Objects;

import static uz.pdp.frontend.Utils.*;
import static uz.pdp.frontend.ui.UI.*;

public class UserController {
    public static void userProfile() {
        while (true) {
            System.out.println(USER_MENU);
            int choose = inputInt("Choose");
            switch (choose) {
                case 1 -> search();
                case 2 -> myChats();
                case 3 -> block();
                case 4 -> unBlock();
                case 5 -> channels();
                case 6 -> myChannels();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + STOP);
            }
        }
    }

    public static void myChannels() {

    }

    public static void channels() {

    }

    public static void unBlock() {

    }

    public static void block() {

    }

    public static void myChats() {
        List<User> all = userService.getAll();
        for (int i = 0; i < all.size(); i++) {
            System.out.println(i + 1 + ". " + all.get(i).getName());
        }
        int index = inputInt("Choose") - 1;
        if (index < 0 || index >= all.size()) {
            System.out.println(RED + "Invalid choice!" + STOP);
            return;
        }
        int choose = getChoose();
        User user = all.get(index);
        if (Objects.equals(curUser, user)) {
            System.out.println(RED + "You can't send message to yourself" + STOP);
            return;
        }
        switch (choose) {
            case 1 -> sendMessage(user);
            case 2 -> showHistory(user);
        }
    }

    public static void search() {
        String userName = inputStr("UserName");
        User user = userService.findByUsername(userName);
        if (Objects.isNull(user) || Objects.equals(user.getUsername(), curUser.getUsername())) {
            System.out.println(RED + "User not found" + STOP);
            return;
        }
        System.out.println("\nName-> " + user.getName());
        int choose = getChoose();
        switch (choose) {
            case 1 -> sendMessage(user);
            case 2 -> showHistory(user);
        }
    }

    public static void showHistory(User user) {
        List<Chat> chats = chatService.getUsersAllChats(curUser.getId(), user.getId());
        if (Objects.isNull(chats))
            return;
        List<Message> messages = messageService.getMessageAll(chats);
        checkData(messages);
        if (Objects.isNull(messages))
            return;
        showMessages(messages, chats);
    }

    public static void showMessages(List<Message> messages, List<Chat> chats) {
        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            Chat chat = chats.get(i);
            if (Objects.equals(chat.getUserId1(), curUser.getId())) {
                System.out.println("                    " + message.getText() + (chat.getState() ? "✔✔" : "✔"));
            } else
                System.out.println(message.getText());

        }
    }

    public static int getChoose() {
        System.out.println("Do you have send message?\n1.Send message\t2.Show all message\t0.Back");
        return inputInt("Choose");
    }

    public static void sendMessage(User user) {
        String text = inputStr("Enter text");
        Chat chat = new Chat(curUser.getId(), user.getId());
        chatService.add(chat);
        boolean isWork = messageService.add(new Message(user.getId(), text, chat.getId()));
        notificationMessage("Message", "send", isWork);
    }

    public static void signIn() {
        String userName = inputStr("UserName");
        String password = inputStr("Password");
        curUser = userService.signIn(new LoginDTO(userName, password));
        boolean isWorked = Objects.nonNull(curUser);
        notificationMessage("User", "login", isWorked);
        if (!isWorked)
            return;
        System.out.println(GREEN + "\nUser information\n" + STOP + curUser + "\n");
        userProfile();
    }

    public static void signUp() {
        String name = inputStr("Name");
        String username = inputStr("UserName");
        String password = inputStr("Password");
        boolean isWork = userService.add(new User(name, username, password));
        notificationMessage("User", "sign up", isWork);
    }
}
