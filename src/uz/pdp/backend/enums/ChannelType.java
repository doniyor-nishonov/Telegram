package uz.pdp.backend.enums;

import static uz.pdp.frontend.utils.Utils.*;

/**
 * The ChannelType enum represents the types of channels available.
 * It provides methods to choose a channel type interactively.
 */
public enum ChannelType {

    PRIVATE, // Represents a private channel
    PUBLIC; // Represents a public channel

    /**
     * Allows the user to choose a channel type interactively.
     * @return The selected channel type.
     */
    public static ChannelType choose() {
        for (int i = 0; i < values().length; i++)
            System.out.println((i + 1) + ": " + values()[i].name());

        int choose = inputInt("Choose") - 1;

        if (choose < 0 || choose > values().length) {
            System.out.println(RED + "Invalid choice " + STOP);
            return choose();
        }

        return values()[choose];
    }
}
