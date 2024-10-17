package Commands;

import Interfaces.ICommand;
import Items.Item;
import Items.ItemRegistery;

public class LookCommand implements ICommand {
    private static LookCommand instance = null;

    private LookCommand() {
    }

    public static LookCommand getInstance() {
        if (instance == null) {
            instance = new LookCommand();
        }
        return instance;
    }

    public String getName() {
        return "Look";
    }

    public String getUsage() {
        return "Quand vous arrivez dans une nouvelles zone, faites cette commande pour avoir une vue d'ensemble des objets présents autour de vous. \n Il pourrait se cacher des indices importants...";
    }

    public String getDescription() {
        return "Commande pour voir/prendre connaissance des objets présents dans la zone.";
    }

    public void execute(String[] args) {
        if(ItemRegistery.getInstance().getItemsAroundMe().isEmpty()){
            System.out.println("Il n'y a aucun items dans cette zone pour l'instant." +
                    "\nRevenez plus tard...");
        } else{
       for (Item item : ItemRegistery.getInstance().getItemsAroundMe()){
           System.out.println(item.getName());
       }}
    }

    public boolean hasValidArgs(String[] args) {
        return true;
    }
}
