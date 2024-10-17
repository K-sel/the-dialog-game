package Commands;

import Base.Player;
import Base.World;
import Interfaces.ICommand;

public class GoCommand implements ICommand {

    //Propriétés -------------------------------------------
    private static GoCommand instance = null;
    private final Player player;
    private final World world;


    //Constructeur -------------------------------------------
    private GoCommand() {
        this.player = Player.getInstance();
        this.world = World.getInstance();
    }

    // Singleton -------------------------------------------------
    public static GoCommand getInstance() {
        if (instance == null) {
            instance = new GoCommand();
        }
        return instance;
    }

    //Getters -------------------------------------------
    public String getName() {
        return "Go";
    }

    public String getUsage() {
        return "Pour vous déplacer, vous avez 4 possibilités de déplacement (North/South/East/West)";
    }

    public String getDescription() {
        return "Cette commande sert a déplacer le joueur dans la map";
    }

    //Execution de commande -------------------------------------------
    public void execute(String[] args) {
        if (hasValidArgs(args)) {
            for (int i = 1; i <= args.length - 1; i++) {
                switch (args[i].toLowerCase()) {
                    case "north":
                        Player.getInstance().setLocationByCoordinates(Player.getInstance().getRow() - 1, Player.getInstance().getCol(), args[i].toLowerCase());
                        break;
                    case "south":
                        Player.getInstance().setLocationByCoordinates(Player.getInstance().getRow() + 1, Player.getInstance().getCol(), args[i].toLowerCase());
                        break;
                    case "east":
                        Player.getInstance().setLocationByCoordinates(Player.getInstance().getRow(), Player.getInstance().getCol() + 1, args[i].toLowerCase());
                        break;
                    case "west":
                        Player.getInstance().setLocationByCoordinates(Player.getInstance().getRow(), Player.getInstance().getCol() - 1, args[i].toLowerCase());
                        break;
                    default:
                        System.out.print("Direction non valide");
                        break;
                }
            }
            System.out.print("\nVous vous situez à "+Player.getInstance().getLocation().getName()+", "+Player.getInstance().getLocation().getDescription());
            System.out.println();
        } else {
            System.out.println("Vous n'avez saisi aucune direction :( ");
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args.length != 1;
    }
}
