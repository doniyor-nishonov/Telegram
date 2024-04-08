package uz.pdp.frontend.ui;

import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.channel.ChannelService;
import uz.pdp.backend.service.channel.ChannelServiceImp;
import uz.pdp.backend.service.chat.ChatService;
import uz.pdp.backend.service.chat.ChatServiceImp;
import uz.pdp.backend.service.message.MessageService;
import uz.pdp.backend.service.message.MessageServiceImp;
import uz.pdp.backend.service.post.PostService;
import uz.pdp.backend.service.post.PostServiceImp;
import uz.pdp.backend.service.subscript.SubscriptService;
import uz.pdp.backend.service.subscript.SubscriptServiceImp;
import uz.pdp.backend.service.user.UserService;
import uz.pdp.backend.service.user.UserServiceImp;

import static uz.pdp.frontend.Utils.*;
import static uz.pdp.frontend.user.UserController.*;
public class UI {
    public static UserService userService = new UserServiceImp();
    public static ChannelService channelService = new ChannelServiceImp();
    public static ChatService chatService = new ChatServiceImp();
    public static PostService postService = new PostServiceImp();
    public static MessageService messageService = new MessageServiceImp();
    public static SubscriptService subscriptService = new SubscriptServiceImp();
    public static User curUser;
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        System.out.println(GREEN + "Welcome to Telegram App" + STOP);
        while (true) {
            System.out.print(MENU);
            int choose = inputInt("Choose");
            switch (choose) {
                case 1 -> signIn();
                case 2 -> signUp();
                case 0 -> {
                    System.out.println(YELLOW + "Bye Bye" + STOP);
                    System.exit(0);
                }
                default -> System.out.println(RED + "Invalid choice!" + STOP);
            }
        }
    }
}
