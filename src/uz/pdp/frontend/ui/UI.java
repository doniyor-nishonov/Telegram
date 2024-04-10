package uz.pdp.frontend.ui;

import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.channel.ChannelService;
import uz.pdp.backend.service.channel.ChannelServiceImp;
import uz.pdp.backend.service.chat.ChatService;
import uz.pdp.backend.service.chat.ChatServiceImp;
import uz.pdp.backend.service.group.GroupService;
import uz.pdp.backend.service.group.GroupServiceImp;
import uz.pdp.backend.service.message.MessageService;
import uz.pdp.backend.service.message.MessageServiceImp;
import uz.pdp.backend.service.post.PostService;
import uz.pdp.backend.service.post.PostServiceImp;
import uz.pdp.backend.service.subscript.SubscriptService;
import uz.pdp.backend.service.subscript.SubscriptServiceImp;
import uz.pdp.backend.service.userGroup.UserGroupService;
import uz.pdp.backend.service.userGroup.UserGroupServiceImp;
import static uz.pdp.frontend.login.LoginView.*;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.user.UserView.*;
import static uz.pdp.frontend.utils.MenuUtils.*;
public class UI {
    public static ChannelService channelService = ChannelServiceImp.getInstance();
    public static ChatService chatService = ChatServiceImp.getInstance();
    public static PostService postService = PostServiceImp.getInstance();
    public static MessageService messageService = MessageServiceImp.getInstance();
    public static GroupService groupService = GroupServiceImp.getInstance();
    public static UserGroupService userGroupService = UserGroupServiceImp.getInstance();
    public static SubscriptService subscriptService = SubscriptServiceImp.getInstance();
    public static User curUser;
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        System.out.println(GREEN + "Welcome to Telegram App" + STOP);
        while (true) {
            int choose = menu(MENU);
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
