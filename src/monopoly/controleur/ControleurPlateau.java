package monopoly.controleur;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.Plateau;
import monopoly.modele.cases.Case;
import monopoly.vue.partieclassique.plateau.PanelCase;
import monopoly.vue.partieclassique.plateau.PanelPlateau;

public class ControleurPlateau {

    private Plateau plateau;
    private PanelPlateau vue;

    public ControleurPlateau(PanelPlateau vue) {
        // Modèle
        this.plateau = Jeu.getInstance().getPlateau();

        // Vue
        this.vue = vue;

    }

    public void vider() {

        for (Joueur joueur : Jeu.getInstance().getJoueurs()) {
            Case caseAVider = joueur.getPion().getPosition();
            PanelCase panel = this.vue.getPanelCase(caseAVider.getId());

        }

    }

    public void miseAJour() {



    }

}
