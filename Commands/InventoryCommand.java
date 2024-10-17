package Commands;

import Base.Inventory;
import Interfaces.ICommand;
import Interfaces.ITakeable;

public class InventoryCommand implements ICommand {
    private static InventoryCommand instance = null;

    private InventoryCommand() {

    }

    public static InventoryCommand getInstance() {
        if (instance == null) {
            instance = new InventoryCommand();

        }
        return instance;
    }

    public String getName() {
        return "Inventory";
    }

    public String getUsage() {
        return "Quand vous souhaitez savoir ce qu'il y'a dans votre inventaire";
    }

    public String getDescription() {
        return "Cette commande vous affiche le contenu de votre inventaire ainsi que la place restante.";
    }

    public void execute(String[] args) {
        if (Inventory.getInstance().getPlaceLeft() == Inventory.getInstance().getCapacity()) {
            System.out.println("Votre inventaire est vide.");
        } else {
            System.out.println("Contenu de l'inventaire : ");
            for (ITakeable itemFromInv : Inventory.getInstance().getAll()) {
                System.out.println("  • " + itemFromInv.toString());
            }
            System.out.println("Place restante : " + Inventory.getInstance().getPlaceLeft());
        }
    }

    public boolean hasValidArgs(String[] args) {
        return true;
    }

}
