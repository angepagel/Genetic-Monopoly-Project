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

    /**
     * Liste des joueurs.
     */
    private ArrayList<Joueur> joueurs;

    /**
     * Joueur dont c'est le tour.
     */
    private Joueur joueurEnCours;

    /**
     * Plateau de jeu
     */
    private Plateau plateau;

    /**
     * Dés
     */
    private Des des;

    /**
     * Gestionnaire des cartes du jeu.
     */
    private GestionnaireCartes gestionnaireCartes;

    /**
     * Constructeur du jeu, ne prenant pas de paramètres puisqu'il s'agit d'un singleton.
     */
    private Jeu() {
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

    /**
     * Permet de récupérer le nombre de joueurs de la partie
     * @return Nombre de joueurs.
     */
    public int getNbJoueurs() {
        return joueurs.size();
    }

    /**
     * Permet de récupérer le montant initial possédé par les joueurs au début de la partie.
     * @return Montant initial.
     */
    public int getMontantInitial() {
        return 1500;
    }

    /**
     * Permet de récupérer le nombre de tours qui se sont écoulés.
     * @return Nombre de tours.
     */
    public int getNbTours() {
        return nbTours;
    }

    /**
     * Permet d'initialiser la partie.
     */
    public void initialisation() {
        nbTours = 0;
        plateau = new Plateau();
        gestionnaireCartes = new GestionnaireCartes();
    }

    /**
     * Logique des enchères.
     */
    public void encheres() {
        // TODO : Implémenter les enchères
    }

    /**
     * Permet de récupérer le nombre maximal de maisons sur une propriété avant un hôtel
     * @return Le nombre maximal de maisons qu'une propriété peut avoir.
     */
    public int getNbMaxMaisons() {
        return 4;
    }

    /**
     * Permet d'initialiser les joueurs.
     */
    public void creerJoueurs() {
        // TODO : Implémenter la création des joueurs
    }

    /**
     * Permet de savoir le nombre maximal de doubles autorisé avant d'aller en prison.
     * @return Le nombre maximal de doubles autorisés.
     */
    public int getMaxDoubles() {
        return 3;
    }

    /**
     * Permet de savoir combien on gagne en passant par la case départ.
     * @return L'argent gagné en passant par la case départ.
     */
    public int getArgentCaseDepart() {
        return 200;
    }

    /**
     * Permet de savoir qui est le vainqueur.
     * @return Récupère le vainqueur.
     */
    public Joueur getVainqueur() {
        // TODO : Déterminer le vainqueur
        throw new NotImplementedException();
    }

    /**
     * Permet de récupérer les dés.
     * @return Les dés.
     */
    public Des getDes() {
        return des;
    }

    /**
     * Permet de récupérer le plateau.
     * @return Le plateau
     */
    public Plateau getPlateau() {
        return plateau;
    }

    /**
     * Permet de récupérer le joueur dont c'est le tour.
     * @return Joueur dont c'est le tour
     */
    public Joueur getJoueurEnCours() {
        return joueurEnCours;
    }

    /**
     * Permet de définir le joueur dont c'est le tour.
     * @param joueur Joueur dont c'est le tour.
     */
    public void setJoueurEnCours(Joueur joueur) {
        joueurEnCours = joueur;
    }

    /**
     * Permet de faire passer le tour au prochain joueur dans l'ArrayList.
     */
    public void prochainJoueur() {
        int nextIndex = (joueurs.indexOf(joueurEnCours) + 1) % joueurs.size();
        setJoueurEnCours(joueurs.get(nextIndex));
    }

    /**
     * Permet de récupérer le gestionnaire de cartes.
     * @return Gestionnaire de cartes.
     */
    public GestionnaireCartes getGestionnaireCartes() {
        return gestionnaireCartes;
    }

    /**
     * Permet de récupérer la liste des joueurs.
     * @return Liste des joueurs.
     */
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
    
    public void setJoueur(Joueur j,Pion p){
        j.choisirPion(p);
        joueurs.add(j);
        
    }

    /**
     * Fonction main temporaire de test
     */
    public static void  main(String[] args) {
        Jeu j = Jeu.getInstance();
        j.run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        Jeu j = this;

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
