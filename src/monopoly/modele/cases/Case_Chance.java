package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Case_Chance extends Case_Pioche {
    public Case_Chance(Case suivante) {
        super("Chance", suivante);
    }

    @Override
    public void action(Joueur j) {
        // TODO : piocher une carte chance
    }

    @Override
    public ECase getType() {
        return ECase.Chance;
    }
}
