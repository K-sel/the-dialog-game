package Base;

import Commands.CommandRegistery;
import Items.ItemRegistery;

public class Game {

    private static Game instance = null;

    //Constructeur ----------------------------------------------------------------------------
    private Game() {
        //Initialisation de la map--------------------------------------------------------------------
        World.getInstance();
        //Initialisation des commandes---------------------------------------------------------------
        CommandRegistery.getInstance();
        //Initialisation des items---------------------------------------------------------------
        ItemRegistery.getInstance();
        //Initialisation du joueur---------------------------------------------------------------
        Player.getInstance();
    }

    //Sigleton --------------------------------------------------------
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
}
