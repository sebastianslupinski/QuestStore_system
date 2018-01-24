package view;

import model.*;

import java.util.*;

public class QuestView extends ViewAbstract{

  public static void displayQuest(ArrayList<Quest> quests){
    int index = 0;
    for (Quest quest : quests){
      System.out.println(index + "--->" + quest.toString());
      index++;
    }
  }

}
