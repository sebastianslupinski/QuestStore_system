package controller;

import model.QuestModel;
import view.QuestView;
import dao.*;
import java.util.ArrayList;


public class QuestController {
  public QuestDBImplement questDB= new QuestDBImplement();
//  private ArrayList<String[]> questCollection = newQuestDAO.readDataFromFile();
  private InputController view = new InputController();

  public QuestModel createQuest() {
    String id = questDB.getLastId();
      System.out.println("last id"+id);
    String name = InputController.getString("Please enter name of QuestModel: ");
    String description = InputController.getString("Please enter description of QuestModel: ");
    int reward = view.getNumber("Please enter reward of QuestModel: ");
    String label = InputController.getString("Please enter labal of QuestModel: ");
    QuestModel newQuestModel = new QuestModel(id, name, description, reward, label);
    QuestView.displayText("QuestModel created successfully, press enter to continue");
    questDB.saveNewQuestToDatabase(newQuestModel);

    return newQuestModel;

    }
  }



