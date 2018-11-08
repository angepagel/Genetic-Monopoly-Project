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
            avancerUneCase(i+1 < nbCases);
        }

        position.action(getJoueur());
    }

    public void deplacer(String objectif) {
        caseDepartLast = false;
        while(!position.getNom().equals(objectif)) {
            avancerUneCase(!objectif.equals("Case départ"));
        }

        position.action(getJoueur());
    }

    public void reculer(int nbCases) {
        caseDepartLast = false;
        for(int i = 0; i < nbCases; ++i) {
            reculerUneCase(false);
        }

        position.action(getJoueur());
    }

    public void reculer(String objectif) {
        caseDepartLast = false;
        while(!position.getNom().equals(objectif)) {
            reculerUneCase(false);
        }

        position.action(getJoueur());
    }

    /**
     * Permet d'avancer d'une case, sans déclencher son effet (sauf sur la case départ)
     * @param declencheDepart Permet de savoir si on déclenche la case départ si l'on passe dessus
     */
    private void avancerUneCase(boolean declencheDepart) {
        position = position.getSuivante();
        if(declencheDepart && position.getType() == ECase.Depart) {
            position.action(getJoueur());
        }
    }

    /**
     * Permet de reculer d'une case, sans déclencher son effet (sauf sur la case départ)
     * @param declencheDepart Permet de savoir si on doit déclencher la case départ.
     */
    private void reculerUneCase(boolean declencheDepart) {
        position = position.getPrecedente();
        if(declencheDepart && position.getType() == ECase.Depart) {
            position.action(getJoueur());
        }
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
