package monopoly.modele;

import monopoly.controleur.ControleurMiseAJourDe;

import java.util.Random;

public class Des {
    /**
     * Représente la valeur du dé 1.
     */
    private int de1;

    /**
     * Représente la valeur du dé 2.
     */
    private int de2;

    /**
     * Objet aléatoire des dés.
     */
    private Random random;

    /**
     * Contrôleur qui met à jour les dés.
     */
    private ControleurMiseAJourDe controleur;

    /**
     * Initialisation des dés.
     */
    public Des() {
        random = new Random();
    }

    private int lancerSimple() {
        de1 = random.nextInt(5) + 1;
        de2 = random.nextInt(5) + 1;

        return sommeDes();
    }

    /**
     * Permet de lancer les dés afin de savoir qui est le premier joueur.
     * @return Retourne le résultat obtenu.
     */
    public int lancerTestPremierJoueur() {
        lancerSimple();

        return sommeDes();
    }

    /**
     * Permet de lancer les dés.
     * @return Somme des valeurs des dés.
     */
    public int lancer() {
        lancerSimple();
//        de1 = 1;
//        de2 = 1;

        this.controleur.lancer();
        Joueur j = Jeu.getInstance().getJoueurEnCours();

        if(j.isEnPrison()) {
            if(estDouble()) {
                j.sortirPrison();
                j.incNbDoubles();
                j.getPion().deplacer(sommeDes());
            }
            else {
                j.incToursEnPrison();
                j.setDejaJoue(true);
                j.resetNbDoubles();
            }
        }
        else {
            if(estDouble()) {
                j.incNbDoubles();
            }
            else {
                j.resetNbDoubles();
                j.setDejaJoue(true);
            }
            if(j.getNbDoubles() >= 3) {
                j.allerEnPrison();
                j.resetNbDoubles();
                j.setDejaJoue(true);
            }
            else {
                j.getPion().deplacer(sommeDes());
            }
        }
        return sommeDes();
    }

    /**
     * Valeur du dé 1.
     * @return Valeur du dé 1.
     */
    public int valDe1() {
        return de1;
    }

    /**
     * Valeur du dé 2.
     * @return Valeur du dé 2.
     */
    public int valDe2() {
        return de2;
    }

    /**
     * Somme des valeurs des deux dés.
     * @return Somme des valeurs des deux dés.
     */
    public int sommeDes() {
        return  de1 + de2;
    }

    /**
     * Permet de savoir si les nombres sont un double.
     * @return Vrai s'il s'agit d'un double.
     */
    public boolean estDouble() {
        return (de1 == de2);
    }

    /**
     * Setter du contrôleur.
     * @param controleur Contrôleur du dé.
     */
    public void setControleur(ControleurMiseAJourDe controleur) {
        this.controleur = controleur;
    }

    /**
     * Getter du contrôleur.
     * @return Contrôleur de mise à jour du dé.
     */
    public ControleurMiseAJourDe getControleur() {
        return this.controleur;
    }

}
