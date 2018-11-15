package monopoly.modele.cases;

import monopoly.modele.Jeu;

public class Case_Compagnie extends Case_Achat {
    public Case_Compagnie(String nom, Case suivante) {
        super(nom, suivante);
    }

    @Override
    public int getLoyer() {
        int loyer;
        if(getProprietaire().getNbCompagnies() == 1) {
            loyer = 4;
        }
        else if(getProprietaire().getNbCompagnies() == 2) {
            loyer = 10;
        }
        else {
            loyer = 0;
        }

        loyer *= Jeu.getInstance().getDes().sommeDes();

        return loyer;
    }

    @Override
    public int getPrix() {
        return 150;
    }

    @Override
    public ECase getType() {
        return ECase.Compagnie;
    }
}
