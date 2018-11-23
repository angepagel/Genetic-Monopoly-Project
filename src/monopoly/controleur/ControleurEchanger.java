package monopoly.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import monopoly.vue.dialogue.DialogueVoirDetailsPropriete;

import java.io.IOException;

public class ControleurEchanger {

    @FXML
    private void actionDetailsPropriete1(ActionEvent event) throws IOException {
        new DialogueVoirDetailsPropriete();
        // TODO : Passer une propriété en paramètre
    }

    @FXML
    private void actionDetailsPropriete2(ActionEvent event) throws IOException {
        new DialogueVoirDetailsPropriete();
        // TODO : Passer une propriété en paramètre
    }

    @FXML
    private void actionProposer(ActionEvent event) {
        // TODO : Gérer une proposition d'argent pour l'échange
    }

    @FXML
    private void actionDemander(ActionEvent event) {
        // TODO : Gérer une demande d'argent pour l'échange
    }

}
