package monopoly.modele.cases;

import monopoly.modele.Joueur;

import java.util.ArrayList;

public class CouleurTerrain {
    private ArrayList<Case_Terrain> proprietes;
    public CouleurTerrain() {
        proprietes = new ArrayList<>();
    }

    public int getNbTerrains() {
        return proprietes.size();
    }

    /**
     * Permet de savoir si tout le groupe a un propriétaire
     */
    public boolean aUnProprietaire() {
        Joueur premierProprio = null;
        boolean retour = true;

        for(Case_Terrain c : proprietes) {
            if(premierProprio == null && c.getProprietaire() != null) {
                premierProprio = c.getProprietaire();
            }
            else {
                if(premierProprio != c.getProprietaire() || c.getProprietaire() == null) {
                    retour = false;
                    break;
                }
            }
        }

        return retour;
    }

    public Joueur getProprietaire() {
        Joueur j;
        if(proprietes.size() >= 1) {
            j = proprietes.get(0).getProprietaire();
        }
        else {
            j = null;
        }
        return j;
    }

    public int getMinMaisons() {
        int minimum = -1;
        for(Case_Terrain c : proprietes) {
            if(minimum == -1 || minimum > c.getNbMaisons()) {
                minimum= c.getNbMaisons();
            }
        }

        return minimum;
    }

    /**
     *
     * @return Le maximum de maisons que l'on peut construire.
     */
    public int getMaxMaisons() {
        int maximum = 0;
        // Si un même propriétaire ne possède pas l'entièreté du groupe, on ne peut construir aucune maison.
        if(aUnProprietaire()) {
            for(Case_Terrain c : proprietes) {
                if(maximum < c.getNbMaisons()) {
                    maximum = c.getNbMaisons();
                }
            }

            // Toutes les propriétés ont le même nombre de maisons. On peut donc monter au pallier suivant.
            if(getMinMaisons() == getMaxMaisons()) {
                ++maximum;
            }
        }

        return maximum;
    }
}
