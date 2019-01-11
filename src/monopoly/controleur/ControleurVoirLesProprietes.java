package monopoly.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import monopoly.vue.dialogue.DialogueVoirDetailsPropriete;

import java.io.IOException;

public class ControleurVoirLesProprietes {

    // TODO : Remplir le tableau

    @FXML
    private TableView tableauVoirLesProprietes;

    @FXML
    private TableColumn colNom;

    @FXML
    private TableColumn colProprietaire;

    @FXML
    private TableColumn colAmelioration;

    @FXML
    private TableColumn colLoyer;

    @FXML
    public void actionDetailsPropriete(ActionEvent event) throws IOException {
        new DialogueVoirDetailsPropriete();
        // TODO : Passer une propriété en paramètre
    }

}
