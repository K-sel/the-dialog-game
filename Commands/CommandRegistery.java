package Commands;

import Base.Player;
import Base.World;
import Interfaces.ICommand;

import java.util.HashMap;

public class CommandRegistery {
    private static CommandRegistery instance = null;
    private HashMap<String, ICommand> commands;
    private World world;
    private Player player;

    //Constructeur ------------------------------------------------
    private CommandRegistery() {

        commands = new HashMap<>();

        ICommand quit = new QuitCommand();
        this.addCommand("quit", quit);

        ICommand help = HelpCommand.getInstance();
        this.addCommand("help", help);

        ICommand map = MapCommand.getInstance();
        this.addCommand("map", map);

        ICommand go = GoCommand.getInstance();
        this.addCommand("go", go);

        ICommand look = LookCommand.getInstance();
        this.addCommand("look", look);

        ICommand take = TakeCommand.getInstance();
        this.addCommand("take", take);

        ICommand read = ReadCommand.getInstance();
        this.addCommand("read", read);

        ICommand drop = DropCommand.getInstance();
        this.addCommand("drop", drop);

        ICommand inventory = InventoryCommand.getInstance();
        this.addCommand("inventory", inventory);

        ICommand inspect = InspectCommand.getInstance();
        this.addCommand("inspect", inspect);

        ICommand open = OpenCommand.getInstance();
        this.addCommand("open", open);

        ICommand solve = SolveCommand.getInstance();
        this.addCommand("solve", solve);
    }

    //Singleton ------------------------------------------------------
    public static CommandRegistery getInstance() {
        if (instance == null) {
            instance = new CommandRegistery();
        }
        return instance;
    }

    //Méthodes ------------------------------------------------
    public void addCommand(String name, ICommand command) {
        this.commands.put(name.toLowerCase(), command);
    }

    public void removeCommand(String name) {
        this.commands.remove(name.toLowerCase());
    }

    public ICommand getCommandByName(String name) {
        return this.commands.get(name.toLowerCase());
    }

    public HashMap<String, ICommand> getAllCommands() {
        return this.commands;
    }


}
