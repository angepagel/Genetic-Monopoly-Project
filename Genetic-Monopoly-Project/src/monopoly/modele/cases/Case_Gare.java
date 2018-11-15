package monopoly.modele.cases;

public class Case_Gare extends Case_Achat {
    public Case_Gare(String nom, Case suivante) {
        super(nom, suivante);
    }

    @Override
    public int getLoyer() {
        switch(getProprietaire().getNbCompagnies()) {
            case 0:
            case 1:
                return 25;
            case 2:
                return 50;
            case 3:
                return 100;
            case 4:
                return 200;
            default:
                return 0;
        }
    }

    @Override
    public int getPrix() {
        return 200;
    }

    @Override
    public ECase getType() {
        return ECase.Gare;
    }
}
