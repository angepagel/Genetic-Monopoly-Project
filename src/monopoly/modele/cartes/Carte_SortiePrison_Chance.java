package monopoly.modele.cartes;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

/**
 * Variante appartenant à la liste des cartes chance.
 */
public class Carte_SortiePrison_Chance extends Carte_SortiePrison {

    @Override
    protected void donnerAJoueur(Joueur j) {
        j.setSortiePrisonChance(this);
    }

    @Override
    protected void retirerAJoueur(Joueur j) {
        j.setSortiePrisonChance(null);
    }

    @Override
    protected void remettreSousPile() {
        Jeu.getInstance().getGestionnaireCartes().remettreChance(this);
    }


}
