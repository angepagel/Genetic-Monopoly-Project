package monopoly.vue.controleurFXML;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cases.*;
import monopoly.vue.dialogue.DialogueVoirDetailsPropriete;

import java.io.IOException;

public class ControleurVoirLesProprietes extends Controleur {

    @FXML private TableView tableauVoirLesProprietes;
    @FXML private TableColumn<Case_Achat, String> colNom;
    @FXML private TableColumn<Case_Achat, String> colProprietaire;
    @FXML private TableColumn<Case_Achat, String> colAmelioration;
    @FXML private TableColumn<Case_Achat, String> colLoyer;


    @FXML
    public void initialize() {
        colNom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNom()));

        colProprietaire.setCellValueFactory(param -> {
            Case caseParam = param.getValue();
            Joueur proprietaire = param.getValue().getProprietaire();
            SimpleStringProperty retour = new SimpleStringProperty("Aucun");

            if (proprietaire != null) {
                retour = new SimpleStringProperty(proprietaire.getNom());
            }

            return retour;
        });

        colAmelioration.setCellValueFactory(param -> {
            Case caseParam = param.getValue();
            SimpleStringProperty retour =  new SimpleStringProperty("Non applicable");

            if(caseParam.getType() == ECase.Terrain) {
                Case_Terrain terrain = (Case_Terrain)caseParam;
                retour = new SimpleStringProperty("$" + terrain.getPrixMaison());
            }

            return retour;
        });

        colLoyer.setCellValueFactory(param -> {
            Case caseParam = param.getValue();
            SimpleStringProperty retour = new SimpleStringProperty("$0");

            if (caseParam instanceof Case_Terrain) {
                retour = new SimpleStringProperty("$" + param.getValue().getLoyer());
            }
            else if (caseParam instanceof Case_Gare || caseParam instanceof Case_Compagnie) {
                if (((Case_Achat) caseParam).getProprietaire() != null) {
                    retour = new SimpleStringProperty("$" + param.getValue().getLoyer());
                }
            }

            return retour;
        });

        // Remplissage du tableau avec l'ensemble des Case_Achat du plateau
        for (Case c : Jeu.getInstance().getPlateau().getListeCases()) {
            if (c instanceof Case_Achat) {
                tableauVoirLesProprietes.getItems().addAll(c);
            }
        }
    }

    @FXML
    public void actionDetailsPropriete(ActionEvent event) throws IOException {
        Case_Achat c = (Case_Achat) tableauVoirLesProprietes.getSelectionModel().getSelectedItem();
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Aucune propriété sélectionnée.").show();
        }
        else {
            new DialogueVoirDetailsPropriete(c);
        }
    }

}
