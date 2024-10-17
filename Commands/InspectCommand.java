package Commands;

import Interfaces.ICommand;
import Items.Item;
import Items.ItemRegistery;

public class InspectCommand implements ICommand {
    private static InspectCommand instance = null;

    public static InspectCommand getInstance() {
        if (instance == null) {
            instance = new InspectCommand();
        }
        return instance;
    }

    public String getName() {
        return "Inspect";
    }

    public String getUsage() {
        return "Inspectez les objets, ils pourraient peut-être receller d'indices croustillants";
    }

    public String getDescription() {
        return "Commande pour inspecter les objets";
    }

    public void execute(String[] args) {
        if (hasValidArgs(args)) {
            for (int i = 1; i < args.length; i++) {
                Item inspected = ItemRegistery.getInstance().getItemByName(args[i]);
                if (inspected != null) {
                    System.out.println(inspected.getDescription());
                }
            }
        } else {
            System.out.println("Vous n'avez saisi aucun objet à inspecter :( ");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }
}
