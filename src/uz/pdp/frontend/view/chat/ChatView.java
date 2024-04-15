package uz.pdp.frontend.view.chat;

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

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static uz.pdp.frontend.ui.UI.curUser;
import static uz.pdp.frontend.utils.MenuUtils.CHAT;
import static uz.pdp.frontend.utils.MenuUtils.menu;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.utils.Utils.notificationMessage;

public class ChatView {
    private static final UserService userService = UserServiceImp.getInstance();
    private static final ChatService chatService = ChatServiceImp.getInstance();
    private static final MessageService messageService = MessageServiceImp.getInstance();

    public static void myChats() {
        List<String> usersID = chatService.getUserChats(curUser.getId());
        List<User> users = new ArrayList<>();
        for (String id : usersID) {
            User user = userService.get(id);
            if(!Objects.equals(curUser.getId(), user.getId()))
                users.add(user);
        }
        checkData(users);
        if (users.isEmpty())
            return;
        for (int i = 0; i < users.size(); i++)
            System.out.println((i + 1) + ": " + users.get(i).getName());
        int choose = inputInt("Choose") - 1;
        if (choose < 0 || choose >= users.size())
            return;
        User user = users.get(choose);
        chatMessage(user.getId());
    }

    public static void search() {
        String userName = inputStr("UserName");
        User user = userService.findByUsername(userName);
        if (Objects.equals(curUser, user)) {
            System.out.println(RED + "You cannot send a chatMessage yourself" + STOP);
            return;
        }
        if (Objects.isNull(user)) {
            System.out.println(RED + "User not found!" + STOP);
            return;
        }
        chatMessage(user.getId());
    }

    public static void chatMessage(String id) {
        while (true) {
            System.out.println(GREEN + "User-> " + STOP + userService.get(id).getName() + "\n");
            int menu = menu(CHAT);
            switch (menu) {
                case 1 -> sendMessage(id);
                case 2 -> updateMessage(id);
                case 3 -> deleteMessage(id);
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + STOP);
            }
        }
    }

    private static void updateMessage(String id) {
        Chat chat = chatService.findOrCreate(curUser.getId(), id,MessageType.CHAT);
        List<Message> messageAll = messageService.getMyMessage(chat);
        if (messageAll.isEmpty())
            return;
        checkData(messageAll);
        for (int i = 0; i < messageAll.size(); i++)
            System.out.println((i + 1) + ". " + messageAll.get(i));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index >= messageAll.size())
            return;
        Message message = messageAll.get(index);
        String newMessage = inputStr("New Message");
        message.setText(newMessage);
        boolean update = messageService.update(message.getId(), message);
        notificationMessage("Message", "edit", update);
    }

    private static void deleteMessage(String id) {
        Chat chat = chatService.findOrCreate(curUser.getId(), id,MessageType.CHAT);
        List<Message> messageAll = messageService.getMyMessage(chat);
        if (messageAll.isEmpty())
            return;
        checkData(messageAll);
        for (int i = 0; i < messageAll.size(); i++)
            System.out.println((i + 1) + ". " + messageAll.get(i));
        int index = inputInt("Choose") - 1;
        if (index < 0 || index >= messageAll.size())
            return;
        String chatId = messageAll.get(index).getChatId();
        chatService.delete(chatId);
        boolean delete = messageService.delete(messageAll.get(index).getId());
        notificationMessage("Message", "delete", delete);
    }

    private static void showHistory(String user) {
        Chat chat = chatService.findOrCreate(curUser.getId(), user,MessageType.CHAT);
        List<Message> messageAll = messageService.getMessageAll(chat, curUser.getId());
        if (Objects.isNull(messageAll))
            return;
        printMessage(messageAll,user);
    }

    private static void printMessage(List<Message> messageAll,String userId) {
        for (Message message : messageAll) {
            if (Objects.equals(userId,message.getSenderId()))
                System.out.println("                    " + message);
            else
                System.out.printf("""
                        %s
                        %s
                        %n""", message.getText(), message.getCreatedAt().format(DateTimeFormatter.ofPattern("HH:mm")));
        }
    }

    private static void sendMessage(String id) {
        Chat chat = chatService.findOrCreate(curUser.getId(), id,MessageType.CHAT);
        while (true) {
            showHistory(id);
            String text = inputStr("[0.Back]Enter text");
            if (Objects.equals(text, "0")) {
                return;
            }
            Message message = new Message(text, id, chat.getId(), MessageType.CHAT);
            boolean isWorked = messageService.add(message);
            notificationMessage("Message", "send", isWorked);
        }
    }
}
