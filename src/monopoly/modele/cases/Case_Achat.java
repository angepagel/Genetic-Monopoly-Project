package monopoly.modele.cases;

import monopoly.modele.Joueur;

public abstract class Case_Achat extends Case_Paiement {
    private Joueur proprietaire;
    private int valeurHypotheque;

    public Case_Achat(String nom, Case suivante) {
        super(nom, suivante);
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void payerLoyer(Joueur joueur) {
        if(proprietaire == null) {
            return;
        }

        joueur.getSolde().payer(getLoyer());
        proprietaire.getSolde().ajouter(getLoyer());
    }

    public abstract Integer getLoyer();

    @Override
    public void action(Joueur j) {
        if(proprietaire == null) {
            // TODO : Possibilité d'acheter
        }
        else {
            payerLoyer(j);
        }
    }

    public Integer getValeurHypotheque() {
        return valeurHypotheque;
    }
}
