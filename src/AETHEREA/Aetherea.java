package AETHEREA;

import java.util.HashMap;

public class Aetherea {
    private HashMap <String, Lokace> locations;

    public Aetherea() {
        locations = new HashMap<>();
    }

    public HashMap<String, Lokace> getLocations() {
        return locations;
    }

    public void setLocations(HashMap<String, Lokace> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Map : " +
                "locations = " + locations + "\n";
    }
}
