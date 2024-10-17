package Base;

import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Location {

    //Propriétés -------------------------------------------
    private String description;
    private String name;
    private boolean isOpen;
    private List<Item> localItems;

    //Constructor -------------------------------------------
    public Location(String description, String name, boolean isOpen) {
        this.description = description;
        this.name = name.toLowerCase();
        this.isOpen = isOpen;
        this.localItems = new ArrayList<>();
    }

    //Setter ------------------------------------------------
    public void setLockState(boolean state) {
        this.isOpen = state;
    }


    //Getters -----------------------------------------------
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setOpen(){
        this.isOpen = true;
    }

    public List<Item> getAllLocalItems() {
        return this.localItems;
    }

    public Item getLocalItemByName(String ItemName) {
        Item localItem = null;
        for (Item item : this.localItems) {
            if (item.getName().toLowerCase().equals(ItemName.toLowerCase())) {
                localItem =  item;
            }
        }
        if (localItem == null) {
            System.out.println("Cet item n'existe pas");
        }
        return localItem;
    }

    public void addLocalItem(Item item) {
        this.localItems.add(item);
    }

    public void removeLocalItem(Item item) {
        this.localItems.remove(item);
    }

}
