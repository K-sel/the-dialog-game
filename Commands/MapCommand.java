package Commands;

import Base.Location;
import Base.Player;
import Base.World;
import Interfaces.ICommand;


public class MapCommand implements ICommand {

    //Propriétés -------------------------------------------
    private static MapCommand instance = null;
    private final Player player;
    private final Location[][] map;

    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String GRAY = "\u001B[90m";


    //Constructeur -------------------------------------------
    private MapCommand() {
        this.map = World.getInstance().getMap();
        this.player = Player.getInstance();
    }

    //Singleton ----------------------------------------------
    public static MapCommand getInstance() {
        if (instance == null) {
            instance = new MapCommand();
        }
        return instance;
    }


    //Getters -------------------------------------------
    public String getName() {
        return "Map";
    }

    public String getUsage() {
        return "Si vous êtes perdus, ca peut aider à se repèrer dans le jeu.";
    }

    public String getDescription() {
        return "La commande map affiche la carte. Elle mets en vert la position du joueur. Les zones verouillées sont écrites en gris.";
    }


    public void execute(String[] args) {
        printAsciiMap();
    }

    //Execution de commande -------------------------------------------
    // For map command, any argument is valid since it doesn't need any. Hence, it always returns true.
    public boolean hasValidArgs(String[] arg) {
        return true;
    }

    // Method to print the ASCII map.
    private void printAsciiMap() {
        int maxLength = findMaxLength();  // Find the maximum length of location names for alignment purposes.

        // Print each row of the map.
        for (int row = 0; row < map.length; row++) {
            printHorizontalLine(maxLength, map[row].length);  // Print the top horizontal line for each location.
            printLocationNames(row, maxLength);  // Print the names of locations in the row.
        }

        // Print the bottom horizontal line of the map.
        printHorizontalLine(maxLength, map[0].length);
    }

    // Method to print the horizontal line for each location in the map.
    private void printHorizontalLine(int maxLength, int numColumns) {
        for (int col = 0; col < numColumns; col++) {
            System.out.print("+");
            System.out.print("-".repeat(maxLength + 2));  // Print the horizontal line with length according to the maxLength.
        }
        System.out.println("+");
    }

    // Method to print the names of locations in a row.
    private void printLocationNames(int row, int maxLength) {
        for (int col = 0; col < map[row].length; col++) {
            Location location = map[row][col];
            String text;

            // If the location is not null, set the text as the name of the location, otherwise set it as a space.
            if (location != null) {
                text = location.getName();
            } else {
                text = " ";
            }

            int padding = (maxLength - text.length()) / 2;  // Calculate the padding for alignment purposes.
            String paddingSpaces = " ".repeat(padding + 1);  // Generate the padding spaces string.

            System.out.print("|");

            // If the current location is the player's location, underline it.
            if (player.getRow() == row && player.getCol() == col) {
                System.out.print(paddingSpaces);
                System.out.print(GREEN + text + RESET);
                System.out.print(paddingSpaces);
            } else if (location.isOpen()) {
                System.out.print(paddingSpaces);
                System.out.print(text);
                System.out.print(paddingSpaces);
            } else {
                System.out.print(paddingSpaces);
                System.out.print(GRAY + text + RESET);
                System.out.print(paddingSpaces);
            }
        }
        System.out.println("|");
    }

    // This method is responsible for determining the maximum length of a location's name
    private int findMaxLength() {
        // We start by setting maxLength to 0
        int maxLength = 0;

        // We iterate over each row of locations in the map
        for (Location[] locations : map) {
            // For each row, we iterate over each location in that row
            for (Location location : locations) {
                // We only proceed if the location is not null
                if (location != null) {
                    // If the length of the current location's name is greater than maxLength,
                    // we update maxLength to be the length of the current location's name
                    maxLength = Math.max(maxLength, location.getName().length());
                }
            }
        }
        // After checking all locations, we return the maximum length found
        return maxLength;
    }

}


