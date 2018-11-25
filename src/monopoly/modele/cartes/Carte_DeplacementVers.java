package monopoly.modele.cartes;

import monopoly.modele.Joueur;

public abstract class Carte_DeplacementVers extends Carte {
    private String objectif;
    public Carte_DeplacementVers(String objectif, String texte) {
        super(texte);
        this.objectif = objectif;
    }

    public String getObjectif() {
        return objectif;
    }
}
