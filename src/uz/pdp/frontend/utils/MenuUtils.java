package uz.pdp.frontend.utils;

import java.util.Scanner;

public interface MenuUtils {
    String MENU = """
                    ---Menu---
            1.Sign in 2.Sign up 0.Exit
            """;
    String USER = """
                                        ---Menu---
            1.Search  2.Channels  3.My Channels  4.Group  5. My Group  0.Back
            """;
    String CHANNEL = """
                    ---Menu---
            1.Search 2.Subscribe 0.Back
            """;
    String MY_CHANNEL = """
                       ---Menu---
            1.Post  2.Delete  3.Edit 0.Back
            """;
    String CHAT = """
                                --Menu--
            1.Send Message  2.Edit Message  3.Delete message  0.Back
            """;
    String GROUP = """
                        --Menu--
            1.Search  2.Subscribe  0.Back
            """;
    static int menu(String menu){
        System.out.print(menu + "\n-> ");
        return new Scanner(System.in).nextInt();
    }
}
