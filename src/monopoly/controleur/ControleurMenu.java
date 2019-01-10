package monopoly.controleur;

import javafx.fxml.FXML;
import java.io.IOException;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import monopoly.vue.AjoutJoueurs;
import monopoly.vue.Menu;

public class ControleurMenu {

    @FXML private Button boutonPartieClassique;
    @FXML private Button boutonPartieIA;
    private AjoutJoueurs ajoutJoueurs;

    public ControleurMenu() {
        ajoutJoueurs = null;
    }

    @FXML
    public void actionPartieClassique() throws IOException {
        if(ajoutJoueurs == null) {
            ajoutJoueurs = new AjoutJoueurs(); // Ouvre la fenêtre de configuration de la partie
            ((Stage)boutonPartieClassique.getScene().getWindow()).close();
        }
    }

    @FXML
    public void actionPartieIA() throws IOException {
        // TODO : Lancer une partie IA
    }

}
