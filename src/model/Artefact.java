package src.model;

public class ArtefactModel {

    private String label;
    private String name;
    private String description;
    private int price;
    private int id;
    private static int lastID = 0; // powinno wczytywac z pliku!

    public Artefact(String label, String name, String description, int price) {
        this.label = label;
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = lastID++;
    }

    public Artefact(String label, String name, String description, int price, int id) {
        this.label = label;
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }

    // !!!ta metoda bedzie wymieniona w momencie wczytania pliku z ostatnim id!!!
    // public Artefact(String label, String name, String description, int price) {
    //     this.label = label;
    //     this.name = name;
    //     this.description = description;
    //     this.price = price;
    //     this.id = ++lastID;
    // }

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