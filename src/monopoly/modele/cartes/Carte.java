package monopoly.modele.cartes;

import monopoly.modele.Joueur;

/**
 * Représente une carte
 */
public abstract class Carte {
    /**
     * Représente le texte de la carte
     */
    private String texte;

    /**
     * Action effectuée quand le joueur pioche la carte.
     * @param j Joueur qui pioche la carte
     */
    public abstract void action(Joueur j);

    public Carte(String texte) {
        this.texte = texte;
    }

    /**
     * Permet de savoir si une carte est immédiatement utilisée
     * @return Faux si elle ne doit pas être remise dans le paquet.
     */
    public boolean usageImmediat() {
        return true;
    }

    /**
     * Permet de  récupérer le texte de la carte.
     * @return Texte de la carte.
     */
    public String getTexte() {
        return texte;
    }

    @Override
    public String toString() {
        return getTexte();
    }

    /**
     * Vaut vrai s'il est inutile d'afficher une boîte de dialogue expliquant l'effet de la carte.
     * @return Vrai s'il est inutile d'afficher une boîte de dialogue.
     */
    public boolean affichageInclus() {return false;}
}
