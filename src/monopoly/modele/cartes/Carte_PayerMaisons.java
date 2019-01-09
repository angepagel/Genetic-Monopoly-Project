package monopoly.modele.cartes;

import monopoly.modele.Joueur;

/**
 * Carte qui implique de payer en fonction du nombre d'hôtels et de maisons.
 */
public class Carte_PayerMaisons extends Carte {
    /**
     * Prix à payer par maison.
     */
    private int prixParMaison;

    /**
     * Prix à payer par hôtel.
     */
    private int prixParHotel;

    public Carte_PayerMaisons(int prixParMaison, int prixParHotel, String texte) {
        super(texte);
        this.prixParMaison = prixParMaison;
        this.prixParHotel = prixParHotel;
    }

    @Override
    public void action(Joueur j) {
        int prix = (prixParMaison * j.getNbMaisons()) + (prixParHotel * j.getNbHotels());

        j.getSolde().payerImpots(prix);
    }
}
