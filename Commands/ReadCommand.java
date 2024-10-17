package Commands;

import Base.Inventory;
import Interfaces.ICommand;
import Interfaces.IReadable;
import Interfaces.IUsable;
import Items.Item;

public class ReadCommand implements ICommand {
    private static ReadCommand instance = null;

    public static ReadCommand getInstance() {
        if (instance == null) {
            instance = new ReadCommand();
        }
        return instance;
    }

    public String getName() {
        return "Read";
    }

    public String getUsage() {
        return "Lisez cette lettre, il pourrait se cacher des indices importants...";
    }

    public String getDescription() {
        return "Commande pour lire les lettres que vous trouvez";
    }

    public void execute(String[] args) {
        if (hasValidArgs(args)) {
            for (int i = 1; i < args.length; i++) {
                Item red = Inventory.getInstance().getItemFromInventory(args[i]);
                if (red instanceof IReadable) {
                    ((IReadable) red).read();
                } else if (red != null) {
                    System.out.println(red.getName() + " ne peut pas être lu.");
                    if (red instanceof IUsable) {
                        System.out.println("Utilisez la commande use pour utiliser des objets.");
                    }
                }
            }
        } else {
            System.out.println("Vous n'avez saisi aucun objet à lire :( ");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }
}
