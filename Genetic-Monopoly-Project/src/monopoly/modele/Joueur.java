package monopoly.modele;

import monopoly.modele.cases.Case_Achat;
import monopoly.modele.cases.ECase;

import java.util.ArrayList;
import java.util.Objects;

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
    private ArrayList<Case_Achat> proprietes;

    public Joueur(String nom) {
        this.nom = nom;
        solde = new Solde(this);
    }

    public void tour() {
        // TODO : Logique du tour du joueur.
    }

    public void choisirPion(Pion p) {
        pion = p;
        p.setJoueur(this);
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

    public Pion getPion() {
        return pion;
    }

    public int getNbGares() {
        int nbGares = 0;
        for(Case_Achat propriete : proprietes) {
            if(propriete.getType() == ECase.Gare) {
                ++nbGares;
            }
        }

        return nbGares;
    }

    public int getNbCompagnies() {
        int nbCompagnies = 0;
        for(Case_Achat propriete: proprietes) {
            if(propriete.getType() == ECase.Compagnie) {
                ++nbCompagnies;
            }
        }

        return nbCompagnies;
    }

    private boolean isEnPrison() {
        return pion.getPosition().getType() == ECase.Prison;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return faillite == joueur.faillite &&
                nbDoubles == joueur.nbDoubles &&
                toursEnPrison == joueur.toursEnPrison &&
                Objects.equals(nom, joueur.nom) &&
                Objects.equals(pion, joueur.pion) &&
                Objects.equals(solde, joueur.solde) &&
                Objects.equals(proprietes, joueur.proprietes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, faillite, nbDoubles, toursEnPrison, pion, solde, proprietes);
    }
}
