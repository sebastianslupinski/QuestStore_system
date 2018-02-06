package view;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractView<T> {

    public static void displayText(String text) {
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
            AdminView.displayText(index + "--->" + user.toString());
            index++;
        }
    }

  public void displayQuests(ArrayList<T> quests){
    int index = 0;
    for (T quest : quests){
//        AbstractView.displayText(index + "--->" + Arrays.toString((Object[]) quest));
        AbstractView.displayText(index + "--->" + quest.toString());


        index++;
    }
  }


}

