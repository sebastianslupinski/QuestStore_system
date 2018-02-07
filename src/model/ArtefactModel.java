package model;

public class ArtefactModel {

    private String name;
    private String description;
    private int price;
    private int id;
    private int status;
    // private static int lastID = 0; // powinno wczytywac z pliku!

    public ArtefactModel(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        //this.id = lastID++;
        this.status = 1;
    }

    public ArtefactModel(String name, String description, int price, int id, int status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
        this.status = status;
    }

    public String getName() {
        return this.name;
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

    @Override
    public String toString() {
        return String.format("Artefact name: %s.\nDescription: %s.\nPrice: %d.", name, description, price);
    }
}