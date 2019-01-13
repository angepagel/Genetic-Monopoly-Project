package monopoly.controleur;

import javafx.scene.control.Alert;
import monopoly.modele.Jeu;

public class ControleurJeuMessage {

    public ControleurJeuMessage() {
        Jeu.getInstance().setControleurJeuMessage(this);
    }

    public void afficherMessage(String titre, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION, message);
        a.setHeaderText(null);
        a.setTitle(titre);
        a.show();
    }

    public void afficherMessage(String message) {
        afficherMessage("message", message);
    }

}
