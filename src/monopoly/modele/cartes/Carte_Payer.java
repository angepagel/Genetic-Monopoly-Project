package monopoly.modele.cartes;

import monopoly.modele.Joueur;

public class Carte_Payer extends Carte {
    private int montant;

    @Override
    public void action(Joueur j) {
        j.getSolde().payerImpots(montant);
    }

    public Carte_Payer(int montant, String texte) {
        super(texte);
        this.montant = montant;
    }

    public Carte_Payer(int montant) {
        super("Payez " + montant + "$.");
        this.montant = montant;
    }
}
