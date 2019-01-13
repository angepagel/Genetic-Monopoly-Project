package monopoly.controleur;

import javafx.scene.control.Alert;
import monopoly.modele.Des;
import monopoly.modele.Jeu;

/**
 * Contrôleur gérant les actions du panel de tirage des dés.
 */
public class ControleurPanelTirageDes {

    private Des des;

    public ControleurPanelTirageDes()  {
        this.des = Jeu.getInstance().getDes();
    }

    public void lancerDes() {
        if (!Jeu.getInstance().getJoueurEnCours().aDejaJoue() ) {
            this.des.lancer();
        }
        else {
            new Alert(Alert.AlertType.WARNING, " Vous ne pouvez plus lancer vos dés !").show();
        }
    }
}
