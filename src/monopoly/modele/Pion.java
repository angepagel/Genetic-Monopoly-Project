package monopoly.modele;

import monopoly.modele.cases.Case;
import monopoly.modele.cases.ECase;

public class Pion {
    private Case position;
    private String nom;
    private Joueur joueur;
    private boolean caseDepartLast;

    public Pion(Case position, String nom) {
        this.position = position;
        this.nom = nom;
        caseDepartLast = false;
    }

    public Pion(String nom) {
        this.nom = nom;
        this.position = Jeu.getInstance().getPlateau().getCaseDepart();
    }

    public void deplacer(int nbCases) {
        caseDepartLast = false;
        for(int i = 0; i < nbCases; ++i) {
            position = position.getSuivante();
            if(position.getType() == ECase.Depart && i < nbCases) {
                position.action(getJoueur());
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

    /**
     * Permet de savoir si le dernier déplacement est passé par la case départ (pour l'affichage)
     * @return Vrai si on est passé par la case départ.
     */
    public boolean isCaseDepartLast() {
        return caseDepartLast;
    }

    /**
     * Permet d'indiquer qu'on vient de passer par la case départ.
     */
    public void passeCaseDepart() {
        caseDepartLast = true;
    }



    public String getNom() {
        return nom;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
