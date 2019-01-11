package monopoly.controleur;


import monopoly.modele.Jeu;
import monopoly.vue.partieclassique.action.PanelJoueurs;

public class ControleurJoueurs {

    private PanelJoueurs vue;

    public ControleurJoueurs(PanelJoueurs v) {
        this.vue = v;
        Jeu.getInstance().setControleurJoueurs(this);
    }

    public void actualiser() {
        this.vue.actualiser();
    }

}
