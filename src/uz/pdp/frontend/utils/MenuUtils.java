package uz.pdp.frontend.utils;

import static uz.pdp.frontend.utils.Utils.*;

public interface MenuUtils {
    String MENU = """
                    ---Menu---
            1.Sign in 2.Sign up 0.Exit
            """;
    String USER = """
                                        ---Menu---
            1.Search  2.MyChats  3.Channels  4.My Channels  5.Group  6.My Group  0.Back
            """;
    String CHANNEL = """
                             ---Menu---
            1.Create  2.Join  3.Leave  4.Channels  0.Back
            """;
    String MY_CHANNEL = """
                                  ---Menu---
            1.Post  2.Delete  3.Edit  4.Show Post  5.Subscribes  0.Back
            """;
    String CHAT = """
                                --Menu--
            1.Send  2.Edit  3.Delete  0.Back
            """;
    String GROUP = """
                             --Menu--
            1.Create  2.Join  3.Leave  4.Groups  0.Back
            """;
    String MY_GROUP = """
                                ---Menu---
            1.Send  2.Edit  3.Delete  4.Show  5.ShowUsers  0.Back
            """;
    String GROUP_CHAT = """
                                ---Menu---
            1.Send  2.Edit  3.Delete  4.Members  0.Back
            """;

    static int menu(String menu) {
        System.out.println(menu);
        return inputInt("Choose");
    }
}
