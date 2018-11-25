package monopoly.modele.cartes;

import monopoly.modele.Joueur;

public class Carte_ReculerVers extends Carte_DeplacementVers {
    public Carte_ReculerVers(String objectif, String texte) {
        super(objectif, texte);
    }

    public Carte_ReculerVers(String objectif) {
        super(objectif,"Reculez à la case " + objectif + ".");
    }

    @Override
    public void action(Joueur j) {
        j.getPion().reculer(getObjectif());
    }
}
