package uz.pdp.frontend.view.user;

import static uz.pdp.frontend.utils.MenuUtils.*;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.view.channel.ChannelView.*;
import static uz.pdp.frontend.view.chat.ChatView.*;
import static uz.pdp.frontend.view.group.GroupView.*;
public class UserView {
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
}
