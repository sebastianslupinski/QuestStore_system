package view;

import model.QuestModel;

import java.util.ArrayList;

public class QuestView extends AbstractView {

  public static void displayQuest(ArrayList<QuestModel> quests){
    int index = 0;
    for (QuestModel quest : quests){
      System.out.println(index + "--->" + quest.toString());
      index++;
    }
  }

}
