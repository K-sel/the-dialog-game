package Commands;

import Base.Inventory;
import Interfaces.ICommand;
import Interfaces.ITakeable;
import Items.Item;

import java.util.ArrayList;

public class DropCommand implements ICommand {
    private static DropCommand instance = null;


    private DropCommand() {
    }

    public static DropCommand getInstance() {
        if (instance == null) {
            instance = new DropCommand();
        }
        return instance;
    }

    public String getName() {
        return "Drop";
    }

    public String getUsage() {
        return "Quand vous souhaitez retirer un objet de votre inventaire. Il tombe au sol mais ne disparais pas." +
                "\nVariante : La version drop all drop tous les items de l'inventaire.";
    }

    public String getDescription() {
        return "Commande servant à retirer des objets de votre inventaire.";
    }


    public void execute(String[] args) {
        if (hasValidArgs(args) && !args[1].equalsIgnoreCase("all")) {
            for (int i = 1; i < args.length; i++) {
                if (Inventory.getInstance().isInInventory(args[i])) {
                    Item droppedItem = Inventory.getInstance().getItemFromInventory(args[i]);
                    ((ITakeable) droppedItem).drop();
                } else {
                    System.out.println("Item " + args[i] + " ne se trouve pas dans l'inventaire");
                }
            }
        } else if (hasValidArgs(args) && args[1].equalsIgnoreCase("all")) {
            int size = Inventory.getInstance().getAll().size();
            ArrayList<ITakeable> objetsDrop = new ArrayList<ITakeable>();

            for (int i = 0; i < size; i++) {
                ITakeable takenall = Inventory.getInstance().getAll().get(i);
                objetsDrop.add((ITakeable) takenall);
            }
            if (objetsDrop.isEmpty()) {
                System.out.println("Vous n'avez rien dans votre inventaire.");
            } else {
                for (int i = 0; i < objetsDrop.size(); i++) {
                    objetsDrop.get(i).drop();
                }
            }

        } else {
            System.out.println("Vous n'avez rien saisi à retirer de votre inventaire :(");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }
}
