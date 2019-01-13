package monopoly.modele;

import javafx.application.Platform;
import monopoly.controleur.ControleurPanelInformationsJeu;
import monopoly.controleur.ControleurJeuMessage;
import monopoly.controleur.ControleurPanelJoueurs;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

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
     * Condition de victoire du jeu.
     */
    private EConditionVictoire conditionVictoire;

    /**
     * Nombre de tours ou de minutes que durera la partie.
     */
    private int fin;

    /**
     * Joueur dont c'est le tour.
     */
    private Joueur joueurEnCours;

    /**
     * Vaut vrai si la partie est finie.
     */
    private boolean partieFinie;

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
     * Timer permettant de compter le temps du jeu.
     */
    private Timer timer;

    /**
     * Chronomètre interne du jeu.
     */
    private Chronometre chronometre;

    /**
     * Contrôleur prenant en charge les informations du jeu sur l'IHM.
     */
    private ControleurPanelInformationsJeu controleurPanelInformationsJeu;

    /**
     * Contrôleur prenant en charge les informations sur le joueur.
     */
    private ControleurPanelJoueurs controleurPanelJoueurs;

    /**
     * Contrôleur se chargeant d'afficher des messages sur le jeu.
     */
    private ControleurJeuMessage controleurJeuMessage;

    /**
     * Argent touché au parc gratuit.
     */
    private int argentParcGratuit;

    /**
     * Vainqueur de la partie.
     */
    private Joueur vainqueur;

    // ----------- Methodes -----------


    /**
     * Constructeur du jeu, ne prenant pas de paramètres puisqu'il s'agit d'un singleton.
     */
    private Jeu() {
        argentParcGratuit = 0;
        joueurs = new ArrayList<>();
        des = new Des();
        conditionVictoire = EConditionVictoire.Faillite;
        fin = -1;
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
     * Permet de définir un joueur aléatoire qui commence.
     * @return Joueur aléatoire à qui c'est maintenant le tour.
     */
    public Joueur setJoueurAleatoire() {
        ArrayList<Joueur> joueurs = getJoueursRestants();
        HashMap<Joueur, Integer> joueursScore = new HashMap<>();
        while(joueurs.size() > 1) {
            for(Joueur j : joueurs) {
                joueursScore.put(j, des.lancerTestPremierJoueur());
            }
            Collection <Integer> scores = joueursScore.values();
            int max = 0;
            for(Integer i : scores) {
                if(i > max) {
                    max = i;
                }
            }

            for(Joueur j : joueursScore.keySet()) {
                if(joueursScore.get(j) != max) {
                    joueurs.remove(j);
                }
            }

            joueursScore.clear();
        }

        joueurEnCours = joueurs.get(0);

        return joueurEnCours;
    }

    /**
     * Initialise le timer.
     */
    public void initialiserTimer() {
        /*
        Cette méthode est séparée de la fonction initialisation()
        car le chronomètre a besoin du contrôleur d'informations du jeu
        pour s'initialiser; or ce contrôleur n'existe pas encore dans initialisation().

        Pour comprendre le code de cette méthode, se reférer aux pages suivantes :
        - https://stackoverflow.com/questions/35512648/adding-a-timer-to-my-program-javafx
        - https://stackoverflow.com/questions/17850191/why-am-i-getting-java-lang-illegalstateexception-not-on-fx-application-thread

        Dû à l'utilisation de la méthode Platform.runLater, on peut supposer que le timer n'est pas exact,
        puisque le moment ou run() est exécuté diffère du moment ou run() est appelé, ceci étant dû
        au fonctionnement des threads.

        Cette méthode pourra éventuellement être recodée avec un AnimationTimer de JavaFX,
        pour laquelle nous ne pouvons nous heurter à ce type de problèmes.
        */

        Jeu self = this;

        this.chronometre = new Chronometre();
        this.timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        self.chronometre.addSeconde();
                        self.controleurPanelInformationsJeu.actualiser();
                    }
                });
            }

        };
        this.timer.schedule(timerTask, 1000l,1000l);
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
     * Accesseur du chronomètre.
     * @return Chronomètre.
     */
    public Chronometre getChronometre() {
        return chronometre;
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

        nbTours++;
        this.controleurPanelInformationsJeu.actualiser();
        this.joueurEnCours.getPion().getControleurCaseJoueur().actualiserCase();

        this.joueurEnCours.setDejaJoue(false);
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
     * Mutateur du contrôleur d'informations du jeu.
     * @param controleurPanelInformationsJeu Mutateur du contrôleur d'informations du jeu.
     */
    public void setControleurPanelInformationsJeu(ControleurPanelInformationsJeu controleurPanelInformationsJeu) {
        this.controleurPanelInformationsJeu = controleurPanelInformationsJeu;
    }

    /**
     * Mutateur du contrôleur de joueurs.
     * @param c Contrôleur de joueur.
     */
    public void setControleurPanelJoueurs(ControleurPanelJoueurs c) {
        this.controleurPanelJoueurs = c;
    }

    /**
     * Accesseur du contrôleur de messages du jeu.
     * @return Contrôleur de messages du jeu.
     */
    public ControleurJeuMessage getControleurJeuMessage() {
        return controleurJeuMessage;
    }

    /**
     * Mutateur du contrôleur de messages du jeu.
     * @param controleurJeuMessage Contrôleur de messages du jeu.
     */
    public void setControleurJeuMessage(ControleurJeuMessage controleurJeuMessage) {
        this.controleurJeuMessage = controleurJeuMessage;
    }

    /**
     * Accesseur du contrôleur de joueurs.
     */
    public ControleurPanelJoueurs getControleurPanelJoueurs() {
        return this.controleurPanelJoueurs;
    }

    /**
     * Fonction main temporaire de test
     */
    public static void  main(String[] args) {
        Jeu j = Jeu.getInstance();
        j.run();
    }

    /**
     * Permet d'initialiser la position des pions.
     */
    public void initPositions() {
        for(Joueur j : joueurs)
        {
            Pion p;
            if((p = j.getPion()) != null) {
                if(p.getPosition() == null) {
                    p.setPositionSansVue(plateau.getCaseDepart());
                }
            }
        }
    }

    /**
     * Permet de savoir combien d'argent il y a dans le parc gratuit.
     * @return L'argent contenu dans le parc gratuit
     */
    public int getArgentParcGratuit() {
        return argentParcGratuit;
    }

    /**
     * Permet de réinitialiser l'argent qui se trouve dans le parc gratuit.
     */
    public void resetArgentParcGratuit() {
        argentParcGratuit = 0;
    }

    /**
     * Permet d'ajouter de l'argent dans le parc gratuit.
     * @param argent Montant à ajouter.
     */
    public void addArgentParcGratuit(int argent) {
        argentParcGratuit += argent;
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
                System.out.println("Vous êtes passé par la case départ ! Vous avez reçu " + j.getArgentCaseDepart() + "$. Vous avez donc " + j.getJoueurEnCours().getSolde().getMonnaie() + "$");
            }

            System.out.println("Vous arrivez sur la case " + j.getJoueurEnCours().getPion().getPosition().getNom() + ".");
            System.out.println("Vous possédez maintenant " + j.getJoueurEnCours().getSolde().getMonnaie() + "$.");

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
            System.out.println(joueur.getNom() + " a " + joueur.getSolde().getMonnaie() + "$.");
        }

        System.out.println("Merci d'avoir joué !");
    }


    /**
     * Permet de savoir quelle est la condition de victoire de la partie en cours.
     * @return Condition de victoire de la partie en cours.
     */
    public EConditionVictoire getConditionVictoire() {
        return conditionVictoire;
    }

    /**
     * Permet de définir la condition de victoire de la partie, par défaut, la faillite.
     * @param conditionVictoire Condition de victoire à définir.
     */
    public void setConditionVictoire(EConditionVictoire conditionVictoire) {
        this.conditionVictoire = conditionVictoire;
    }

    /**
     * Permet de savoir quel est la durée de la partie avant la fin programmée (en minutes ou en tours), inuile si c'est la faillite.
     * @return Durée de la partie.
     */
    public int getFin() {
        return fin;
    }

    /**
     * Permet de définir quelle est la durée de la parti en cours, avant la fin programmée (minutes ou tours), inutile si faillite.
     * @param fin Durée de la partie.
     */
    public void setFin(int fin) {
        this.fin = fin;
    }

    private void finirPartie() {
        partieFinie = true;
        choisirVainqueur();
    }

    private boolean joueursRestants() {
        int nbJoueurs = 0;
        for(Joueur j : joueurs) {
            if(!j.isFaillite()) {
                ++nbJoueurs;
            }
        }

        return nbJoueurs >= 2;
    }

    private Joueur choisirVainqueur() {
        ArrayList<Joueur> joueurs = getJoueursRestants();
        if(joueurs.size() < 2) {
            if(joueurs.size() >= 1) {
                vainqueur = joueurs.get(0);
            }
            else {
                vainqueur = null;
            }
        }

        int valeurArgent = -1;
        Joueur meilleurJoueur = null;

        for(Joueur j : joueurs) {
            if(j.getValeur() > valeurArgent) {
                meilleurJoueur = j;
                valeurArgent = j.getValeur();
            }
        }

        vainqueur = meilleurJoueur;

        return vainqueur;
    }

    private ArrayList<Joueur> getJoueursRestants() {
        ArrayList<Joueur> joueursRetour = new ArrayList<>();
        for(Joueur j : joueurs) {
            if(!j.isFaillite()) {
                joueursRetour.add(j);
            }
        }

        return joueursRetour;
    }

    /**
     * Permet de tester si la partie est finie.
     * @return Définit si la partie est finie.
     */
    public boolean isPartieFinie() {
        if(!partieFinie) {
            switch(conditionVictoire) {
                case NbTours:
                    if(fin > nbTours) {
                        finirPartie();
                    }
                    break;
                case Temps:
                    if(chronometre.getMinutes() <= fin) {
                        finirPartie();
                    }
                    break;
            }
            if(!joueursRestants()) {
                finirPartie();
            }
        }
        return partieFinie;
    }
}
