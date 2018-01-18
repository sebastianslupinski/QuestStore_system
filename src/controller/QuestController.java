package src.controller;

import src.view.*;
import src.models.*;
import src.dao.*;
import java.util.ArrayList;


public class QuestController {
  public QuestDAOImplement newQuestDAO = new QuestDAOImplement();
  private ArrayList<String[]> questCollection = newQuestDAO.readDataFromFile();
  private InputController view = new InputController();

  public Quest createQuest() {
    String name = view.getString("Please enter name of Quest: ");
    String description = view.getString("Please enter description of Quest: ");
    int reward = view.getNumber("Please enter reward of Quest: ");
    String label = view.getString("Please enter labal of Quest: ");
    Quest newQuest = new Quest(name, description, reward, label);
    // questCollection.getQuest().add(newQuest);
    // QuestView.pressEnterToContinue("Quest created successfully, press enter to continue");

  }


}
