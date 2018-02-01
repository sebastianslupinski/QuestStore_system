package model;

import java.util.ArrayList;
import view.QuestView;


public class QuestModel {

    private ArrayList<QuestModel> quests = new ArrayList();
    public QuestView view = new QuestView();
    public String name;
    public String description;
    public int price;
    public boolean mark;
    public String label;
    private String id;

    public QuestModel(String id, String name, String description, int price, String label){

        this.name = name;
        this.description = description;
        this.price = price;
        this.mark = false;
        this.label = label;
    }

    public String getName(){ return this.name; }

    public String getDescription(){ return this.description;}

    public int getPrice(){ return this.price; }

    public boolean getMark() { return this.mark; }

    public String getLabel() { return this.label; }

    public void setName(String newName) { this.name = newName; }

    public void setDescription(String newDescription) { this.description = description;}

    public void setPrice(int newPrice) { this.price = newPrice;}

    public void setLabel(String newLabel) { this.label = newLabel;}

    public String toString(){
      return "{name:"+this.name+" description:"+this.description+" price:"+this.price+" label:"+this.label+"}";
    }

    public ArrayList<QuestModel> getQuests(){ return quests; }

    // public QuestModel getQuest(){
    //     boolean questNotChosen = true;
    //     Integer questIndex = 0;
    //     while(questNotChosen){
    //         view.displayQuest(getQuests());
    //         String userInput = view.getInput("Choose quest number");
    //         questIndex = Integer.parseInt(userInput);
    //         if (questIndex < quests.size()) {
    //             questNotChosen = false;
    //         }
    //     }
    //     return quests.get(questIndex);
    // }

    public void changeMark(){
        if (this.mark){
            this.mark = false;
        }
        else {
            this.mark = true;
        }
    }

    public String getId() {
        return this.id;
    }



}
