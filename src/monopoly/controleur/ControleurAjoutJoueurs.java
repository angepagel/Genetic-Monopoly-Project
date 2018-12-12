package monopoly.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import monopoly.vue.partieclassique.Partie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import monopoly.modele.Pion;
import java.lang.String;
import java.util.ArrayList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import monopoly.modele.Humain;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.JoueurTemp;
import monopoly.vue.AjoutJoueurs;
public class ControleurAjoutJoueurs implements Initializable {

    @FXML private TextField textFieldNom;
    @FXML private ComboBox<String> comboPions;
    @FXML private Button boutonAjouter;
    @FXML private TableView tableauJoueurs;
    @FXML private TableColumn colNom;
    @FXML private TableColumn colPion;
    @FXML private Button boutonRetirer;
    @FXML private Button boutonLancerPartie;
          private ObservableList<String> listePions;
          private ObservableList<JoueurTemp> listeJoueursTemp = FXCollections.observableArrayList();
          private AjoutJoueurs vueAjoutJoueurs;
    /*    
    Il est important de tenir compte des informations suivantes pour coder ce contrôleur:
        - On ne peut pas avoir plus de 8 joueurs dans la partie;
        - Une partie doit comporter au moins 2 joueurs;
        - Pour ajouter un joueur, le textFieldNom ne doit pas être vide;
        - Éventuellement, deux joueurs ne peuvent pas avoir le même nom ?
        - Éventuellement, les couleurs disponibles dans le comboPion sont gérées dynamiquement, compte tenu des
          couleurs déjà prises ?
     */
          
    public ControleurAjoutJoueurs(){
       listePions = FXCollections.observableArrayList("rouge","vert","bleu","marron","jaune");
       
    }      

    @FXML
    public void ajouterJoueur() {
        if(listeJoueursTemp.size()<8){
            if(comboPions.getSelectionModel().getSelectedItem()!=null && !textFieldNom.getText().equals("") ){
                JoueurTemp j = new JoueurTemp(comboPions.getSelectionModel().getSelectedItem(),textFieldNom.getText());
                listeJoueursTemp.add(j);
                tableauJoueurs.getItems().add(j);
            
            }else{
                JOptionPane.showMessageDialog(null,"Vous devez choisir un pion et donner un nom au joueur que vous voulez rentrer");
            }
        
        
       }  
        // TODO : Ajouter un joueur dans le tableauJoueurs avec les informations du textFieldNom et du comboPions
    }

    @FXML
    public void retirerJoueur() {
        if(tableauJoueurs.getSelectionModel().getSelectedItem()!=null){
           tableauJoueurs.getItems().remove(tableauJoueurs.getSelectionModel().getSelectedItem());
           listeJoueursTemp.remove(tableauJoueurs.getSelectionModel().getSelectedItem());
           
        }
        // TODO : Retirer un joueur du tableauJoueurs
    }

    @FXML
    public void lancerPartie() throws IOException {
        if(listeJoueursTemp.size()>=2){
            new Partie();
            
            Jeu jeu= Jeu.getInstance();
            for(JoueurTemp joueurT:listeJoueursTemp){
                Joueur j = new Humain(joueurT.getNomJoueur());
                Pion p = new Pion(joueurT.getPion());
                jeu.setJoueur(j, p); 
            }
        }else{
            JOptionPane.showMessageDialog(null,"Vous devez rentrer au moins 2 joueurs pour lancer la partie");
        }
        // TODO : Créer les joueurs de la partie à partir du tableauJoueurs (colNom & colPion)
        
    }
    
    public void initialisationComboPions(){
        comboPions.setItems(listePions);
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       initialisationComboPions();
       colNom.setCellValueFactory(new PropertyValueFactory<>("nomJoueur"));
       colPion.setCellValueFactory(new PropertyValueFactory<>("pion"));
       tableauJoueurs.getItems().addAll(listeJoueursTemp);
       
    }

}
