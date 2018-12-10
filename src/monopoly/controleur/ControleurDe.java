package monopoly.controleur;

import javafx.event.ActionEvent;
import monopoly.modele.Des;
import monopoly.modele.Jeu;
import monopoly.vue.VueDes;

import javafx.scene.image.ImageView;

public class ControleurDe extends Controleur {

    private Des des;
    private VueDes vueDes;

    public ControleurDe(VueDes vueDes)  {
        this.des = Jeu.getInstance().getDes();
        this.vueDes = vueDes;
    }

    public void lancerDes() {
        // TODO : Lancer les dés
        this.des.lancer();
        this.vueDes.miseAJour();
    }
}
