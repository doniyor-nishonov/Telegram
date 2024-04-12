package uz.pdp.frontend.ui;

import uz.pdp.backend.model.user.User;
import static uz.pdp.frontend.view.login.LoginView.*;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.utils.MenuUtils.*;
public class UI {
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
