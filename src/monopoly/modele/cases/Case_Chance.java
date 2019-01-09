package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cartes.Carte;

public class Case_Chance extends Case_Pioche {
    public Case_Chance(Case suivante) {
        super("Chance", suivante);
    }

    @Override
    public void action(Joueur j) {
        Carte chance = Jeu.getInstance().getGestionnaireCartes().piocherChance();
        chance.action(j);
        if(chance.usageImmediat()) {
            Jeu.getInstance().getGestionnaireCartes().remettreChance(chance);
        }
    }

    @Override
    public ECase getType() {
        return ECase.Chance;
    }
}
