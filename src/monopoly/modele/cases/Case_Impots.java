package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Case_Impots extends Case_Paiement {
    private int prix;

    public Case_Impots(String nom, int prix, Case suivante) {
        super(nom, suivante);
        this.prix = prix;
    }

    @Override
    public int getPrix() {
        return 0;
    }

    @Override
    public String getNom() {
        return null;
    }

    @Override
    public void action(Joueur j) {

    }

    @Override
    public ECase getType() {
        return ECase.Impots;
    }
}
