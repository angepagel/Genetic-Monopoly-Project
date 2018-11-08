package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Case_VisitePrison extends Case {
    public Case_VisitePrison(Case suivante) {
        super("Visite en prison", suivante);
    }

    @Override
    public void action(Joueur j) {
        // Aucun effet.
    }

    @Override
    public ECase getType() {
        return ECase.VisitePrison;
    }
}
