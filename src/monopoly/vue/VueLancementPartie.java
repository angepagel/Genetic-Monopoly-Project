package monopoly.vue;

import javafx.geometry.Insets;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import javafx.stage.Stage;
import monopoly.controleur.ControleurChoixPion;
import monopoly.modele.Pion;

public class VueLancementPartie {

    @FXML
    private ComboBox<Pion> PionJoueurI;

    @FXML
    private ComboBox<Pion> PionJoueurII;



    private ControleurChoixPion controleur;

    private ObservableList<Pion> listePions;
    private boolean continuer = false;


    public VueLancementPartie() {
        controleur = new ControleurChoixPion();
        PionJoueurI = new ComboBox<Pion>();
        PionJoueurII = new ComboBox<Pion>();
        controleur.InitPion();
        listePions = controleur.getListePions();
        this.start();
       
        


    }

    public void InitComboBoxJoueurs() {
        
        PionJoueurI.setItems(listePions);
        PionJoueurII.setItems(listePions);


    }


    public void start()   {
        Stage stage = new Stage();

        HBox root = new HBox();
        
        root.setSpacing(10);
        root.setPadding(new Insets(15,20, 10,10));
        ListView<Pion> listJOne;
        listJOne = new ListView<>(listePions);
        
        ListView<Pion> listJTwo;
        listJTwo = new ListView<>(listePions);
        Label label = new Label("Veuillez choisir votre pion :");
        root.getChildren().add(label);
        root.getChildren().add(listJOne);
        Label label2 = new Label("Veuillez le pion du joueur 2 :");
        root.getChildren().add(label2);
        root.getChildren().add(listJTwo);
        Button valider= new Button("Valider");
        valider.setPrefSize(100, 50);
        valider.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(listJOne.getSelectionModel().getSelectedItem()!=null && listJTwo.getSelectionModel().getSelectedItem()!=null ){
                        controleur.setPionJoueurs(listJOne.getSelectionModel().getSelectedItem(),listJTwo.getSelectionModel().getSelectedItem());
                        new Partie();
                        stage.close();
                    }
                    
                }catch (IOException ex){
                    Logger.getLogger(VueLancementPartie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        root.getChildren().add(valider);
       
        Scene scene = new Scene(root, 1000, 200);
        stage.setTitle("Choix des pions");
        stage.setScene(scene);
        stage.show();
       /* this.InitComboBoxJoueurs();
        Stage choixPion = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("VueLancementPartie.fxml"));
        choixPion.setTitle("Monopoly Génétique");
        choixPion.getIcons().add(new Image("file:src/monopoly/vue/data/image/Icone.png"));
        choixPion.setScene(new Scene(root, 650, 400));
        choixPion.setResizable(false);
        choixPion.show();*/
       
      
        //root.getChildrenUnmodifiable().addAll(new PanelCase(0.0).getPane());
       

    }

    public void validerLesChoix(){




    }




}
