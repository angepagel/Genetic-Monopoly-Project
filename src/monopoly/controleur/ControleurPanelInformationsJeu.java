package monopoly.controleur;

import monopoly.modele.Jeu;
import monopoly.vue.partieclassique.action.PanelInformationsJeu;

public class ControleurPanelInformationsJeu {

    private PanelInformationsJeu vue;

    public ControleurPanelInformationsJeu(PanelInformationsJeu vue) {
        Jeu.getInstance().setControleurPanelInformationsJeu(this);
        this.vue = vue;
    }

    public void actualiser() {
        this.vue.actualiser();
    }

}
