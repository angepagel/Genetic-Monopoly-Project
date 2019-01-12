package monopoly.vue.controleurFXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import monopoly.vue.dialogue.DialogueVoirDetailsPropriete;

import java.io.IOException;

public class ControleurVoirMesProprietes {

    // TODO : Remplir le tableau

    @FXML
    private TableView tableauVoirMesProprietes;

    @FXML
    private TableColumn colNom;

    @FXML
    private TableColumn colAmelioration;

    @FXML
    private TableColumn colLoyer;

    @FXML
    private TableColumn colHypotheque;

    @FXML
    public void actionDetailsPropriete(ActionEvent event) throws IOException {
        new DialogueVoirDetailsPropriete();
        // TODO : Passer une propriété en paramètre
    }

}
