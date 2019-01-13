package monopoly.modele.cartes;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

import java.util.ArrayList;

/**
 * Représente la carte "c'est votre anniversaire".
 */
public class Carte_Anniversaire extends Carte {
    /**
     * Argent que chaque joueur doit verser au joueur dont c'est l'anniversaire.
     */
    int montant;

    public Carte_Anniversaire(int montant, String texte) {
        super(texte);
        this.montant = montant;
    }

    public Carte_Anniversaire(int montant) {
        super(String.format("C'est votre anniversaire.\nChaque joueur doit vous donner %d$.", montant));
        this.montant = montant;
    }

    @Override
    public void action(Joueur j) {
        int gain = 0;
        ArrayList<Joueur> joueurs = Jeu.getInstance().getJoueurs();
        for(Joueur joueur : joueurs) {
            if(joueur != j && !joueur.isFaillite()) {
                joueur.getSolde().payer(montant);
                gain += montant;
            }
        }

        j.getSolde().ajouter(gain);
    }
}
