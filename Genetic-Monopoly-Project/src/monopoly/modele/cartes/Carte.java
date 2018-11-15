package monopoly.modele.cartes;

import monopoly.modele.Joueur;

public abstract class Carte {
    private String texte;

    public abstract void action(Joueur j);

    public Carte(String texte) {
        this.texte = texte;
    }
}
