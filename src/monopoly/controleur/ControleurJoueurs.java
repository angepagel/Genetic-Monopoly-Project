package monopoly.controleur;

import monopoly.modele.Des;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

public class ControleurJoueurs {



    public ControleurJoueurs() {

    }

    public void deplacer() {

        Joueur joueur = Jeu.getInstance().getJoueurEnCours();

        // On déplace le pion.
        joueur.getPion().deplacer(Jeu.getInstance().getDes().sommeDes());

        // On affiche sa position dans la console. (A enlever.)
        String nom = joueur.getNom();
        String pos = joueur.getPion().getPosition().getNom();
        System.out.println(nom+" est sur la case "+pos+" !");
    }


}
