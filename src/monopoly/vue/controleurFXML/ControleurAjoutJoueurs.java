package monopoly.vue.controleurFXML;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import monopoly.modele.Humain;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.Pion;
import monopoly.vue.Menu;
import monopoly.vue.partieclassique.Partie;
import java.io.IOException;

public class ControleurAjoutJoueurs extends Controleur {

    @FXML private TextField textFieldNom;
    @FXML private ComboBox comboPions;
    @FXML private ComboBox comboType;
    @FXML private Button boutonAjouter;
    @FXML private TableView<Joueur> tableauJoueurs;
    @FXML private TableColumn<Joueur, String> colNom;
    @FXML private TableColumn<Joueur, String> colPion;
    @FXML private TableColumn<Joueur,String> colType;
    @FXML private Button boutonRetirer;
    @FXML private Button boutonAnnuler;
    @FXML private Button boutonLancerPartie;
    private ObservableList<String> listePions;
    private ObservableList<String> listeType;

    /*
    Il est important de tenir compte des informations suivantes pour coder ce contrôleur:
        - On ne peut pas avoir plus de 8 joueurs dans la partie;
        - Une partie doit comporter au moins 2 joueurs;
        - Pour ajouter un joueur, le textFieldNom ne doit pas être vide;
        - Éventuellement, deux joueurs ne peuvent pas avoir le même nom ?
        - Éventuellement, les couleurs disponibles dans le comboPion sont gérées dynamiquement, compte tenu des
          couleurs déjà prises ?
     */

    // JOptionPane.showMessageDialog(null,"msg");


    @FXML
    public void initialize() {
//        tableauJoueurs = new TableView<>();
//        colNom = new TableColumn<>("Nom");
//        colPion = new TableColumn<>("Pion");
        colNom.setCellValueFactory(param -> param.getValue().getNomProperty());
        colPion.setCellValueFactory(param -> param.getValue().getPion().getNomProperty());
        colType.setCellValueFactory(param-> param.getValue().getTypeProperty());
        listePions = FXCollections.observableArrayList("Rouge", "Bleu", "Vert", "Jaune", "Rose", "Violet", "Cyan", "Orange");
        listeType = FXCollections.observableArrayList("Humain","IA");

        for (String couleur : listePions) {
            comboPions.getItems().add(couleur);
        }
        for(String type: listeType){
            comboType.getItems().add(type);
        }

        comboPions.getSelectionModel().selectFirst();
        comboType.getSelectionModel().selectFirst();
    }

    @FXML
    public void ajouterJoueur() {
        String nom = textFieldNom.getText().trim();
        int maxSize = 20;

        if(nom.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ajout impossible");
            alert.setContentText("Vous devez donner un nom à votre joueur..");
            alert.show();
            return;
        }

        else if (nom.length() > maxSize)
        {
            new Alert(Alert.AlertType.WARNING, "Le nom du joueur ne peut pas contenir plus de " + maxSize + " caractères.").show();
            return;
        }

        for(Joueur jTest : tableauJoueurs.getItems()) {
            if(jTest.getNom().equals(nom)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ajout impossible");
                alert.setContentText("Vous ne pouvez pas ajouter un joueur portant le nom \"" + textFieldNom.getText() + "\" car il existe déjà un joueur portant ce nom.");
                alert.show();
                return;
            }
        }
        if(comboType.getSelectionModel().getSelectedItem()!= null ){
            if(comboType.getSelectionModel().getSelectedItem() == "Humain" ){
                Joueur j = new Humain(nom);
                j.choisirPion(new Pion(comboPions.getValue().toString(), true));
                tableauJoueurs.getItems().addAll(j);
                comboPions.getItems().remove(comboPions.getValue());
                comboPions.getSelectionModel().selectFirst();

                if(comboPions.getItems().size() == 0) {
                    boutonAjouter.setDisable(true);
                }

                textFieldNom.setText("");
            }

            if(comboType.getSelectionModel().getSelectedItem()== "IA"){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ajout impossible");
                alert.setContentText("Ce type de joueur n'est pas encore disponible.");
                alert.show();
                return;
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ajout impossible");
            alert.setContentText("Vous devez obligatoirement choisir un type pour le joueur.");
            alert.show();
            return;
        }



    }

    @FXML
    public void retirerJoueur() {
        try {
            int focusedIndex = tableauJoueurs.getSelectionModel().getFocusedIndex();
            Joueur j = tableauJoueurs.getItems().get(focusedIndex);
            tableauJoueurs.getItems().remove(j);
            comboPions.getItems().addAll(j.getPion().getNom());
            boutonAjouter.setDisable(false);
            comboPions.getSelectionModel().selectFirst();
        }
        catch (Exception e)
        {
            new Alert(Alert.AlertType.WARNING, "Il n'y a aucun joueur à retirer.").show();
        }

    }

    @FXML
    public void lancerPartie() throws IOException {
        if(tableauJoueurs.getItems().size() < 2) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Impossible de lancer la partie.");
            alert.setContentText("Une partie nécessite 2 joueurs au minimum pour démarrer.");
            alert.show();
            return;
        }
        Jeu.getInstance().getJoueurs().addAll(tableauJoueurs.getItems());
        new Partie();
        ((Stage)boutonLancerPartie.getScene().getWindow()).close();
    }


    public void annuler() throws IOException {
        ((Stage)boutonAnnuler.getScene().getWindow()).close();
        new Menu("Monopoly Génétique","menu.fxml");
    }

}
