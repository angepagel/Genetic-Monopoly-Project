package monopoly.modele.cases;

import javafx.scene.paint.Color;
import monopoly.modele.Joueur;

import java.util.ArrayList;

public class CouleurTerrain {
    private ArrayList<Case_Terrain> proprietes;
    private Color couleur;
    private int prixMaison;

    public CouleurTerrain(Color couleur, int prixMaison) {
        proprietes = new ArrayList<>();
        this.couleur = couleur;
        this.prixMaison = prixMaison;
    }

    public int getNbTerrains() {
        return proprietes.size();
    }

    public void ajouterPropriete(Case_Terrain caseT) {
        proprietes.add(caseT);
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
    public int getMaxMaisonsConstruction() {
        int maximum = getMaxMaisons();
        // Si un même propriétaire ne possède pas l'entièreté du groupe, on ne peut construir aucune maison.
        if(aUnProprietaire()) {
            // Toutes les propriétés ont le même nombre de maisons. On peut donc monter au pallier suivant.
            if(getMinMaisons() == getMaxMaisons()) {
                ++maximum;
            }
        }

        return maximum;
    }

    public int getMaxMaisons() {
        int maximum = 0;
        if(aUnProprietaire()){
            for(Case_Terrain c : proprietes) {
                if(maximum < c.getNbMaisons()) {
                    maximum = c.getNbMaisons();
                }
            }
        }

        return maximum;
    }

    /**
     *
     * @return Le minimum de maisons auquel on peut actuellement abaisser les propriétés du groupe.
     */
    public int getMinVenteMaisons() {
        int minimum = getMinMaisons();
        if(aUnProprietaire()) {
            if(getMinMaisons() == getMaxMaisons()) {
                --minimum;
            }
        }

        return minimum;
    }

    public Color getCouleur() {
        return couleur;
    }

    public int getPrixMaison() {
        return prixMaison;
    }
}
