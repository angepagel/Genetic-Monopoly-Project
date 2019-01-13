package monopoly.vue.controleurFXML;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cases.Case;
import monopoly.modele.cases.Case_Achat;
import monopoly.modele.cases.Case_Terrain;
import monopoly.modele.cases.ECase;
import monopoly.vue.dialogue.DialogueVoirDetailsPropriete;

import java.io.IOException;
import java.util.ArrayList;

public class ControleurVoirLesProprietes extends Controleur {

    @FXML private TableView tableauVoirLesProprietes;
    @FXML private TableColumn<Case_Achat, String> colNom;
    @FXML private TableColumn<Case_Achat, String> colProprietaire;
    @FXML private TableColumn<Case_Achat, String> colAmelioration;
    @FXML private TableColumn<Case_Achat, String> colLoyer;


    @FXML
    public void initialize() {
        colNom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNom()));
        colProprietaire.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getProprietaire().getNom()));
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
        colLoyer.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getLoyer())));

        /*
        ArrayList<Case> listeCases = Jeu.getInstance().getPlateau().getListeCases();

        for (Case c : listeCases) {
            if (c.getType() == ECase.Terrain || c.getType() == ECase.Gare || c.getType() == ECase.Compagnie) {
                tableauVoirLesProprietes.getItems().addAll(c);
            }
        }
        */
    }

    @FXML
    public void actionDetailsPropriete(ActionEvent event) throws IOException {
        Case_Terrain c = (Case_Terrain) tableauVoirLesProprietes.getSelectionModel().getSelectedItem();
        new DialogueVoirDetailsPropriete(c);
    }

}
