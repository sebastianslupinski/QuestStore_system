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
    private String id;


    public QuestModel(String id, String name, String description, int price){

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;

        quests.add(this);
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
                id, name, description, price);
    }

    public int getId() {
        return Integer.valueOf(this.id);
    }



}
