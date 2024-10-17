package Commands;

import Interfaces.ICommand;

import java.util.HashMap;

public class HelpCommand implements ICommand {
    //Propriétés -------------------------------------------
    private static HelpCommand instance = null;

    //Constructeur -------------------------------------------
    private HelpCommand() {
        //  this.commands =  CommandRegistery.getInstance().getAllCommands();
    }

    //Singleton --------------------------------------------------
    public static HelpCommand getInstance() {
        if (instance == null) {
            instance = new HelpCommand();
        }
        return instance;
    }

    //Getters -------------------------------------------
    public String getName() {
        return "Help";
    }

    public String getUsage() {
        return "Quand vous ne vous souvenez plus de quoi faire ou de manière générale pour voir ce quelles interactions s'offrent à vous.";
    }

    public String getDescription() {
        return "La commande help liste toutes les commandes du jeu ainsi que leurs informations";
    }

    //Execution de commande -------------------------------------------
    public void execute(String[] args) {
    /*
      Boucle foreach qui prends les clés de toutes les valeurs du HashMap et qui les stock
      dans une variable Sting appelée i. Avec cette String on peut :
      - Printer le nom de la clé (qui se trouve être le nom de la commande.
      - Printer la description de la commande grâce a la variable i qui est également la clé des valeurs du HashMap
     */

        HashMap<String, ICommand> commands = CommandRegistery.getInstance().getAllCommands();
        System.out.println("\u001B[31m"+"Pour saisir des noms composés --> \"nom composé\" "+"\u001B[0m");
        System.out.println();
        for (String key : commands.keySet()) {
            if (key.equalsIgnoreCase("quit")) {
                System.out.println("\u001B[31m"+"Commande >" + "\"" + commands.get(key).getName() + "\""+"\u001B[0m");
                System.out.println("Description : " + commands.get(key).getDescription());
                System.out.println("Quand utiliser : " + commands.get(key).getUsage());
                System.out.println();
            } else {
                System.out.println("Commande >" + "\"" + commands.get(key).getName() + "\"");
                System.out.println("Description : " + commands.get(key).getDescription());
                System.out.println("Quand utiliser : " + commands.get(key).getUsage());
                System.out.println();
            }
        }

    }

    public boolean hasValidArgs(String[] args) {
        return true;
    }
}
