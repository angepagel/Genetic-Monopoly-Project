package monopoly.modele.cartes;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

public class Carte_AvancerVers extends Carte_DeplacementVers {
    public Carte_AvancerVers(String texte, String objectif) {
        super(texte,objectif);
    }

    public Carte_AvancerVers(String objectif) {
        super("Avancez jusqu'à la case " + objectif + ". Si vous passez par la case départ, reçevez " + Jeu.getInstance().getArgentCaseDepart() + "€.", objectif);
    }

    @Override
    public void action(Joueur j) {
        j.getPion().deplacer(objectif);
    }
}
