package monopoly.modele.cartes;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

/**
 * Carte donnant le choix entre amende et chance.
 */
public class Carte_AmendeOuChance extends Carte {

    /**
     * Montant qui doit être payé si le joueur choisit l'amende.
     */
    private int montant;

    public Carte_AmendeOuChance(int montant, String texte) {
        super(texte);
        this.montant = montant;
    }

    public Carte_AmendeOuChance(int montant) {
        super(String.format("Payez une amende de %d€ ou piochez une carte Chance.", montant));
    }

    @Override
    public void action(Joueur j) {
        // TODO : On donne le choix au joueur.
    }

    /**
     * le joueur a choisi l'amende.
     * @param j Le joueur qui a choisi l'amende.
     */
    public void amende(Joueur j) {
        j.getSolde().payerImpots(montant);
    }

    /**
     * Le joueur a choisi de piocher.
     * @param j Le joueur qui a fait le choix.
     */
    public void pioher(Joueur j) {
        Jeu.getInstance().getGestionnaireCartes().actionChance(j);
    }
}
