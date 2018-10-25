package monopoly.modele.cases;

public class Case_Compagnie extends Case_Achat {
    public Case_Compagnie(String nom, Case suivante) {
        super(nom, suivante);
    }

    @Override
    public int getLoyer() {
        return 0;
    }

    @Override
    public int getPrix() {
        return 0;
    }

    @Override
    public ECase getType() {
        return ECase.Compagnie;
    }
}
