package monopoly.modele;

/**
 * Classe représentant un joueur.
 */
public abstract class Joueur {
    private String nom;
    private boolean faillite;
    private int nbDoubles;
    private int toursEnPrison;
    private Pion pion;
    private Solde solde;

    public Joueur(String nom) {
        this.nom = nom;
        solde = new Solde(this);
    }

    public void tour() {
        // TODO : Logique du tour du joueur.
    }

    public void choisirPion(Pion p) {
        pion = p;
    }

    public void incNbDoubles() {
        nbDoubles++;
    }

    public abstract Joueur getJoueur();
    public abstract EJoueur getType();

    public boolean isFaillite() {
        return faillite;
    }

    public void setFaillite(boolean faillite) {
        this.faillite = faillite;
    }

    public String getNom() {
        return nom;
    }

    public int getToursEnPrison() {
        return toursEnPrison;
    }

    public Solde getSolde() {
        return solde;
    }
}
