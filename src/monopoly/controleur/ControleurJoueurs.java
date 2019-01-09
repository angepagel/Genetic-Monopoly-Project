package monopoly.controleur;

import monopoly.modele.Des;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cases.Case_Prison;

public class ControleurJoueurs {



    public ControleurJoueurs() {

    }

    public void deplacer() {

        Joueur joueur = Jeu.getInstance().getJoueurEnCours();
        if(!joueur.isEnPrison()) {
            // On déplace le pion.
            if (Jeu.getInstance().getDes().estDouble()) {
                if (!joueur.incNbDoubles()) {
                    avancer(joueur);
                }
            } else {
                avancer(joueur);
                joueur.resetNbDoubles();
            }
        }
        else {
            System.out.println("Pas en prison.");
            if(Jeu.getInstance().getDes().estDouble()) {
                joueur.sortirPrison();
                avancer(joueur);
            }
            else {
                joueur.incToursEnPrison();
                if(joueur.getToursEnPrison() >= 3) {
                    joueur.getSolde().payer(50);
                    joueur.sortirPrison();
                    avancer(joueur);
                }
            }
        }

        // On affiche sa position dans la console. (A enlever.)
        String nom = joueur.getNom();
        String pos = joueur.getPion().getPosition().getNom();
        System.out.println(nom+" est sur la case "+pos+" !");
    }

    private void avancer(Joueur joueur) {
        joueur.getPion().deplacer(Jeu.getInstance().getDes().sommeDes());
    }
}
