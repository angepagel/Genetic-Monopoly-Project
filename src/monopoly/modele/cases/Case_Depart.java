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
        Jeu.getInstance().getControleurJeuMessage().afficherMessage(Jeu.getInstance().getJoueurEnCours().getNom()+" obtient $"+Jeu.getInstance().getArgentCaseDepart()+" de la case Départ.");
    }

    @Override
    public ECase getType() {
        return ECase.Depart;
    }
}
