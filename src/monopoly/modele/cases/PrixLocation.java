package monopoly.modele.cases;

import java.util.ArrayList;

public class PrixLocation {
    private int terrainNu;
    private ArrayList<Integer> maisons;
    private int hotel;

    public PrixLocation(int terrainNu, int m1, int m2, int m3, int m4, int hotel) {
        this.terrainNu = terrainNu;
        this.hotel = hotel;
        maisons = new ArrayList<>();
        maisons.add(m1);
        maisons.add(m2);
        maisons.add(m3);
        maisons.add(m4);
    }

    public int getPrixTerrainNu() {
        return terrainNu;
    }

    public ArrayList<Integer> getPrixMaisons() {
        return maisons;
    }

    public int getPrixHotel() {
        return hotel;
    }

    public int getPrixMaison(int nb) {
        int prix = 0;
        if(nb <= maisons.size()) {
            prix= maisons.get(nb-1);
        }

        return prix;
    }
}
