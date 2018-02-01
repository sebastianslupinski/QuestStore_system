package view;

import java.util.ArrayList;

public abstract class AbstractView<T> {

  public static void displayText(String text) {
    System.out.println(text);
  }

  public void displayMenu(String header, String[] options) {
    int optionNumber = 1;

    for (String option : options) {
      AbstractView.displayText(optionNumber + "--->" + option);
      optionNumber ++;
    }
  }

  public void displayUsers(ArrayList<T> users) {
    int index = 0;
    for (T user : users){
      AdminView.displayText(index + "--->" + user.toString());
      index++;
    }
  }
}