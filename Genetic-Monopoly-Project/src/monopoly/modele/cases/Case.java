package monopoly.modele.cases;

import monopoly.modele.Joueur;

public abstract class Case {
    private String nom;
    private Case suivante;
    private Case precedente; // Utilisé pour la carte de triple recul

    public Case(String nom, Case suivante) {
        this.nom = nom;
        setSuivante(suivante);
    }

    public String getNom() {
        return nom;
    }

    public Case getSuivante() {
        return suivante;
    }

    public void setSuivante(Case suivante) {
        if(this.suivante != null) {
            this.suivante.precedente = null;
        }
        if(suivante != null) {
            this.suivante = suivante;
            this.suivante.precedente = this;
        }
    }

    public Case getPrecedente() {
        return precedente;
    }

    public abstract void action(Joueur j);

    public abstract ECase getType();
}
