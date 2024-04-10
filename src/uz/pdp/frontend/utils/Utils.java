package uz.pdp.frontend.utils;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public interface Utils {
    Scanner scannerStr = new Scanner(System.in);

    static Integer inputInt(String msg) {
        Scanner SCANNER_INT = new Scanner(System.in);
        System.out.print(msg + ": ");
        if (SCANNER_INT.hasNextInt()) {
            return SCANNER_INT.nextInt();
        } else {
            return inputInt(msg);
        }
    }

    static String inputStr(String msg) {
        System.out.print(msg + ": ");
        return scannerStr.nextLine();
    }

    static void checkData(List<?> list) {
        System.out.println(Objects.isNull(list) || list.isEmpty() ? RED + "Data base is empty" + STOP : GREEN + "----DATA----" + STOP);
    }

    static void notificationMessage(String objName, String action, boolean isWorked) {
        String message = isWorked ? " successfully " : " failed ";
        String color = isWorked ? GREEN : RED;
        System.out.println(color + objName + message + action + STOP);
    }

    String STOP = "\u001B[0m";
    String BLACK = "\u001B[30m";
    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";
    String YELLOW = "\u001B[33m";
    String BLUE = "\u001B[34m";
    String PURPLE = "\u001B[35m";
    String CYAN = "\u001B[36m";
    String WHITE = "\u001B[37m";
    String BACK_BLACK = "\u001B[40m";
    String BACK_RED = "\u001B[41m";
    String BACK_GREEN = "\u001B[42m";
    String BACK_YELLOW = "\u001B[43m";
    String BACK_BLUE = "\u001B[44m";
    String BACK_PURPLE = "\u001B[45m";
    String BACK_CYAN = "\u001B[46m";
    String BACK_WHITE = "\u001B[47m";
}

