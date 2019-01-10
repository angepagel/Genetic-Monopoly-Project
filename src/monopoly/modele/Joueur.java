package monopoly.modele;

import javafx.beans.property.SimpleStringProperty;
import monopoly.modele.cartes.Carte_SortiePrison_Caisse;
import monopoly.modele.cartes.Carte_SortiePrison_Chance;
import monopoly.modele.cases.Case_Achat;
import monopoly.modele.cases.Case_Prison;
import monopoly.modele.cases.Case_Terrain;
import monopoly.modele.cases.ECase;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe représentant un joueur.
 */
public abstract class Joueur {
    /**
     * Nom du joueur
     */
    private SimpleStringProperty nom;

    /**
     * S'il est en faillite ou non.
     */
    private boolean faillite;

    /**
     * Nombre de doubles effectués à la suite. Au bout de 3, le joueur va en prison.
     */
    private int nbDoubles;

    /**
     * Nombre de tours passés en prison à la suite. Au bout de 3, le joueur doit obligatoirement payer pour sortir.
     */
    private int toursEnPrison;

    /**
     * Pion du joueur, qui représente son emplacement sur le plateau.
     */
    private Pion pion;

    /**
     * Représente le solde du joueur (son argent et toutes les opérations liées).
     */
    private Solde solde;

    /**
     * Liste des propriétés possédées par le joueur.
     */
    private ArrayList<Case_Achat> proprietes;

    /**
     * Carte de sortie de prison de type chance. Si elle n'est pas possédée, vaut null.
     */
    private Carte_SortiePrison_Chance sortiePrisonChance;

    /**
     * Carte de sortie de prison de type caisse de communauté. Si elle n'est pas possédée, vaut null.
     */
    private Carte_SortiePrison_Caisse sortiePrisonCaisse;

    /**
     * Permet d'initialiser le joueur.
     * @param nom Nom du joueur.
     */
    public Joueur(String nom) {
        this.nom = new SimpleStringProperty(nom);
        solde = new Solde(this);
        sortiePrisonChance = null;
    }

    public Carte_SortiePrison_Chance getSortiePrisonChance() {
        return sortiePrisonChance;
    }

    public void setSortiePrisonChance(Carte_SortiePrison_Chance sortiePrisonChance) {
        this.sortiePrisonChance = sortiePrisonChance;
    }

    public boolean aSortiePrisonChance() {
        return (sortiePrisonChance != null);
    }

    public Carte_SortiePrison_Caisse getSortiePrisonCaisse() {
        return sortiePrisonCaisse;
    }

    public void setSortiePrisonCaisse(Carte_SortiePrison_Caisse sortiePrisonCaisse) {
        this.sortiePrisonCaisse = sortiePrisonCaisse;
    }

    public boolean aSortiePrisonCaisse() {
        return (sortiePrisonCaisse != null);
    }

    /**
     * Permet de savoir si le joueur dispose de l'une des deux cartes de sortie de prison.
     * @return Vrai s'il en possède une.
     */
    public boolean aSortiePrison() {
        return aSortiePrisonCaisse() || aSortiePrisonChance();
    }


    /**
     * Logique du tour du joueur.
     */
    public void tour() {
        // TODO : Logique du tour du joueur.
    }

    /**
     * Permet de chosiir un pion.
     * @param p Pion choisi.
     */
    public void choisirPion(Pion p) {
        pion = p;
        p.setJoueur(this);
    }

    /**
     * Lorsqu'on a fait un double, on augmente le nombre de doubles.
     * @return Vrai si on a été en prison.
     */
    public boolean incNbDoubles() {
        nbDoubles++;
        if(nbDoubles >= 3) {
            pion.deplacer("Prison");
            return true;
        }

        return false;
    }

    public void resetNbDoubles() {
        nbDoubles = 0;
    }

    /**
     * Permet de récupérer le joueur sous forme de joueur.
     * @return Le joueur.
     */
    public abstract Joueur getJoueur();

    /**
     * Permet de récupérer le type du joueur
     * @return Le type du joueur (Humain ou IA).
     */
    public abstract EJoueur getType();

    /**
     * Permet de savoir si le joueur est en faillite.
     * @return True s'il l'est. Faux sinon.
     */
    public boolean isFaillite() {
        return faillite;
    }

    /**
     * Permet de mettre un joueur en faillite, ou l'inverse.
     * @param faillite Indique si le joueur est en faillite.
     */
    public void setFaillite(boolean faillite) {
        this.faillite = faillite;
    }

    /**
     * Permet de récupérer le nom du joueur.
     * @return Nom du joueur.
     */
    public String getNom() {
        return nom.get();
    }

    /**
     * Permet de récupérer la propriété correspondant au nom du joueur observable.
     * @return Nom du joueur observable.
     */
    public SimpleStringProperty getNomProperty() {
        return nom;
    }

    /**
     * Permet de récupérer le nombre de tours passés en prison.
     * @return Nombre de tours passés en prison.
     */
    public int getToursEnPrison() {
        return toursEnPrison;
    }

    /**
     * Permet de récupérer le solde du joueur.
     * @return Solde.
     */
    public Solde getSolde() {
        return solde;
    }

    /**
     * Permet de récupérer le pion du joueur.
     * @return Pion.
     */
    public Pion getPion() {
        return pion;
    }

    /**
     * Permet de récupérer le nombre de gares que possède le joueur.
     * @return Nombre de gares possédé par le joueur.
     */
    public int getNbGares() {
        int nbGares = 0;
        for(Case_Achat propriete : proprietes) {
            if(propriete.getType() == ECase.Gare) {
                ++nbGares;
            }
        }

        return nbGares;
    }

    /**
     * Permet de récupérer le nombre de compagnies possédées par le joueur.
     * @return Nombre de compagnies possédéespa le joueur.
     */
    public int getNbCompagnies() {
        int nbCompagnies = 0;
        for(Case_Achat propriete: proprietes) {
            if(propriete.getType() == ECase.Compagnie) {
                ++nbCompagnies;
            }
        }

        return nbCompagnies;
    }

    /**
     * Permet de savoir si le joueur est en prison.
     * @return Vrai si le joueur est en prison. Faux sinon.
     */
    public boolean isEnPrison() {
        return pion.getPosition().getType() == ECase.Prison;
    }

    /**
     * Permet de sortir de prison.
     */
    public void sortirPrison() {
        if(pion.getPosition().getType() == ECase.Prison) {
            Case_Prison prison = (Case_Prison)(pion.getPosition());
            prison.sortir(this);
        }
    }

    /**
     * Permet d'augmenter le nombre de tours en prison.
     */
    public void incToursEnPrison() {
        ++toursEnPrison;
    }

    /**
     * Permet de récupérer le nombre de maisons sur les propriétés possédées par le joueur.
     * @return Nombre de missions du joueur.
     */
    public int getNbMaisons() {
        int nbMaisons = 0;

        for(Case_Achat propriete: proprietes) {
            if(propriete.getType() == ECase.Terrain) {
                Case_Terrain terrain = (Case_Terrain) propriete;
                nbMaisons = terrain.getNbMaisons();
            }
        }

        return nbMaisons;
    }

    /**
     * Permet de récupérer le nombre d'hôtels sur les propriétés possédées par le joueur.
     * @return Nombre d'hôtels du joueur.
     */
    public int getNbHotels() {
        int nbHotels = 0;

        for(Case_Achat propriete : proprietes) {
            if(propriete.getType() == ECase.Terrain) {
                Case_Terrain terrain = (Case_Terrain) propriete;
                if(terrain.isHotel()) {
                    ++nbHotels;
                }
            }
        }

        return nbHotels;
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
