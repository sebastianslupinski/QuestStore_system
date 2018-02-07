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
                                     "Edit quest",
                                     "Go back"};


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
                    QuestModel newQuest = this.createQuest();
                    questDB.saveNewQuestToDatabase(newQuest);
                    viewQuest.displayQuests(quests.getQuests());
                    break;
                case 2:
                    viewQuest.displayQuests(quests.getQuests());
                    break;
                case 3:
//                    viewQuest.displayQuests(quests.getQuests());
//                    this.editQuest(quests);
//                    questDB.updateEditedQuestInDatabase(quests);
                    QuestModel questToEdit = this.getQuest(quests);
                    this.editQuest(questToEdit);
                    questDB.updateEditedQuestInDatabase(questToEdit);
                    viewQuest.displayQuests(quests.getQuests());
                    break;
                case 4:
                    break;
            }
        }

    }

    public QuestModel createQuest() {
        Integer lastID = questDB.getLastId();
        String id = String.valueOf(lastID + 1);

        System.out.println("last id" + id);
        String name = InputController.getString("Please enter name of QuestModel: ");
        String description = InputController.getString("Please enter description of QuestModel: ");
        int price = InputController.getNumber("Please enter price of QuestModel: ");
        QuestModel newQuestModel = new QuestModel(id, name, description, price);
        QuestView.displayText("QuestModel created successfully, press enter to continue");

        return newQuestModel;
    }

    public QuestModel getQuest(QuestModel quest){
        boolean questNotChosen = true;
        Integer questIndex = 0;
        while(questNotChosen){
            viewQuest.displayQuests(quest.getQuests());
            questIndex = InputController.getNumber("Please enter a quest number");
            if (questIndex <quest.getQuests().size()){
                questNotChosen = false;
            }
            else {
                QuestView.displayText("Wrong number");
            }
        }
//        System.out.println("Akuku   "+quest.getQuests().get(Integer.valueOf(questIndex)));
        return quest.getQuests().get(Integer.valueOf(questIndex));
    }


    public void editQuest(QuestModel quest) {
        String[] options = {"Name", "Description", "Price", "Go back"};
        String header = "Edit:";
        int option = 1;
//        QuestModel questToEdit = getQuest(quest);


        while (!(option == 4)) {
            viewQuest.displayMenu(header, options);
            option = InputController.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    QuestView.displayText(quest.getName());
                    String newName = InputController.getString("Type new name");
                    quest.setName(newName);
                    break;
                case 2:
                    QuestView.displayText(quest.getDescription());
                    String newDescription = InputController.getString("Type new description");
                    quest.setDescription(newDescription);
                    break;
                case 3:
                    QuestView.displayInteger(quest.getPrice());
                    String newPrice = InputController.getString("Type new price");
                    quest.setPrice(Integer.parseInt(newPrice));
                    break;
                case 4:
                    break;
            }
        }
//        return questToEdit;
    }


}




