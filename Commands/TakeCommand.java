package Commands;

import Base.Player;
import Interfaces.ICommand;
import Interfaces.ITakeable;
import Items.Item;

import java.util.ArrayList;

public class TakeCommand implements ICommand {
    private static TakeCommand instance = null;


    private TakeCommand() {
    }

    public static TakeCommand getInstance() {
        if (instance == null) {
            instance = new TakeCommand();
        }
        return instance;
    }

    public String getName() {
        return "Take";
    }

    public String getUsage() {
        return "Quand vous trouvez un objet que vous jugez important, gardez le ! On ne sait jamais, il pourrait servir..." +
                "\nVariante : La commande take all récupère tous les items récupérables d'une zone.";
    }

    public String getDescription() {
        return "Commander servant à récupérer les objets pouvants être récupérés";
    }

    public void execute(String[] args) {
        /*
        Premier bloc c'est pour récupèrer un seul item spécifique.
         */
        if (hasValidArgs(args) && !args[1].equalsIgnoreCase("all")) {
            for (int i = 1; i < args.length; i++) {
                Item taken = Player.getInstance().getLocation().getLocalItemByName(args[i]);
                if (taken instanceof ITakeable) {
                    ((ITakeable) taken).take();
                } else if (taken != null) {
                    System.out.println("Vous ne pouvez pas récupérer cet item");
                }
            }
        /*
        Ici c'est la commande take all, qui ramasse tous les items ramassables de la zone.
         */
        } else if (hasValidArgs(args) && args[1].equalsIgnoreCase("all")) {
            int size = Player.getInstance().getLocation().getAllLocalItems().size();
            ArrayList<ITakeable> objetsPris = new ArrayList<ITakeable>();
            for (int i = 0; i < size; i++) {
                Item takenall = Player.getInstance().getLocation().getAllLocalItems().get(i);
                if (takenall instanceof ITakeable) {
                    objetsPris.add((ITakeable) takenall);
                }
            }
            if (objetsPris.isEmpty()) {
                System.out.println("Il n'y à rien à récupérer.");
            } else {
                for (int i = 0; i < objetsPris.size(); i++) {
                    objetsPris.get(i).take();
                }
            }
        } else {
            System.out.println("Vous n'avez saisi aucun item à ramasser :(");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }

}
