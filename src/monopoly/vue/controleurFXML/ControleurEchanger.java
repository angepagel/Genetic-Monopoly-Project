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

public class ControleurEchanger extends Controleur {

    @FXML private TableView tableauEchanger1;
    @FXML private TableColumn<Case_Achat, String> colNom1;
    @FXML private TableColumn<Case_Achat, String> colAmelioration1;
    @FXML private TableColumn<Case_Achat, String> colLoyer1;
    @FXML private TableColumn<Case_Achat, String> colHypotheque1;

    @FXML private TableView tableauEchanger2;
    @FXML private TableColumn<Case_Achat, String> colNom2;
    @FXML private TableColumn<Case_Achat, String> colProprietaire2;
    @FXML private TableColumn<Case_Achat, String> colAmelioration2;
    @FXML private TableColumn<Case_Achat, String> colLoyer2;


    @FXML
    public void initialize() {
        colNom1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNom()));
        colAmelioration1.setCellValueFactory(param -> {
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
        colLoyer1.setCellValueFactory(param -> new SimpleStringProperty("$" + param.getValue().getLoyer()));
        colHypotheque1.setCellValueFactory(param -> new SimpleStringProperty("$" + param.getValue().getValeurHypotheque()));


        colNom2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNom()));

        colProprietaire2.setCellValueFactory(param -> {
            Case caseParam = param.getValue();
            Joueur proprietaire = param.getValue().getProprietaire();
            SimpleStringProperty retour = new SimpleStringProperty("Aucun");

            if (proprietaire != null) {
                retour = new SimpleStringProperty(proprietaire.getNom());
            }

            return retour;
        });

        colAmelioration2.setCellValueFactory(param -> {
            Case caseParam = param.getValue();
            SimpleStringProperty retour =  new SimpleStringProperty("Non applicable");

            if(caseParam.getType() == ECase.Terrain) {
                Case_Terrain terrain = (Case_Terrain)caseParam;
                retour = new SimpleStringProperty("$" + terrain.getPrixMaison());
            }

            return retour;
        });

        colLoyer2.setCellValueFactory(param -> {
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
                if (((Case_Achat) c).getProprietaire() != null && ((Case_Achat) c).getProprietaire() != Jeu.getInstance().getJoueurEnCours()) {
                    tableauEchanger2.getItems().addAll(c);
                }
            }
        }
    }

    @FXML
    public void setJoueur(Joueur j) {
        tableauEchanger1.getItems().addAll(j.getProprietes());
    }

    @FXML
    private void actionDetailsPropriete1(ActionEvent event) throws IOException {
        Case_Achat c = (Case_Achat) tableauEchanger1.getSelectionModel().getSelectedItem();
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Aucune propriété sélectionnée.").show();
        }
        else {
            new DialogueVoirDetailsPropriete(c);
        }
    }

    @FXML
    private void actionDetailsPropriete2(ActionEvent event) throws IOException {
        Case_Achat c = (Case_Achat) tableauEchanger2.getSelectionModel().getSelectedItem();
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Aucune propriété sélectionnée.").show();
        }
        else {
            new DialogueVoirDetailsPropriete(c);
        }
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
