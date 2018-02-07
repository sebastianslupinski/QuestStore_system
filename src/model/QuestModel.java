package model;

import java.util.ArrayList;
import view.QuestView;

import static java.lang.String.valueOf;


public class QuestModel {



    private static ArrayList<QuestModel> quests = new ArrayList();
    public QuestView view = new QuestView();
    public String name;
    public String description;
    public int price;
    private String quest_id;


    public QuestModel(String quest_id, String name, String description, int price){

        this.quest_id = quest_id;
        this.name = name;
        this.description = description;
        this.price = price;

        quests.add(this);
    }

    public void updateQuestsCollection (QuestModel questToDelete){
        quests.remove(questToDelete);
//        return quests;
    }

    public String getName(){ return this.name; }

    public String getDescription(){ return this.description;}

    public int getPrice(){ return Integer.valueOf(this.price); }

    public static ArrayList<QuestModel> getQuests() {
        return quests;
    }

    public void setName(String newName) { this.name = newName; }

    public void setDescription(String newDescription) { this.description = newDescription;}

    public void setPrice(int newPrice) { this.price = newPrice;}


    public void addQuest(QuestModel quest) {quests.add(quest);}


    public String toString(){
        return String.format("Id.: %s\nName: %s\nDescription: %s\nPrice: %s\n",
                quest_id, name, description, price);
    }

    public int getId() {
        return Integer.valueOf(this.quest_id);
    }


//    public void updateQuestsCollection() {
//    }
}
