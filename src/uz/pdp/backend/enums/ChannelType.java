package uz.pdp.backend.enums;

import static uz.pdp.frontend.utils.Utils.*;

public enum ChannelType {
    PRIVATE,
    PUBLIC;
    public static ChannelType choose(){
        for (int i = 0; i < values().length; i++)
            System.out.println((i+1) + ": " + values()[i].name());
        int choose = inputInt("Choose")-1;
        if(choose < 0 || choose > values().length) {
            System.out.println(RED + "Invalid choice " + STOP);
            return choose();
        }
        return values()[choose];
    }
}
