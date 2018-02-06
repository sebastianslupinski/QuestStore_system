package controller;

import model.QuestModel;
import view.QuestView;
import dao.*;

import java.sql.Connection;
import java.util.ArrayList;


public class QuestController {

    private QuestDBImplement questDB;
    private QuestView viewQuest;
    private final String HEADER = "======= QUEST OPTION =======\n";
    private final String[] OPTIONS = {"Create new Quest",
                                     "Display all quest",
                                     "Edit quest"};


    public QuestController(Connection connection) {
        viewQuest = new QuestView();
        questDB = new QuestDBImplement(connection);

    }


    public void questOption() {

        QuestModel quests = questDB.getAllQuests();

        int option = 1;

        while(!(option == 4)) {
            viewQuest.displayMenu(HEADER, OPTIONS);
            option = InputController.getNumber("Choose option: ");
            switch (option){
                case 1:
                    System.out.println("crate quest");
                    break;
                case 2:
                    System.out.println("display all quest");
                    viewQuest.displayQuests(quests.getQuests());
                    break;
                case 3:
                    System.out.println("edit quest");
                    break;
            }
        }

    }

    public QuestModel createQuest() {
        String id = questDB.getLastId();
        System.out.println("last id" + id);
        String name = InputController.getString("Please enter name of QuestModel: ");
        String description = InputController.getString("Please enter description of QuestModel: ");
        int price = InputController.getNumber("Please enter price of QuestModel: ");
        String label = InputController.getString("Please enter labal of QuestModel: ");
        QuestModel newQuestModel = new QuestModel(id, name, description, price);
        QuestView.displayText("QuestModel created successfully, press enter to continue");
        questDB.saveNewQuestToDatabase(newQuestModel);

        return newQuestModel;
    }


}




