package monopoly.modele.cartes;

import monopoly.modele.Joueur;

public class Carte_ReculerVers extends Carte_DeplacementVers {
    public Carte_ReculerVers(String texte, String objectif) {
        super(texte, objectif);
    }

    public Carte_ReculerVers(String objectif) {
        super("Reculez à la case " + objectif + ".", objectif);
    }

    @Override
    public void action(Joueur j) {
        j.getPion().reculer(objectif);
    }
}
