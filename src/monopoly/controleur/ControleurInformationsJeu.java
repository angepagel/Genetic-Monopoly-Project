package monopoly.controleur;

import monopoly.modele.Jeu;
import monopoly.vue.partieclassique.action.PanelInformationsJeu;

public class ControleurInformationsJeu {

    private PanelInformationsJeu vue;

    public ControleurInformationsJeu(PanelInformationsJeu vue) {
        Jeu.getInstance().setControleurInformationsJeu(this);
        this.vue = vue;
    }

    public void actualiser() {
        this.vue.actualiser();
    }

}
