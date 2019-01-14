package monopoly.vue.controleurFXML;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import monopoly.modele.Joueur;
import monopoly.modele.cases.Case;
import monopoly.modele.cases.Case_Achat;
import monopoly.modele.cases.Case_Terrain;
import monopoly.modele.cases.ECase;
import monopoly.vue.dialogue.DialogueVoirDetailsPropriete;

import java.io.IOException;
import java.util.Optional;

public class ControleurGererMesProprietes extends Controleur {

    @FXML private TableView tableauGererMesProprietes;
    @FXML private TableColumn<Case_Achat, String> colNom;
    @FXML private TableColumn<Case_Achat, String> colAmelioration;
    @FXML private TableColumn<Case_Achat, String> colLoyer;
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
        tableauGererMesProprietes.getItems().addAll(j.getProprietes());
    }

    @FXML
    public void actionDetailsPropriete(ActionEvent event) throws IOException {
        Case_Achat c = (Case_Achat) tableauGererMesProprietes.getSelectionModel().getSelectedItem();
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Aucune propriété sélectionnée.").show();
        }
        else {
            new DialogueVoirDetailsPropriete(c);
        }
    }

    @FXML
    public void actionConstruire(ActionEvent event) {
        Case_Achat c = (Case_Achat) tableauGererMesProprietes.getSelectionModel().getSelectedItem();
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Aucun terrain sélectionné.").show();
        }
        else {
            try {
                if (c instanceof Case_Terrain) {
                    Optional<ButtonType> confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Souhaitez-vous vraiment construire sur " + c.getNom() + " ?").showAndWait();
                    if (confirmation.get() == ButtonType.OK) {
                        ((Case_Terrain) c).ameliorer();
                        new Alert(Alert.AlertType.INFORMATION, "Terrain amélioré.").show();
                    }
                } else {
                    throw new Exception("Vous ne pouvez pas construire sur ce type de case.");
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            }
        }
    }

    @FXML
    public void actionVendre(ActionEvent event) {
        Case_Achat c = (Case_Achat) tableauGererMesProprietes.getSelectionModel().getSelectedItem();
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Aucun terrain sélectionné.").show();
        }
        else {
            try {
                if (c instanceof Case_Terrain) {
                    Optional<ButtonType> confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Souhaitez-vous vraiment vendre une construction sur " + c.getNom() + " ?").showAndWait();
                    if (confirmation.get() == ButtonType.OK) {
                        ((Case_Terrain) c).vendreAmelioration();
                        new Alert(Alert.AlertType.INFORMATION, "Construction vendue.").show();
                    }
                } else {
                    throw new Exception("Il est impossible de construire sur ce type de case.");
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            }
        }
    }

    @FXML
    public void actionHypothequer(ActionEvent event) {
        Case_Achat c = (Case_Achat) tableauGererMesProprietes.getSelectionModel().getSelectedItem();
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Aucune propriété sélectionnée.").show();
        }
        else {
            try {
                Optional<ButtonType> confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Souhaitez-vous vraiment hypothéquer " + c.getNom() + " ?").showAndWait();
                if (confirmation.get() == ButtonType.OK) {
                    c.setHypotheque(true);
                    new Alert(Alert.AlertType.INFORMATION, "Propriété hypothéquée.").show();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            }
        }
    }

}
