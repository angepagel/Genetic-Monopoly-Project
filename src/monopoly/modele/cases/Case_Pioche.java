package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cartes.Carte;

public abstract class Case_Pioche extends Case {

    /**
     * Identifiant de la case.
     */
    private String id;

    /**
     * Numéro de la case de pioche.
     */
    private static int numCase = 0;

    /**
     * Constructeur de la case
     *
     * @param nom      Nom de la case.
     * @param suivante Case suivante.
     */
    public Case_Pioche(String nom, Case suivante) {
        super(nom, suivante);
        id = nom + numCase;
        ++numCase;
    }

    @Override
    public String getId() {
        return id;
    }
}
