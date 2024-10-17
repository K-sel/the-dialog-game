package Commands;

import Base.Player;
import Interfaces.ICommand;

public class GoToCommand implements ICommand {
    private static GoToCommand instance = null;

    private GoToCommand() {

    }

    public static GoToCommand getInstance() {
        if (instance == null) {
            instance = new GoToCommand();

        }
        return instance;
    }

    public String getName() {
        return "GoTo";
    }

    public String getUsage() {
        return "Utilisée pour aller directement à un endroit en écrivant son nom plutôt que ses coordonnées.";
    }

    public String getDescription() {
        return "Si vous savez exactement ou vous souhaitez aller, cette commande est faite pour vous. Attention à l'orthographe !";
    }

    public void execute(String[] args) {
        if (hasValidArgs(args)) {
            for (int i = 1; i <= args.length - 1; i++) {
                Player.getInstance().setLocationByName(args[i]);
            }
        } else {
            System.out.println("Vous n'avez saisi aucune destination :( ");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }
}
