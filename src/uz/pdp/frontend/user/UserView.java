package uz.pdp.frontend.user;
import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.chat.ChatService;
import uz.pdp.backend.service.chat.ChatServiceImp;
import uz.pdp.backend.service.message.MessageService;
import uz.pdp.backend.service.message.MessageServiceImp;
import uz.pdp.backend.service.user.UserService;
import uz.pdp.backend.service.user.UserServiceImp;

import static uz.pdp.frontend.utils.MenuUtils.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.ui.UI.*;

public class UserView {
    private static final UserService userService = UserServiceImp.getInstance();
    private static final ChatService chatService = ChatServiceImp.getInstance();
    private static final MessageService messageService = MessageServiceImp.getInstance();

    public static void userProfile() {
        while (true) {
            switch (menu(USER)) {
                case 1 -> search();
                case 2 -> myChats();
                case 3 -> channels();
                case 4 -> myChannels();
                case 5 -> group();
                case 6 -> myGroup();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + STOP);
            }
        }
    }

    private static void myChats() {

    }

    private static void myGroup() {

    }

    private static void group() {

    }

    public static void myChannels() {

    }

    public static void channels() {

    }

    public static void search() {
        String userName = inputStr("UserName");
        User user = userService.findByUsername(userName);
        if (Objects.isNull(user)) {
            System.out.println(RED + "User not found!" + STOP);
            return;
        }
        while (true) {
            System.out.println(GREEN + "User-> " + STOP + user.getName() + "\n");
            int menu = menu(CHAT);
            switch (menu) {
                case 1 -> sendMessage(user);
                case 2 -> updateMessage(user);
                case 3 -> deleteMessage(user);
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + STOP);
            }
        }
    }

    private static void updateMessage(User user) {
        List<Chat> myChats = chatService.getMyChats(curUser.getId(),user.getId());
        List<Message> messageAll = messageService.getMyMessage(myChats, curUser.getId());
        for (int i = 0; i < messageAll.size(); i++)
            System.out.println((i+1)+". " + messageAll.get(i));
        int index = inputInt("Choose")-1;
        if(index<0 || index>=myChats.size())
            return;
        Message message = messageAll.get(index);
        String newMessage = inputStr("New Message");
        message.setText(newMessage);
        boolean update = messageService.update(message.getId(), message);
        notificationMessage("Message","edit",update);
    }

    private static void deleteMessage(User user) {

    }

    public static void showHistory(User user) {
        List<Chat> chats = chatService.getUsersAllChats(curUser.getId(), user.getId());
        if (Objects.isNull(chats))
            return;
        List<Message> messageAll = messageService.getMessageAll(chats, curUser.getId());
        if (Objects.isNull(messageAll))
            return;
        printMessage(messageAll);
    }

    private static void printMessage(List<Message> messageAll) {
        for (Message message : messageAll) {
            Chat chat = chatService.get(message.getChatId());
            if (Objects.equals(chat.getId1(), curUser.getId()))
                System.out.println("            " + message);
            else
                System.out.printf("""
                        %s
                            %s
                        %n""", message.getText(), message.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }
    }

    public static void sendMessage(User user) {
        showHistory(user);
        String text = inputStr("[0.Back]Enter text");
        if(Objects.equals(text,"0"))
            return;
        Chat chat = new Chat(curUser.getId(), user.getId());
        chatService.add(chat);
        Message message = new Message(text, chat.getId(), MessageType.USER);
        boolean isWorked = messageService.add(message);
        notificationMessage("Message", "send", isWorked);
    }


}
