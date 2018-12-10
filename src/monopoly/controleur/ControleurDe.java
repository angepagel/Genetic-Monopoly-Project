package monopoly.controleur;

import javafx.event.ActionEvent;
import monopoly.modele.Des;
import monopoly.vue.VueDes;

import javafx.scene.image.ImageView;

public class ControleurDe extends Controleur {

    private Des des;

    private VueDes vueDes;

    public ControleurDe(ImageView de1, ImageView de2) {
        this.des = new Des();
        this.vueDes = new VueDes(this.des, de1, de2);
    }

    public void actionLancerDes(ActionEvent action) {
        // TODO : Lancer les dés
        this.des.lancer();
        this.vueDes.miseAJour();
    }
}
