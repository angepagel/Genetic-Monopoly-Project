package monopoly.modele;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Représente le jeu
 * @author Yan BUATOIS
 */
public class Jeu {
    /**
     * Nombre de tours
     */
    private int nbTours;

    /**
     * Instance
     */
    private static Jeu instance;

    private ArrayList<Joueur> joueurs;

    private Plateau plateau;
    private Des des;

    /**
     * Constructeur du jeu, ne prenant pas de paramètres puisqu'il s'agit d'un singleton.
     */
    private Jeu() {
        // TODO : Initialiser les attributs
        joueurs = new ArrayList<>();
        des = new Des();
        initialisation();
    }

    /**
     * Renvoie une instance du jeu
     * @return Le jeu.
     */
    public static Jeu getInstance() {
        if(instance == null) {
            instance = new Jeu();
        }
        return instance;
    }

    /**
     * Renvoie vrai tant qu'on est en jeu
     * @return vrai si on est en jeu, faux sinon.
     */
    public boolean etat() {
        // TODO : Vérifier si l'on est encore en jeu.
        throw new NotImplementedException();
    }

    public int getNbJoueurs() {
        return joueurs.size();
    }

    public int getMontantInitial() {
        return 1500;
    }

    public int getNbTours() {
        return nbTours;
    }

    public void initialisation() {
        // TODO : Initialiser la partie
        nbTours = 0;
        plateau = new Plateau();
    }

    public void encheres() {
        // TODO : Implémenter les enchères
    }

    public int getNbMaxMaisons() {
        return 4;
    }

    public void creerJoueurs() {
        // TODO : Implémenter la création des joueurs
    }

    public int getMaxDoubles() {
        return 3;
    }

    public int getArgentCaseDepart() {
        return 200;
    }

    public Joueur getVainqueur() {
        // TODO : Déterminer le vainqueur
        throw new NotImplementedException();
    }

    public Des getDes() {
        return des;
    }
}
