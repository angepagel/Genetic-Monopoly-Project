package monopoly.vue;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import monopoly.controleur.ControleurChoixPion;
import monopoly.modele.Pion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Vue_LancementPartie {

    @FXML
    private ComboBox<Pion> PionJoueurI;

    @FXML
    private ComboBox<Pion> PionJoueurII;



    private ControleurChoixPion controleur;

    private ObservableList<Pion> listePions;
    private boolean continuer = false;


    public Vue_LancementPartie() {
        controleur = new ControleurChoixPion();
        PionJoueurI = new ComboBox<Pion>();
        PionJoueurII = new ComboBox<Pion>();
        controleur.InitPion();
        listePions = controleur.getListePions();



    }

    public void InitComboBoxJoueurs() {
        PionJoueurI.setItems(listePions);
        PionJoueurII.setItems(listePions);


    }


    public void start() throws Exception {

        this.InitComboBoxJoueurs();
        Stage choixPion = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Vue_LancementPartie.fxml"));
        //root.getChildrenUnmodifiable().addAll(new Panel_Case(0.0).getPane());
        choixPion.setTitle("Monopoly Génétique");
        choixPion.getIcons().add(new Image("file:src/monopoly/vue/data/image/Icone.png"));
        choixPion.setScene(new Scene(root, 650, 400));
        choixPion.setResizable(false);
        choixPion.show();

    }

    public void validerLesChoix(){




    }




}
