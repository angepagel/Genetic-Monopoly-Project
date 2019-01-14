package monopoly.vue.controleurFXML;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import monopoly.modele.Joueur;
import monopoly.modele.cases.Case;
import monopoly.modele.cases.Case_Achat;
import monopoly.modele.cases.Case_Terrain;
import monopoly.modele.cases.ECase;
import monopoly.vue.dialogue.DialogueVoirDetailsPropriete;

import java.io.IOException;

public class ControleurVoirMesProprietes extends Controleur {

    @FXML private TableView tableauVoirMesProprietes;
    @FXML private TableColumn<Case_Achat, String> colNom;
    @FXML private TableColumn<Case_Achat, String> colAmelioration;
    @FXML private TableColumn <Case_Achat, String>colLoyer;
    @FXML private TableColumn<Case_Achat, String> colHypotheque;

    
    @FXML
    public void initialize() {
        colNom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNom()));
        colAmelioration.setCellValueFactory(param -> {
            Case caseParam = param.getValue();
            SimpleStringProperty retour;
            if(caseParam.getType() == ECase.Terrain) {
                Case_Terrain terrain = (Case_Terrain)caseParam;
                retour = new SimpleStringProperty(String.valueOf("$" + terrain.getPrixMaison()));
            }
            else {
                retour = new SimpleStringProperty(String.valueOf("Non applicable"));
            }

            return retour;
        });
        colLoyer.setCellValueFactory(param -> new SimpleStringProperty("$" + param.getValue().getLoyer()));
        colHypotheque.setCellValueFactory(param -> new SimpleStringProperty("$" + param.getValue().getValeurHypotheque()));
    }

    @FXML
    public void setJoueur(Joueur j) {
        tableauVoirMesProprietes.getItems().addAll(j.getProprietes());
    }

    @FXML
    public void actionDetailsPropriete(ActionEvent event) throws IOException {
        Case_Achat c = (Case_Achat) tableauVoirMesProprietes.getSelectionModel().getSelectedItem();
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Aucune propriété sélectionnée.").show();
        }
        else {
            new DialogueVoirDetailsPropriete(c);
        }
    }

}
