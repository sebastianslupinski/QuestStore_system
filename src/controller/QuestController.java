package controller;

import model.QuestModel;
import view.QuestView;
import dao.*;
import java.util.ArrayList;


public class QuestController {

    private QuestDBImplement questDB = new QuestDBImplement();
    private QuestView viewQuest = new QuestView();
    //  private QuestModel quest
//  private ArrayList<String[]> questCollection = newQuestDAO.readDataFromFile();
    private InputController view = new InputController();
    private ArrayList<String[]> questInfo = questDB.getAllQuests();


    public QuestModel createQuest() {
        String id = questDB.getLastId();
        System.out.println("last id" + id);
        String name = view.getString("Please enter name of QuestModel: ");
        String description = view.getString("Please enter description of QuestModel: ");
        int price = view.getNumber("Please enter price of QuestModel: ");
        String label = view.getString("Please enter labal of QuestModel: ");
        QuestModel newQuestModel = new QuestModel(id, name, description, price, label);
//      newQuestModel.getQuests().add(newQuestModel);
        QuestView.displayText("QuestModel created successfully, press enter to continue");
        questDB.saveNewQuestToDatabase(newQuestModel);

        return newQuestModel;
    }

    public void getInformationAboutAllQuests() {
//      ArrayList<String[]> questInfo = questDB.getAllQuests();
        viewQuest.displayQuest(questInfo);
    }

    public void selectOneQuest() {
        Integer id = InputController.getNumber("Please enter a quest number");
        questDB.getOneQuestbyID(id);
    }
}




