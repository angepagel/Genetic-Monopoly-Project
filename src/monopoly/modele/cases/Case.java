package monopoly.modele.cases;

import monopoly.modele.Joueur;

public abstract class Case {
    private String nom;
    private Case suivante;

    public Case(String nom, Case suivante) {
        this.nom = nom;
        this.suivante = suivante;
    }

    public String getNom() {
        return nom;
    }

    public Case getSuivante() {
        return suivante;
    }

    public void setSuivante(Case suivante) {
        this.suivante = suivante;
    }

    public abstract void action(Joueur j);

    public abstract ECase getType();
}
