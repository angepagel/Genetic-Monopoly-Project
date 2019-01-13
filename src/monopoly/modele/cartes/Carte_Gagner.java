package monopoly.modele.cartes;

import monopoly.modele.Joueur;

public class Carte_Gagner extends Carte {
    private int montant;

    public Carte_Gagner(int montant, String texte) {
        super(texte);
        this.montant = montant;
    }

    public Carte_Gagner(int montant){
        super(String.format("Gagnez %d$.", montant));
        this.montant = montant;
    }

    @Override
    public void action(Joueur j) {
        j.getSolde().ajouter(montant);
    }
}
