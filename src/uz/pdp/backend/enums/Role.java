package uz.pdp.backend.enums;

import static uz.pdp.frontend.utils.Utils.inputInt;

/**
 * The Role enum represents the roles available for users.
 * It provides a method to choose a role interactively.
 */
public enum Role {

    USER,  // Represents a regular user role
    ADMIN, // Represents an administrator role
    BLOCK; // Represents a blocked user role

    /**
     * Allows the user to choose a role interactively.
     * @return The selected role.
     */
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
