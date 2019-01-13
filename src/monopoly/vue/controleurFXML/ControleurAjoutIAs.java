package monopoly.vue.controleurFXML;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import monopoly.vue.Menu;

import java.io.IOException;

public class ControleurAjoutIAs extends Controleur {

    @FXML private TextField textFieldNom;

    @FXML private Button boutonAjouter;

    @FXML private Button boutonRetirer;

    @FXML private Button boutonLancerPartie;

    @FXML private ListView listeIAs;

    @FXML private TextField textFieldNbTour;

    @FXML private TextField textFieldNbPartie;

    @FXML private Button boutonAnnuler;

    @FXML
    public void ajouterIAs() {
        String nom = textFieldNom.getText().trim();
        int maxSize = 20;
        if (nom.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ajout impossible");
            alert.setContentText("Vous devez donner un nom à votre IA..");
            alert.show();
            return;
        }
        else if (nom.length() > maxSize)
        {
            new Alert(Alert.AlertType.WARNING, "Le nom de l'IA ne peut pas contenir plus de " + maxSize + " caractères.").show();
            return;
        }
        for(Object n:listeIAs.getItems()){
            if(n.equals(nom)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ajout impossible");
                alert.setContentText("Vous ne pouvez pas ajouter une IA portant le nom \"" + textFieldNom.getText() + "\" car il existe déjà une IA portant ce nom.");
                alert.show();
                return;
            }

        }
        if(listeIAs.getItems().size()<8){
            listeIAs.getItems().add(nom);
            textFieldNom.clear();
        }else{
            new Alert(Alert.AlertType.WARNING, "Le nombre maximum de joueurs est de 8.").show();
            return;
        }

        //Joueur j = new IA(nom);

    }

    public void lancerPartie(){

    }

    public void supprimerIAs(){
        listeIAs.getItems().remove(listeIAs.getSelectionModel().getSelectedItem());
    }

    public void annuler() throws IOException {
        ((Stage)boutonAnnuler.getScene().getWindow()).close();
        new Menu("Monopoly Génétique","menu.fxml");
    }


}
