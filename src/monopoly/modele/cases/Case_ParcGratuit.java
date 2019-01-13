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
        int argent = Jeu.getInstance().getArgentParcGratuit();
        j.getSolde().ajouter(argent);
        Jeu.getInstance().resetArgentParcGratuit();
        if(argent > 0) {
            Jeu.getInstance().getControleurJeuMessage().afficherMessage("Parc gratuit", "Vous avez gagné $" + argent + " sur le parc gratuit.");
        }
        else {
            Jeu.getInstance().getControleurJeuMessage().afficherMessage("Parc gratuit", "Le parc gratuit est vide.");
        }
    }

    @Override
    public ECase getType() {
        return ECase.ParcGratuit;
    }
}
