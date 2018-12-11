package monopoly.controleur;

import javafx.fxml.FXML;
import java.io.IOException;
import monopoly.vue.AjoutJoueurs;

public class ControleurMenu {

    @FXML
    public void actionPartieClassique() throws IOException {
        new AjoutJoueurs(); // Ouvre la fenêtre de configuration de la partie
    }

    @FXML
    public void actionPartieIA() throws IOException {
        // TODO : Lancer une partie IA
    }

}
