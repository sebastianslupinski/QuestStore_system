public class Quest{

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

    public String getName(){ return name; }

    public String getDescription(){ return description;}

    public int getReward(){ return reward; }

    public boolean getMark() { return mark; }

    public String getLabel() { return label; }

    public void setName(String newName) { this.name = newName; }

    public void setDescription(String newDescription) { this.description = description;}

    public void setReward(int newReward) { this.reward = newReward;}

    public void setLabel(String newLabel) { this.label = newLabel;}

    public void changeMark(){
        if (this.mark){
            this.mark = false;
        }
        else {
            this.mark = true;
        }
    }
}