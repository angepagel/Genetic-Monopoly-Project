package monopoly.modele.cartes;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cases.Case_Prison;

public class Carte_AllerPrison extends Carte {
    public Carte_AllerPrison() {
        super("Allez en prison.\nRendez-vous directement à la prison.\nNe franchissez pas la case \"Départ\". Ne touchez pas " + Jeu.getInstance().getArgentCaseDepart() +"$.");
    }

    @Override
    public void action(Joueur j) {
        Case_Prison prison = (Case_Prison)Jeu.getInstance().getPlateau().getCase("Prison");
        j.getPion().setPosition(prison);
    }
}
