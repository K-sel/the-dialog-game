package Commands;

import Base.Player;
import Interfaces.ICommand;
import Interfaces.ISolvable;
import Items.Item;

public class SolveCommand implements ICommand {
    private static SolveCommand instance = null;

    public static SolveCommand getInstance() {
        if (instance == null) {
            instance = new SolveCommand();
        }
        return instance;
    }

    public String getName() {
        return "Solve";
    }

    public String getUsage() {
        return "Quand vous souhaitez donner une réponse à une énigme.";
    }

    public String getDescription() {
        return "Vous pouvez résoudre les énigmes grâce à cette commande";
    }

    public void execute(String[] args) {
        if (hasValidArgs(args)) {
            for (int i = 1; i < args.length; i++) {
                Item solved = Player.getInstance().getLocation().getLocalItemByName(args[i]);;
                if (solved instanceof ISolvable) {
                    ((ISolvable) solved).solve();
                } else if (solved != null) {
                    System.out.println(solved.getName() + " n'est pas une énigme.");
                }
            }
        } else {
            System.out.println("Vous n'avez saisi aucune énigme à résoudre :( ");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }
}
