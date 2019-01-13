package monopoly.modele.cartes;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

public class Carte_AvancerVers extends Carte_DeplacementVers {
    public Carte_AvancerVers(String objectif, String texte) {
        super(objectif, texte);
    }

    public Carte_AvancerVers(String objectif) {
        super(objectif, "Avancez jusqu'à la case " + objectif + ".\nSi vous passez par la case \"Départ\", reçevez " + Jeu.getInstance().getArgentCaseDepart() + "$.");
    }

    @Override
    public void action(Joueur j) {
        j.getPion().deplacer(getObjectif());
    }
}
