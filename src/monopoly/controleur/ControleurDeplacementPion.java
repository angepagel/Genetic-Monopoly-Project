package monopoly.controleur;

import monopoly.modele.Pion;
import monopoly.vue.partieclassique.action.VuePion;

public class ControleurDeplacementPion {

    private Pion pion;
    private VuePion vuePion;

    public ControleurDeplacementPion(Pion pion, VuePion vuePion) {
        this.pion = pion;
        this.vuePion = vuePion;
    }

    public void deplacer() {
        this.vuePion.miseAJour();
    }

}
