package monopoly.modele;

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
     * Initialisation des dés.
     */
    public Des() {
        random = new Random();
    }

    /**
     * Permet de lancer les dés.
     * @return Somme des valeurs des dés.
     */
    public int lancer() {
        de1 = random.nextInt(5) + 1;
        de2 = random.nextInt(5) + 1;
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
}
