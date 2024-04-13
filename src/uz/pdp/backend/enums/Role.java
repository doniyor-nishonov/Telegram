package uz.pdp.backend.enums;

import static uz.pdp.frontend.utils.Utils.inputInt;

public enum Role {
    USER,
    ADMIN;
    public static Role choose() {
        int i = 1;
        for (Role value : values())
            System.out.println(i + ". " + value);
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > values().length)
            return choose();
        return values()[index];
    }
}
