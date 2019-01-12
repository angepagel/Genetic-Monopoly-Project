/*

=====================
------ OBSOLETE -----
=====================

 */



package monopoly.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import monopoly.modele.Jeu;
import monopoly.vue.dialogue.*;

import javax.swing.*;
import java.io.IOException;

import static monopoly.modele.Jeu.getInstance;

public class ControleurPartieFXML {

    // Attributs

    @FXML
    private ImageView de_1;

    @FXML
    private ImageView de_2;


    private Jeu jeu;
    private ControleurChangementTour controleur_Tour ;
    private ControleurBoutonDe controleur_de;


    public void InitJeu(){
        jeu= getInstance();
        controleur_Tour=  new ControleurChangementTour(jeu);
    }


    // Methodes

    @FXML
    public void actionVoirMesProprietes(ActionEvent event) throws IOException {
        new DialogueVoirMesProprietes();
    }

    @FXML
    public void actionVoirLesProprietes(ActionEvent action) throws IOException {
        new DialogueVoirLesProprietes();
    }

    @FXML
    public void actionLancerDes(ActionEvent action) {
        //this.controleur_de = new ControleurBoutonDe(de_1, de_2);
        //this.controleur_de.lancerDes(action);
    }

    @FXML
    public void actionGererMesProprietes(ActionEvent action) throws IOException {
        new DialogueGererMesProprietes();
    }

    @FXML
    public void actionEchanger(ActionEvent action) throws IOException {
        new DialogueEchanger();
    }

    @FXML
    public void actionAcheter(ActionEvent action) {
        // TODO : Gérer l'achat
    }

    @FXML
    public void actionEncherir(ActionEvent action) {
        // TODO : Gérer l'enchère
    }

    @FXML
    public void actionTerminerTour(ActionEvent action) {
        JOptionPane.showMessageDialog(null,"Le joueur  a terminé son tour \n C'est au tour du joueur de jouer !");
    }

    @FXML
    public void actionVoirPropriété(String nomCase) throws IOException {
        new DialogueVoirDetailsPropriete();
        // TODO : Passer une propriété en paramètre
    }

}
