package Base;

import Interfaces.ITakeable;
import Items.Item;
import Items.ItemRegistery;

import java.util.ArrayList;

public class Inventory {

    //Propriété --------------------------------------------
    private static Inventory instance = null;
    private ArrayList<ITakeable> items = new ArrayList<>();
    private int inventorySize = 10;

    //Constructeur -----------------------------------------
    private Inventory() {

    }

    //Singleton -----------------------------------------------
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    //Méthodes ---------------------------------------------------------
    //Ajouter un item à l'inventaire
    public void addItem(ITakeable item) {
        if (getPlaceLeft() > 0) {
            this.items.add(item);
            Item cast = (Item) item;
            Player.getInstance().getLocation().removeLocalItem(cast);
            if (item != null) {
                System.out.println(item.toString() + " ajouté à l'inventaire.");
            }
        } else {
            System.out.println("Plus de place, déposez des objets pour en prendre de nouveaux.");
        }
    }

    //Retirer un item à l'inventaire
    public void removeItem(ITakeable item) {
        this.items.remove(item);
        Player.getInstance().getLocation().addLocalItem((Item) item);
        if (item != null) {
            System.out.println(item.toString() + " retiré de l'inventaire");
        }
    }

    //Revevoir tous les items dans notre inventaire
    public ArrayList<ITakeable> getAll() {
        return this.items;
    }

    //Savoir le nombre de place libre
    public int getPlaceLeft() {
        int placeLeft = 0;
        placeLeft = this.inventorySize - this.items.size();
        return placeLeft;
    }


    public boolean isInInventory(String itemName) {
        Item check = ItemRegistery.getInstance().getItemByName(itemName);
        if (this.items.contains(check)) {
            return true;
        } else {
            return false;
        }

    }

    public Item getItemFromInventory(String itemName) {
        Item item = ItemRegistery.getInstance().getItemByName(itemName);
        if (item != null) {
            if (this.items.contains(item)) {
                return item;
            } else {
                System.out.println("Cet objet n'est pas dans votre inventaire.");
                return null;
            }
        }
        return null;
    }

    //Getter ---------------------------------
    public int getCapacity() {
        return this.inventorySize;
    }

    public int getNumberOfItemsInside(){
        return  getCapacity()-getPlaceLeft();
    }


}
