package monopoly.controleur;

import monopoly.modele.Des;
import monopoly.modele.Jeu;

public class ControleurBoutonDe {

    private Des des;

    public ControleurBoutonDe()  {
        this.des = Jeu.getInstance().getDes();
    }

    public void lancerDes() {
        this.des.lancer();
    }
}
