package monopoly.controleur;

import monopoly.modele.Des;
import monopoly.modele.Jeu;
import monopoly.vue.partieclassique.action.VueDes;

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
