package monopoly.modele;

import javafx.beans.property.SimpleStringProperty;

/**
 * Représente un joueur humain (par opposition aux IAs).
 */
public class Humain extends Joueur {
    public Humain(String nom) {
        super(nom);
    }

    @Override
    public Joueur getJoueur() {
        return this;
    }

    @Override
    public EJoueur getType() {
        return EJoueur.Humain;
    }




}
