package src.model;

import java.util.ArrayList;
import src.view.*;


public class Quest{

  private ArrayList<Quest> quests = new ArrayList();
  public QuestView view = new QuestView();

    public String name;
    public String description;
    public String category;
    public int reward;
    public boolean mark;
    public String label;

    public Quest(String name, String description, int reward, String label){

        this.name = name;
        this.description = description;
        this.reward = reward;
        this.mark = false;
        this.label = label;
    }

    public String getName(){ return this.name; }

    public String getDescription(){ return this.description;}

    public int getReward(){ return this.reward; }

    public boolean getMark() { return this.mark; }

    public String getLabel() { return this.label; }

    public void setName(String newName) { this.name = newName; }

    public void setDescription(String newDescription) { this.description = description;}

    public void setReward(int newReward) { this.reward = newReward;}

    public void setLabel(String newLabel) { this.label = newLabel;}

    public String toString(){
      return "{name:"+this.name+" description:"+this.description+" reward:"+this.reward+" label:"+this.label+"}";
    }

    public ArrayList<Quest> getQuests(){
      return quests;
    }

    public Quest getQuest(){
        boolean questNotChosen = true;
        Integer questIndex = 0;
        while(questNotChosen){
            view.displayQuest(getQuests());
            String userInput = view.getInput("Choose quest number");
            questIndex = Integer.parseInt(userInput);
            if (questIndex < quests.size()) {
                questNotChosen = false;
            }
        }
        return quests.get(questIndex);
    }

    public void changeMark(){
        if (this.mark){
            this.mark = false;
        }
        else {
            this.mark = true;
        }
    }
}
