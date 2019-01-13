package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cartes.Carte;

public class Case_CaisseCommunaute extends Case_Pioche {

    public Case_CaisseCommunaute(Case suivante) {
        super("Caisse de communauté", suivante);
    }

    @Override
    protected Carte piocherCarte() {
        return Jeu.getInstance().getGestionnaireCartes().piocherCaisseCommunaute();
    }

    @Override
    protected void remettreCarte(Carte carte) {
        Jeu.getInstance().getGestionnaireCartes().remettreCaisseCommunaute(carte);
    }

    @Override
    public ECase getType() {
        return ECase.CaisseCommunaute;
    }
}
