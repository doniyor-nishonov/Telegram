package uz.pdp.frontend.view.login;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.user.UserService;
import uz.pdp.backend.service.user.UserServiceImp;

import java.util.Objects;

import static uz.pdp.frontend.ui.UI.curUser;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.view.UserView.*;

public class LoginView {
    private static final UserService userService = UserServiceImp.getInstance();

    public static void signIn() {
        String userName = inputStr("UserName");
        String password = inputStr("Password");
        curUser = userService.signIn(new LoginDTO(userName, password));
        boolean isWorked = Objects.nonNull(curUser);
        notificationMessage("User", "login", isWorked);
        if (!isWorked)
            return;
        System.out.println(GREEN + "\nWelcome " + STOP + curUser.getName() + "\n");
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
