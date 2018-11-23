package monopoly.controleur;

import javafx.event.ActionEvent;
import monopoly.modele.Des;
import monopoly.vue.Vue_Des;

import javafx.scene.image.ImageView;

/**
 * Created by maxim on 23/11/2018.
 */
public class Controleur_De extends Controleur{

    private Des des;

    private Vue_Des vueDes;

    public Controleur_De(ImageView de1, ImageView de2) {
        this.des = new Des();
        this.vueDes = new Vue_Des(this.des, de1, de2);
    }

    public void actionLancerDes(ActionEvent action) {
        // TODO : Lancer les dés
        this.des.lancer();
        this.vueDes.miseAJour();
    }
}
