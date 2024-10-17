package Commands;

import Base.Inventory;
import Base.Player;
import Interfaces.ICommand;
import Items.Item;
import Interfaces.IOpenable;
import Items.Key;

public class OpenCommand implements ICommand {
    private static OpenCommand instance = null;

    public static OpenCommand getInstance() {
        if (instance == null) {
            instance = new OpenCommand();
        }
        return instance;
    }

    public String getName() {
        return "Open";
    }

    public String getUsage() {
        return "Utilisez cette commande pour ouvrir les coffres ou les zones de la map.";
    }

    public String getDescription() {
        return "A condition que vous ayez les bonnes clés dans votre inventaire...";
    }

    public void execute(String[] args) {
        if (hasValidArgs(args)) {
            for (int i = 1; i < args.length; i++) {
                Item object = Player.getInstance().getLocation().getLocalItemByName(args[i]);
                if (object instanceof IOpenable) {
                    if (haveKey((IOpenable) object) && !((IOpenable) object).isOpen()) {
                        ((IOpenable) object).open();
                    } else if (((IOpenable) object).isOpen()) {
                        System.out.println("Ce coffre est déja ouvert");
                    } else {
                        System.out.println("Vous ne possèdez pas la clé pour ouvrir cette objet");
                    }
                } else if (object != null) {
                    System.out.println(object.getName() + " ne peut pas être ouvert.");
                }
            }
        } else {
            System.out.println("Vous n'avez saisi aucun objet à ouvrir :( ");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }

    public boolean haveKey(IOpenable object) {
        boolean result = false;
        for (int i = 0; i < Inventory.getInstance().getNumberOfItemsInside(); i++) {
            Item item = (Item) Inventory.getInstance().getAll().get(i);
            if (item instanceof Key) {
                if (object.getId() == ((Key) item).getId()) {
                    result = true;
                }
            }
        }
        return result;
    }
}


