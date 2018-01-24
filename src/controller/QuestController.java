package controller;

import model.QuestModel;
import dao.*;
import java.util.ArrayList;


public class QuestController {
  public QuestDAOImplement newQuestDAO = new QuestDAOImplement();
  private ArrayList<String[]> questCollection = newQuestDAO.readDataFromFile();
  private InputController view = new InputController();

  public QuestModel createQuest() {
    String name = InputController.getString("Please enter name of QuestModel: ");
    String description = InputController.getString("Please enter description of QuestModel: ");
    int reward = view.getNumber("Please enter reward of QuestModel: ");
    String label = InputController.getString("Please enter labal of QuestModel: ");
    QuestModel newQuestModel = new QuestModel(name, description, reward, label);
    // questCollection.getQuest().add(newQuestModel);
    // QuestView.pressEnterToContinue("QuestModel created successfully, press enter to continue");
    return newQuestModel;
  }


}
