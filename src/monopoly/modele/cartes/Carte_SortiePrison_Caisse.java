package monopoly.modele.cartes;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

/**
 * Représente la version de la carte présente parmi les cartes caisse de communauté.
 */
public class Carte_SortiePrison_Caisse extends Carte_SortiePrison {
    @Override
    protected void donnerAJoueur(Joueur j) {
        j.setSortiePrisonCaisse(this);
    }

    @Override
    protected void retirerAJoueur(Joueur j) {
        j.setSortiePrisonCaisse(null);
    }

    @Override
    protected void remettreSousPile() {
        Jeu.getInstance().getGestionnaireCartes().remettreCaisseCommunaute(this);
    }
}
