package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

public class Case_Depart extends Case {
    public Case_Depart(Case suivante) {
        super("Départ", suivante);
    }

    @Override
    public void action(Joueur j) {
        j.getSolde().ajouter(Jeu.getInstance().getArgentCaseDepart());
        j.getPion().passeCaseDepart();
    }

    @Override
    public ECase getType() {
        return ECase.Depart;
    }
}
