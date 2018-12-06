package monopoly.vue;


import javafx.geometry.Insets;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import monopoly.controleur.ControleurChoixPion;
import monopoly.modele.Pion;
import monopoly.vue.partieclassique.Partie;

public class VueLancementPartie {

    

    private ControleurChoixPion controleur;

    private ObservableList<Pion> listePions;
    
    private static VueLancementPartie menuChoix;
    
    private Stage parent;
    
    ObservableList<String> nbJoueurs;
    
    ComboBox comboBox;
    
    private VueLancementPartie() {
        
            
    }
    
    public void initWindow(){
        controleur = new ControleurChoixPion();
        controleur.InitPion();
        listePions = controleur.getListePions();
        nbJoueurs= FXCollections.observableArrayList(
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8"
        );
        comboBox = new ComboBox(nbJoueurs);
    
        this.start();
        
    }
    
   public static VueLancementPartie getInstance(){
        if(menuChoix==null){
            menuChoix= new VueLancementPartie();
        }
        return menuChoix;
    }
   
   public void setParent(Stage parent){
       this.parent = parent;
   }
    
  
    public void start()   {
        Stage stage = new Stage();
        HBox root = new HBox();
        root.setSpacing(10);
        root.setPadding(new Insets(15,20, 10,10));
        
        ListView<Pion> listJOne = new ListView<>(listePions);
        listJOne.setPrefSize(100, 100);
        ListView<Pion> listJTwo = new ListView<>(listePions);
        listJTwo.setPrefSize(100, 100);
        ListView<Pion> listTree = new ListView<>(listePions);
        listTree.setPrefSize(100, 100);
        ListView<Pion> listFour = new ListView<>(listePions);
        listFour.setPrefSize(100, 100);
        ListView<Pion> listFive = new ListView<>(listePions);
        listFive.setPrefSize(100, 100);
        ListView<Pion> listSix = new ListView<>(listePions);
        listSix.setPrefSize(100, 100);
        ListView<Pion> listSeven = new ListView<>(listePions);
        listSeven.setPrefSize(100, 100);
        ListView<Pion> listHeight = new ListView<>(listePions);
        listHeight.setPrefSize(100, 100);
        Label label = new Label("Pion joueur 1(obligatoire):");
        Label label2 = new Label("Pion joueur 2(obligatoire):");
        Label label3 = new Label("Pion joueur 3:");
        Label label4 = new Label("Pion joueur 4:");
        Label label5 = new Label("Pion joueur 5:");
        Label label6 = new Label("Pion joueur 6:");
        Label label7 = new Label("Pion joueur 7:");
        Label label8 = new Label("Pion joueur 8:");
        Button ok = new Button("ok");
        ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(comboBox.getSelectionModel().getSelectedItem()=="3"){
                    Label label3 = new Label("Pion du joueur 3 :");
                    root.getChildren().add(label3);
                    root.getChildren().add(listTree);
                    
                }
                if(comboBox.getSelectionModel().getSelectedItem()=="4"){
                    
                    root.getChildren().add(label4);
                    root.getChildren().add(listFour);
                    
                }
                if(comboBox.getSelectionModel().getSelectedItem()=="5"){
                    
                    root.getChildren().add(label5);
                    root.getChildren().add(listFive);
                    
                }
                if(comboBox.getSelectionModel().getSelectedItem()=="6"){
                    
                    root.getChildren().add(label6);
                    root.getChildren().add(listSix);
                    
                }
                if(comboBox.getSelectionModel().getSelectedItem()=="7"){
                    
                    root.getChildren().add(label7);
                    root.getChildren().add(listSeven);
                    
                }
                if(comboBox.getSelectionModel().getSelectedItem()=="8"){
                   
                    root.getChildren().add(label8);
                    root.getChildren().add(listHeight);
                    
                }
            }
        
        
        });
        root.getChildren().add(comboBox);
        root.getChildren().add(ok);
        root.getChildren().add(label);
        root.getChildren().add(listJOne);
        
        root.getChildren().add(label2);
        root.getChildren().add(listJTwo);
        //root.getChildren().add(listTree);
        
        Button valider= new Button("Valider");
        valider.setPrefSize(75, 50);
        valider.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    
                    JOptionPane erreur = new JOptionPane();
                    if(listJOne.getSelectionModel().getSelectedItem()!=null && listJTwo.getSelectionModel().getSelectedItem()!=null ){
                        
                            
                        if (listJOne.getSelectionModel().getSelectedItem()== listJTwo.getSelectionModel().getSelectedItem()){
                            stage.setAlwaysOnTop(false);
                            erreur.showMessageDialog( null, "Le joueur 1 et le joueur 2 ne peuvent pas avoir le même pion.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            stage.setAlwaysOnTop(true);
                        }else{
                            
                        controleur.setPionJoueurs(listJOne.getSelectionModel().getSelectedItem(),listJTwo.getSelectionModel().getSelectedItem());
                        new Partie();
                        stage.close();
                        
                        
                        }
                    }else{
                        stage.setAlwaysOnTop(false);
                        erreur.showMessageDialog( null, "Veuillez choisir un pion pour les 2 premiers joueurs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        stage.setAlwaysOnTop(true);
                        
                    }
                    
                }catch (IOException ex){
                    Logger.getLogger(VueLancementPartie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        root.getChildren().add(valider);
        stage.setAlwaysOnTop(true);
        Scene scene = new Scene(root, 1920, 200);
        stage.setTitle("Choix des pions");
        stage.setScene(scene);
        parent.close();
        stage.show();
            

    }
    
    

}
