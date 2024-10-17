package Items;

public abstract class Item {

    private String description;
    private String name;


    public Item(String description, String name) {
        this.description = description;
        this.name = name;
    }

    //Getter
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
