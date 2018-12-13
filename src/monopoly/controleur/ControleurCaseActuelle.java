package monopoly.controleur;

import monopoly.modele.Pion;
import monopoly.vue.partieclassique.action.PanelCaseActuelle;

public class ControleurCaseActuelle {

    private Pion modele;
    private PanelCaseActuelle vue;

    public ControleurCaseActuelle(Pion pion, PanelCaseActuelle vue) {

        this.modele = pion;
        this.modele.setControleurCaseActuelle(this);
        this.vue = vue;

    }

    public void actualiser() {
        this.vue.actualiser(this.modele);
    }



}
