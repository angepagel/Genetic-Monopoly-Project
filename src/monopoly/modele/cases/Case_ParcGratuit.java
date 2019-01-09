package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.Plateau;

public class Case_ParcGratuit extends Case {
    public Case_ParcGratuit(Case suivante) {
        super("Parc gratuit", suivante);
    }

    @Override
    public void action(Joueur j) {
        j.getSolde().ajouter(Jeu.getInstance().getArgentParcGratuit());
        Jeu.getInstance().resetArgentParcGratuit();
    }

    @Override
    public ECase getType() {
        return ECase.ParcGratuit;
    }
}
