package monopoly.controleur;

import javafx.fxml.FXML;
import java.io.IOException;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import monopoly.vue.AjoutIAs;
import monopoly.vue.AjoutJoueurs;
import monopoly.vue.Menu;

public class ControleurMenu {

    @FXML private Button boutonPartieClassique;
    @FXML private Button boutonPartieIA;
    private AjoutJoueurs ajoutJoueurs;
    private AjoutIAs ajoutIAs;
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
        if(ajoutIAs == null) {
            ajoutIAs = new AjoutIAs(); // Ouvre la fenêtre de configuration de la partie
            ((Stage)boutonPartieIA.getScene().getWindow()).close();
        }
    }

}
