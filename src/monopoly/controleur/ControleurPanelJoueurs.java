package monopoly.controleur;


import monopoly.modele.Jeu;
import monopoly.vue.partieclassique.action.PanelJoueurs;

public class ControleurPanelJoueurs {

    private PanelJoueurs vue;

    public ControleurPanelJoueurs(PanelJoueurs v) {
        this.vue = v;
        Jeu.getInstance().setControleurPanelJoueurs(this);
    }

    public void actualiser() {
        this.vue.actualiser();
    }

}
