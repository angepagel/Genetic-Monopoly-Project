package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cartes.Carte;

public class Case_CaisseCommunaute extends Case_Pioche {

    public Case_CaisseCommunaute(Case suivante) {
        super("Caisse de communauté", suivante);
    }

    @Override
    public void action(Joueur j) {
        Jeu.getInstance().getGestionnaireCartes().actionCaisseCommunaute(j);
    }

    @Override
    public ECase getType() {
        return ECase.CaisseCommunaute;
    }
}
