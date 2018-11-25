package monopoly.controleur;

import javafx.fxml.FXML;
import monopoly.vue.Partie;

import java.io.IOException;

public class ControleurMenu {

    @FXML
    public void actionPartieClassique() throws IOException {
        new Partie().start();
    }

    @FXML
    public void actionPartieIA() throws IOException {
        // TODO : Lancer une partie IA
    }

}
