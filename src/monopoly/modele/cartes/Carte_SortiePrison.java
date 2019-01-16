package monopoly.modele.cartes;

import monopoly.modele.Joueur;
import monopoly.modele.cases.Case_Prison;
import monopoly.modele.cases.ECase;

/**
 * Représente une carte de sortie de prison.
 */
public abstract class Carte_SortiePrison extends Carte {
    Joueur proprietaire;

    public Carte_SortiePrison() {
        super("Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue.");
        proprietaire = null;
    }

    @Override
    public boolean usageImmediat() {
        return false;
    }

    @Override
    public void action(Joueur j) {
        this.proprietaire = j;
        donnerAJoueur(j);
    }

    /**
     * Permet de donner la carte au joueur.
     * @param j Joueur à qui on doit donner la carte.
     */
    protected abstract void donnerAJoueur(Joueur j);

    /**
     * Permet de retirer la carte au joueur.
     * @param j Joueur à qui on doit retirer la carte.
     */
    protected abstract void retirerAJoueur(Joueur j);

    /**
     * Permet de remettre la carte sous la pile.
     */
    protected abstract void remettreSousPile();

    /**
     * Ce qui se passe quand on décide d'utiliser la carte.
     */
    public void utiliser() {
        retirerAJoueur(proprietaire);
        proprietaire = null;
        remettreSousPile();
    }

    /**
     * Quand on change de propriétaire.
     * @param j Joueur à qui on donnne la carte.
     */
    public void setProprietaire(Joueur j) {
        if(proprietaire != null) {
            Joueur ancienProprio = proprietaire;
            retirerAJoueur(ancienProprio);
        }
        proprietaire = j;
        donnerAJoueur(proprietaire);
    }
}
