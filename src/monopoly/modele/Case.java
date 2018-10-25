package monopoly.modele;

public abstract class Case {
    private Case suivante;

    public Case() {
        // TODO : Constructeur
    }

    public abstract String getNom();

    public Case getSuivante() {
        return suivante;
    }

    public abstract void action(Joueur j);

    public abstract ECase getType();
}
