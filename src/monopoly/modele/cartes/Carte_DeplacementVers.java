package monopoly.modele.cartes;

import monopoly.modele.Joueur;

public abstract class Carte_DeplacementVers extends Carte {
    String objectif;
    public Carte_DeplacementVers(String texte, String objectif) {
        super(texte);
        this.objectif = objectif;
    }

    public String getObjectif() {
        return objectif;
    }
}
