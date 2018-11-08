package monopoly.modele;

import monopoly.modele.cases.Case;
import monopoly.modele.cases.ECase;

public class Pion {
    private Case position;
    private String nom;
    private Joueur joueur;

    public Pion(Case position, String nom) {
        this.position = position;
        this.nom = nom;
    }

    public void deplacer(int nbCases) {
        for(int i = 0; i < nbCases; ++i) {
            position = position.getSuivante();
            if(position.getType() == ECase.Depart) {
                joueur.getSolde().ajouter(Jeu.getInstance().getArgentCaseDepart());
            }
        }

        position.action(getJoueur());
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
