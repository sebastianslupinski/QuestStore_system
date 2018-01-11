public abstract class Quest{
    public String name;
    public String description;
    public String category;
    public int reward;
    public boolean mark;
    public String label;

    public Quest(String name, String description, String category, int reward, boolean mark, String label){
        this.name = name;
        this.description = description;
        this.category = category;
        this.reward = reward;
        this.mark = false;
        this.label = label;
    }
}