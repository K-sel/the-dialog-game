package Base;

import java.util.HashMap;

public class World {

    //Propriété -------------------------------------
    private static World instance = null;
    private HashMap<String, Location> locations;
    private Location[][] map;

    //Constructeur --------------------------------------
    private World() {
        this.locations = new HashMap<>();
        this.map = new Location[3][4];
        // Ajouter les locations dans la map
        addLocation(new Location("Point de départ de votre aventure", "Ile de Dawn", true), 0, 0);
        addLocation(new Location("Ile des dragons célestes, les dirigeants de ce monde", "Red Line", false), 1, 0);
        addLocation(new Location("Parc sportif datant de l'antiquité", "Parc d'olympe", false), 2, 0);
        addLocation(new Location("Bar malfamé fréquenté par les pires individus de la région", "Jaya's Bar", true), 0, 1);
        addLocation(new Location("Ville de la brume", "Kiri", true), 1, 1);
        addLocation(new Location("Village ninja de la feuille cachée", "Konoha", false), 2, 1);
        addLocation(new Location("Bateau d'un certain équipage pirate", "Thousand Sunny", false), 0, 2);
        addLocation(new Location("Point de relais pour les pirates locaux", "Loguetown", true), 1, 2);
        addLocation(new Location("Un village mythique ou les villageois sont tous des forgerons chevronnés", "Village des forgerons", true), 2, 2);
        addLocation(new Location("Point de rencontres des meilleures constructeurs de bateaux", "Water seven", false), 0, 3);
        addLocation(new Location("Pays des samourais", "Wano Kuni", false), 1, 3);
        addLocation(new Location("Un ile cachée dans les nuages", "Skypea", false), 2, 3);
    }

    //Singleton ----------------------------------------
    public static World getInstance() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }

    //Getter -------------------------------------------------
    public Location getLocationByCoordinates(int row, int col) {
        return this.map[row][col];
    }

    public void addLocation(Location location, int row, int col) {
        this.locations.put(location.getName(), location);
        this.map[row][col] = location;
    }

    public Location getLocationByName(String name) {
        return this.locations.get(name);
    }

    public int[] getLocationCoordinates (String locationName) {
        for (int i = 0; i <= this.map.length-1; i++) {
            for (int j = 0; j <= this.map[i].length-1; j++) {
                if (locationName.equals(this.map[i][j].getName())) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public Location[][] getMap() {
        return this.map;
    }

    public boolean checkExistingLocation(String name) {
        return this.locations.containsKey(name.toLowerCase());
    }


}
