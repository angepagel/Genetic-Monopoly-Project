package monopoly.controleur;

import javafx.fxml.FXML;
import monopoly.vue.Partie;

import java.io.IOException;
import monopoly.vue.VueLancementPartie;

public class ControleurMenu {

    @FXML
    public void actionPartieClassique() throws IOException {
        //new VueLancementPartie();
        new Partie();
        
    }

    @FXML
    public void actionPartieIA() throws IOException {
        // TODO : Lancer une partie IA
    }

}
