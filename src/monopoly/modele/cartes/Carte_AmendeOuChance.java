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
        super("Payez une amende de $" + montant +" ou piochez une carte Chance.");
        this.montant = montant;
    }

    public int getMontant() {
        return montant;
    }

    @Override
    public void action(Joueur j) {
        Jeu.getInstance().getControleurJeuMessage().demanderPaiementPioche(this, j);
    }

    /**
     * le joueur a choisi l'amende.
     * @param j Le joueur qui a choisi l'amende.
     */
    public void amende(Joueur j) {
        Jeu.getInstance().getControleurJeuMessage().afficherMessage("Carte à choix", "Vous avez payé $" + montant + " d'amende.");
        j.getSolde().payerImpots(montant);
    }

    /**
     * Le joueur a choisi de piocher.
     * @param j Le joueur qui a fait le choix.
     */
    public void piocher(Joueur j) {
        Jeu.getInstance().getControleurJeuMessage().afficherMessage("Carte à choix", "Vous piochez une carte chance.");
        Jeu.getInstance().getGestionnaireCartes().actionChance(j);
    }

    @Override
    public boolean affichageInclus() {return true;}
}
