package monopoly.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import monopoly.vue.dialogue.DialogueVoirDetailsPropriete;

import java.io.IOException;

public class ControleurGererMesProprietes {

    // TODO : Remplir le tableau

    @FXML
    private TableView tableauGererMesProprietes;

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

    @FXML
    public void actionConstruire(ActionEvent event) {
        // TODO : Gérer l'amélioration de la propriété sélectionnée
    }

    @FXML
    public void actionVendre(ActionEvent event) {
        // TODO : Gérer la vente de la propriété sélectionnée
    }

    @FXML
    public void actionHypothequer(ActionEvent event) {
        // TODO : Gérer l'hypothèque de la propriété sélectionnée
    }

}
