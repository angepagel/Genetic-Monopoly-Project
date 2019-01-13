package monopoly.vue.controleurFXML;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import monopoly.modele.Joueur;
import monopoly.modele.cases.Case_Achat;
import monopoly.modele.cases.Case_Terrain;
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
    public void actionDetailsPropriete(ActionEvent event) throws IOException {
        Case_Terrain c = (Case_Terrain) tableauGererMesProprietes.getSelectionModel().getSelectedItem();
        new DialogueVoirDetailsPropriete(c);
    }

    @FXML
    public void initialize() {
        colNom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNom()));
        // TODO : Résoudre le problème de la colAmelioration pour les cases qui ne sont pas des Case_Achat
        colAmelioration.setCellValueFactory(param ->new SimpleStringProperty(String.valueOf(param.getValue().getNom())));
        colLoyer.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getLoyer())));
        colHypotheque.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValeurHypotheque())));
    }

    @FXML
    public void setJoueur(Joueur j) {
        // tableauGererMesProprietes.getItems().addAll(j.getProprietes());
        for (Case_Achat c : j.getProprietes()) {
            // if (c instanceof Case_Terrain) {}
            tableauGererMesProprietes.getItems().addAll(c);
        }
    }

    @FXML
    public void actionConstruire(ActionEvent event) {
        Case_Achat c = (Case_Achat) tableauGererMesProprietes.getSelectionModel().getSelectedItem();
        try {
            if (c instanceof Case_Terrain) {
                Optional<ButtonType> confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Souhaitez-vous vraiment construire sur " + c.getNom() + " ?").showAndWait();
                if (confirmation.get() == ButtonType.OK) {
                    ((Case_Terrain) c).ameliorer();
                    new Alert(Alert.AlertType.INFORMATION, "Terrain amélioré.").show();
                }
            }
            else {
                throw new Exception("Vous ne pouvez pas construire sur ce type de case.");
            }
        }
        catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
    }

    @FXML
    public void actionVendre(ActionEvent event) {
        Case_Achat c = (Case_Achat) tableauGererMesProprietes.getSelectionModel().getSelectedItem();
        try {
            if (c instanceof Case_Terrain) {
                Optional<ButtonType> confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Souhaitez-vous vraiment vendre une construction sur " + c.getNom() + " ?").showAndWait();
                if (confirmation.get() == ButtonType.OK) {
                    ((Case_Terrain) c).vendreAmelioration();
                    new Alert(Alert.AlertType.INFORMATION, "Construction vendue.").show();
                }
            }
            else {
                throw new Exception("Il est impossible de construire sur ce type de case.");
            }
        }
        catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
    }

    @FXML
    public void actionHypothequer(ActionEvent event) {
        Case_Achat c = (Case_Achat) tableauGererMesProprietes.getSelectionModel().getSelectedItem();
        try {
            Optional<ButtonType> confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Souhaitez-vous vraiment hypothéquer " + c.getNom() + " ?").showAndWait();
            if (confirmation.get() == ButtonType.OK) {
                c.setHypotheque(true);
                new Alert(Alert.AlertType.INFORMATION, "Propriété hypothéquée.").show();
            }
        }
        catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
    }

}
