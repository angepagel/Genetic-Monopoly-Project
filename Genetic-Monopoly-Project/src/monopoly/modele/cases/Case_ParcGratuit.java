package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Case_ParcGratuit extends Case {
    public Case_ParcGratuit(Case suivante) {
        super("Parc gratuit", suivante);
    }

    @Override
    public void action(Joueur j) {
        return;
    }

    @Override
    public ECase getType() {
        return ECase.ParcGratuit;
    }
}
