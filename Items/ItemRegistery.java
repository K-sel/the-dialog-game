package Items;

import Base.Location;
import Base.Player;
import Base.World;

import java.util.ArrayList;
import java.util.List;

public class ItemRegistery {

    private static ItemRegistery instance = null;
    private ArrayList<Item> allItems;


    private ItemRegistery() {
        this.allItems = new ArrayList<Item>();

        addItem(new Letter("Lettre ancienne déposée ici par un villageois qui à entendu que quelqu'un partait à l'aventure.", "Lettre étrange", "Vous êtes surement déja tombé sur le vieux coffre de Dawn.\nPersonne ne sait ce qu'il renferme mais la légende dis qu'il y serait enfermé un objet magique très utile.\nOn dit qu'il a été fabriqué a kiri, peut-être que la bas vous y trouverez plus d'infos."), "Ile de Dawn");
        addItem(new Chest("Coffre mythique de l'Ile de Dawn qui n'as jamais été ouvert.", "Vieux coffre"), "Ile de Dawn");
        addItem(new Enigm("Je suis changante, je peux devenir liquide, solide ou gazeuse.. " +
                "\n Qui suis-je ? ", "Enigme brumeuse","eau"), "Kiri");
    }

    public static ItemRegistery getInstance() {
        if (instance == null) {
            instance = new ItemRegistery();
        }
        return instance;
    }

    public void addItem(Item item, String locationName) {
        Location location = World.getInstance().getLocationByName(locationName.toLowerCase());

        if (location != null) {
            allItems.add(item);
            location.addLocalItem(item);
        } else {
            System.out.println("Impossible d'ajouter un item dans " + location);
        }
    }


    public void deleteItem(Item item, String locationName) {
        Location location = World.getInstance().getLocationByName(locationName);

        if (location != null) {
            allItems.remove(item);
            location.removeLocalItem(item);
        } else {
            System.out.println("Impossible de retirer l'item de " + location);
        }

    }

    public List<Item> getItemsAroundMe() {
        return Player.getInstance().getLocation().getAllLocalItems();
    }

    public List<Item> getAllItems() {
        return allItems;
    }

    public Item getItemByName(String name) {
        Item retrunedItem = null;
        for (int i = 0; i < this.allItems.size(); i++) {
            if (this.allItems.get(i).getName().equalsIgnoreCase(name)) {
                retrunedItem = this.allItems.get(i);
            }
        }
        if (retrunedItem == null) {
            System.out.println("Cet item n'existe pas");
        }
        return retrunedItem;
    }


}
