package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * Représente une case du plateau.
 */
public abstract class Case {
    /**
     * Contient le nom de la classe.
     */
    private String nom;

    /**
     * Case qui suit cette case.
     */
    private Case suivante;

    /**
     * Case qui précède cette case (utilisée pour la carte de recul de trois cases).
     */
    private Case precedente;

    /**
     * Constructeur de la case
     * @param nom Nom de la case.
     * @param suivante Case suivante.
     */
    public Case(String nom, Case suivante) {
        this.nom = nom;
        setSuivante(suivante);
    }

    /**
     * Permet de récupérer le nom de la case.
     * @return Nom de la case.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de récupérer la case suivante.
     * @return Case suivante.
     */
    public Case getSuivante() {
        return suivante;
    }

    /**
     * Permet de définir la case suivante.
     * @param suivante Case suivante.
     */
    public void setSuivante(Case suivante) {
        if(this.suivante != null) {
            this.suivante.precedente = null;
        }
        if(suivante != null) {
            this.suivante = suivante;
            this.suivante.precedente = this;
        }
    }

    /**
     * Permet d'obtenir l'identifiant de la case. Vaut le nom pour la plupart.
     * @return Identifiant unique
     */
    public String getId() {
        return getNom();
    }
    
    /**
     * Permet de savoir si la case a un prix.
     * @return Vrai si elle en a un.
     */
    public boolean aUnPrix() {
        return false;
    }

    /**
     * Permet de récupérer la case précédente.
     * @return Case précédente.
     */
    public Case getPrecedente() {
        return precedente;
    }

    /**
     * Action effectuée quand le joueur tombe dessus (ou dans tous les cas, dans le cas de la case départ).
     * @param j
     */
    public abstract void action(Joueur j);

    /**
     * Permet de récupérer le type de la case.
     * @return Type de la case.
     */
    public abstract ECase getType();
}
