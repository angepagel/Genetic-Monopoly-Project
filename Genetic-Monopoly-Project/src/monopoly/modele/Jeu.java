package monopoly.modele;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

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

    private Joueur joueurEnCours;

    private Plateau plateau;
    private Des des;

    /**
     * Constructeur du jeu, ne prenant pas de paramètres puisqu'il s'agit d'un singleton.
     */
    private Jeu() {
        // TODO : Initialiser les attributs
        joueurs = new ArrayList<>();
        des = new Des();
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

    public Plateau getPlateau() {
        return plateau;
    }

    public Joueur getJoueurEnCours() {
        return joueurEnCours;
    }

    public void setJoueurEnCours(Joueur joueur) {
        joueurEnCours = joueur;
    }

    /**
     * Fonction main temporaire de test
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jeu j = Jeu.getInstance();

        j.initialisation();
        Joueur j1 = new Humain("Yan");
        j.joueurs.add(j1);
        j1.choisirPion(new Pion("Canon"));

        Joueur j2 = new Humain("Ange");
        j.joueurs.add(j2);
        j2.choisirPion(new Pion("Cheval"));

        j.setJoueurEnCours(j1);

        boolean continuer = true;

        do {
            boolean dbl = false;
            System.out.println("À " + j.getJoueurEnCours().getNom() + " de jouer !");
            j.getDes().lancer();
            System.out.println("Un " + j.getDes().valDe1() + " et un " + j.getDes().valDe2() + " (Total : " + j.getDes().sommeDes() +") !");
            if(j.getDes().estDouble()) {
                System.out.println("C'est un double !");
                dbl = true;
            }

            j.getJoueurEnCours().getPion().deplacer(j.getDes().sommeDes());

            if(j.getJoueurEnCours().getPion().isCaseDepartLast()) {
                System.out.println("Vous êtes passé par la case départ ! Vous avez reçu " + j.getArgentCaseDepart() + "€. Vous avez donc " + j.getJoueurEnCours().getSolde().getMonnaie() + "€");
            }

            System.out.println("Vous arrivez sur la case " + j.getJoueurEnCours().getPion().getPosition().getNom() + ".");
            System.out.println("Vous possédez maintenant " + j.getJoueurEnCours().getSolde().getMonnaie() + "€.");

            if(dbl) {
                System.out.println(j.getJoueurEnCours().getNom() + " rejoue.");
            }
            else {
                int nextIndex = (j.joueurs.indexOf(j.joueurEnCours) + 1) % j.joueurs.size();
                j.setJoueurEnCours(j.joueurs.get(nextIndex));
                System.out.println("C'est au tour de " + j.getJoueurEnCours().getNom() + " de jouer.");
                System.out.println("Souhaitez-vous continuer ? [O/N]");
                String saisie = sc.nextLine();
                if(saisie.equals("N") || saisie.equals("n")) {
                    continuer = false;
                }
            }
        } while(continuer);

        for(Joueur joueur : j.joueurs) {
            System.out.println(joueur.getNom() + " a " + joueur.getSolde().getMonnaie() + "€.");
        }

        System.out.println("Merci d'avoir joué !");
    }
}
