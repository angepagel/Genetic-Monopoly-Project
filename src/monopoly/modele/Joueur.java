package monopoly.modele;

import javafx.beans.property.SimpleStringProperty;
import monopoly.modele.cartes.Carte_SortiePrison;
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

    private SimpleStringProperty type;

    /**
     * Le joueur a déjà joué
     */
    private boolean dejaJoue;

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
        this.type = new SimpleStringProperty(this.getType().toString());
        this.proprietes = new ArrayList<>();
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
     */
    public void incNbDoubles() {
        nbDoubles++;
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
     * Permet de mettre le joueur en faillite.
     */
    public void faireFaillite() {
        faillite = true;
        for(Case_Achat achat : proprietes) {
            achat.abandonPropriete();
        }

        if(sortiePrisonCaisse != null) Jeu.getInstance().getGestionnaireCartes().remettreCaisseCommunaute(sortiePrisonCaisse);
        if(sortiePrisonChance != null) Jeu.getInstance().getGestionnaireCartes().remettreChance(sortiePrisonChance);

        proprietes.clear();
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
     * Permet de récupérer la propriété correspondant au type du joueur observable.
     * @return Type du joueur observable
     */
    public  SimpleStringProperty getTypeProperty(){
        return type;
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
     * Permet de récupérer les propriétés du joueur.
     * @return Liste de Case_Achat.
     */
    public ArrayList<Case_Achat> getProprietes() {
        return proprietes;
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
            toursEnPrison = 0;
            prison.sortir(this);
        }
    }

    /**
     * Permet de savoir combien de doubles ont été effectués ce tour-ci.
     * @return Le nombre de doubles de ce tour.
     */
    public int getNbDoubles() {
        return nbDoubles;
    }

    /**
     * Le joueur va en prison.
     */
    public void allerEnPrison() {
        getPion().setPosition(Jeu.getInstance().getPlateau().getPrison());
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

    /**
     * Permet de savoir si le joueur a déjà joué.
     * @return Vrai s'il a déjà joué.
     */
    public boolean aDejaJoue() {
        return dejaJoue;
    }

    /**
     * Permet de définir si le joueur a déjà joué.
     * @param dj Vrai si le joueur doit avoir déjà joué.
     */
    public void setDejaJoue(boolean dj) {
        dejaJoue = dj;
    }

    /**
     * Permet d'acheter une case.
     * @param achat Case à acheter
     * @throws Exception Lorsque la propriété appartient déjà à un joueur.
     */
    public void acheterCase(Case_Achat achat) throws Exception {
        if(achat.getProprietaire() != null) {
            throw new Exception("La propriété appartient déjà à "+achat.getProprietaire().getNom()+".");
        }
        else {
            solde.payer(achat.getPrix());
            proprietes.add(achat);
            achat.setProprietaire(this);
        }
    }

    /**
     * Permet de savoir la valeur amassée par le joueur.
     * @return Valeur des propriétés du joueur.
     */
    public int getValeur() {
        int valeur = solde.getMonnaie();
        for(Case_Achat caseAchat : proprietes) {
            if(caseAchat.isHypotheque()) {
                valeur += caseAchat.getValeurHypotheque();
            }
            else {
                valeur += caseAchat.getPrix();
                if(caseAchat.getType() == ECase.Terrain) {
                    Case_Terrain terrain = (Case_Terrain)caseAchat;
                    valeur += terrain.getNbMaisons() * terrain.getPrixMaison();
                    valeur += (terrain.isHotel()) ? terrain.getPrixMaison(): 0;
                }
            }
        }
        return valeur;
    }

    /**
     * Le joueur a choisi de rester en prison.
     */
    public void resterEnPrison() {
        return;
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
                Objects.equals(solde, joueur.solde) &&
                Objects.equals(proprietes, joueur.proprietes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, faillite, nbDoubles, toursEnPrison, solde, proprietes);
    }

    /**
     * Le joueur a choisi de payer la prison.
     */
    public void payerPrison() {
        solde.payerImpots(50);
        sortirPrison();
    }

    /**
     * Le joueur a fait un double et sort donc de prison.
     */
    public void sortirPrisonDouble() {
        sortirPrison();
    }

    /**
     * Lorsque le joueur choisit d'utiliser la carte chance pour sortir de prison.
     */
    public void sortirPrisonChance() {
        sortirPrisonCarte(getSortiePrisonChance());
        sortirPrison();
    }

    /**
     * Lorsque le joueur choisit d'utiliser la carte caisse de communauté pour sortir de prison.
     */
    public void sortirPrisonCaisse() {
        sortirPrisonCarte(getSortiePrisonCaisse());
        sortirPrison();
    }

    private void sortirPrisonCarte(Carte_SortiePrison carte) {
        carte.utiliser();
    }
}
