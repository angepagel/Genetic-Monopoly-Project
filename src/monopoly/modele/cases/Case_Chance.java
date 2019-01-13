package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cartes.Carte;

public class Case_Chance extends Case_Pioche {
    public Case_Chance(Case suivante) {
        super("Chance", suivante);
    }

    @Override
    protected Carte piocherCarte() {
        return Jeu.getInstance().getGestionnaireCartes().piocherChance();
    }

    @Override
    protected void remettreCarte(Carte carte) {
        Jeu.getInstance().getGestionnaireCartes().piocherCaisseCommunaute();
    }

    @Override
    public ECase getType() {
        return ECase.Chance;
    }
}
