package monopoly.modele.cases;

public abstract class Case_Paiement extends Case {
    public Case_Paiement(String nom, Case suivante) {
        super(nom, suivante);
    }

    public abstract int getPrix();
    
    @Override
    public boolean aUnPrix() {
        return true;
    }
}
