package Base;

public class Player {

    private static Player instance = null;
    private String name;
    private Inventory inventory;
    private int playerRow;
    private int playerCol;

    //Constructeur ------------------------------------
    private Player() {
        this.inventory = Inventory.getInstance();
        this.playerCol = 0;
        this.playerRow = 0;
    }

    //Singleton ----------------------------------------------
    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    //Setter ---------------------------------------------
    public void setLocationByCoordinates(int row, int col, String direction) {
        int maxRow = World.getInstance().getMap().length;
        int maxCol = World.getInstance().getMap()[0].length;

        if (row >= 0 && row < maxRow && col >= 0 && col < maxCol) {
            if (World.getInstance().getLocationByCoordinates(row, col).isOpen()) {
                this.playerRow = row;
                this.playerCol = col;
                System.out.println("Déplacement " + direction);
            } else {System.out.println("Cette zone est verouillée, vous n'y avez pas encore accès...");}
        } else {
            System.out.println("Vous ne pouvez pas aller plus loin");
        }
    }

    public void setLocationByName(String name) {
        boolean doesExists = World.getInstance().checkExistingLocation(name);

        if (doesExists) {
            boolean isOpen = World.getInstance().getLocationByName(name).isOpen();
            if (isOpen) {
                this.playerRow = World.getInstance().getLocationCoordinates(name)[0];
                this.playerCol = World.getInstance().getLocationCoordinates(name)[1];
                System.out.println("Déplacement " + name);
            } else {
                System.out.println("Cette zone est verouillée, vous n'y avez pas encore accès...");
            }
        } else {
            System.out.println("Cette zone n'existe pas. Vérifiez l'orthographe ou affichez la map pour vous aider");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter ---------------------------------------------
    public Location getLocation(){
        return World.getInstance().getLocationByCoordinates(playerRow, playerCol);
    }
    public String getName() {
        return this.name;
    }

    public int getRow() {
        return this.playerRow;
    }

    public int getCol() {
        return this.playerCol;
    }

}
