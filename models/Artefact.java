package models;

public class Artefact {

    private String label;
    private String name;
    private String description;
    private int price;

    public Artefact(String label, String name, String description, int price) {
        this.label = label;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String newLabel) {
        this.label = newLabel;
    }

    public String getName() {
        return this.label;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }
}