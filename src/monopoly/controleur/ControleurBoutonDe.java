package monopoly.controleur;

import monopoly.modele.Des;
import monopoly.modele.Jeu;
import monopoly.vue.partieclassique.action.VueDes;

public class ControleurBoutonDe extends Controleur {

    private Des des;

    public ControleurBoutonDe()  {
        this.des = Jeu.getInstance().getDes();
    }

    public void lancerDes() {
        this.des.lancer();
    }
}
