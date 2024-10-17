package Saves;

import Base.Inventory;
import Interfaces.ICommand;
import Interfaces.IReadable;
import Interfaces.IUsable;
import Items.Item;

public class UseCommand implements ICommand {
    private static UseCommand instance = null;

    public static UseCommand getInstance() {
        if (instance == null) {
            instance = new UseCommand();
        }
        return instance;
    }

    public String getName() {
        return "Use";
    }

    public String getUsage() {
        return "Vous pouvez utiliser certains objets tels que les clés ou autres";
    }

    public String getDescription() {
        return "Commande pour utiliser un objet présent dans l'inventaire";
    }

    public void execute(String[] args) {
        if (hasValidArgs(args)) {
            for (int i = 1; i < args.length; i++) {
                Item used = Inventory.getInstance().getItemFromInventory(args[i]);
                if (used instanceof IUsable) {
                    ((IUsable) used).use();
                } else if (used != null) {
                    System.out.println(used.getName() + " ne peut pas être utilisé.");
                    if (used instanceof IReadable) {
                        System.out.println("Utilisez la commande read pour les objets à lire.");
                    }
                }
            }
        } else {
            System.out.println("Vous n'avez saisi aucun objet à utiliser :( ");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }
}
