package src.controller;

import java.util.Scanner;
import java.util.InputMismatchException;
import src.view.QuestView;

public class InputController{
    QuestView view = new QuestView();

    public String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        view.displayText(message);
        String input = scanner.nextLine();
        return input;
    }

    public String getString(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public Integer getNumber(String message) {
        Boolean notDone = true;
        Integer output = 0;
        while (notDone) {
            try {
                Scanner scanner = new Scanner(System.in);
                view.displayText(message);
                output = scanner.nextInt();
                notDone = false;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Must be '123' format");
            }
        }
        return output;
    }
}
