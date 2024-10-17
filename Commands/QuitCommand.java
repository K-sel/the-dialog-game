package Commands;

import Interfaces.ICommand;

public class QuitCommand implements ICommand {
    private static QuitCommand instance = null;

    public static QuitCommand getInstance() {
        if (instance == null) {
            instance = new QuitCommand();
        }
        return instance;
    }

    public String getName() {
        return "Quit";
    }

    public String getUsage() {
        return "Pour quitter le jeu - Attention pas de sauvegarde.";
    }

    public String getDescription() {
        return "quitter le jeu.";
    }

    public void execute(String[] args) {
        if (hasValidArgs(args)) {
            System.out.println("Quitting game...Thanks for playing");
            System.exit(0);
        }
    }

    public boolean hasValidArgs(String[] args) {
        return args[0].equalsIgnoreCase("quit");
    }
}


