package view;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractView<T> {

    public static void displayText(String text) {
    System.out.println(text);
  }
    public static void displayInteger(int text) {
        System.out.println(text);
    }


    public void displayMenu(String header, String[] options) {
        int optionNumber = 1;
        AbstractView.displayText(header);

        for (String option : options) {
            AbstractView.displayText(optionNumber + "--->" + option);
            optionNumber ++;
        }
    }

    public void displayUsers(ArrayList<T> users) {
        int index = 0;

        for (T user : users) {
            AdminView.displayText(String.format("%d--->%s\n", index, user.toString()));
            index++;
        }
    }

    public void displayListOfObject(ArrayList<T> objects){
        int index = 0;
        for (T object : objects) {
            AbstractView.displayText(index + "--->" + object.toString());
            index++;
        }
    }
}

