package monopoly.controleur;

import monopoly.modele.Des;
import monopoly.vue.partieclassique.action.VueDes;

public class ControleurMiseAJourDe {

    private Des des;
    private VueDes vueDes;

    public ControleurMiseAJourDe(Des des, VueDes vueDes) {
        this.des = des;
        this.vueDes = vueDes;
    }

    public void lancer() {
        this.vueDes.miseAJour();
    }

}
