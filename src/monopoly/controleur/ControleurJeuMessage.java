package monopoly.controleur;

import javafx.scene.control.Alert;
import monopoly.modele.Jeu;

public class ControleurJeuMessage {

    public ControleurJeuMessage() {
        Jeu.getInstance().setControleurJeuMessage(this);
    }

    public void afficherMessage(String message) {
        new Alert(Alert.AlertType.INFORMATION, message).show();
    }

}
