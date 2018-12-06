package monopoly.controleur;

import javafx.fxml.FXML;

import java.io.IOException;
import monopoly.vue.VueLancementPartie;

public class ControleurMenu {
    
    
    private VueLancementPartie partie;
    @FXML
    public void actionPartieClassique() throws IOException {
         partie = VueLancementPartie.getInstance(); 
         partie.initWindow();
        //new Partie();
        
    }

    @FXML
    public void actionPartieIA() throws IOException {
        // TODO : Lancer une partie IA
    }

}
