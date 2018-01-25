package controller;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputController{

    public static String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();
        return input;
    }

    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static Integer getNumber(String message) {
        Boolean notDone = true;
        Integer output = 0;
        while (notDone) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(message);
                output = scanner.nextInt();
                notDone = false;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Must be '123' format");
            }
        }
        return output;
    }
}
