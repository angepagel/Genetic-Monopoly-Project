package monopoly.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import monopoly.modele.Des;
import monopoly.modele.Jeu;
import monopoly.modele.cases.Case_Achat;
import monopoly.vue.Vue_De;
import monopoly.vue.dialogue.*;

import java.io.IOException;
import javax.swing.JOptionPane;
import static monopoly.modele.Jeu.getInstance;

public class ControleurMain {

    // Attributs

    @FXML
    private ImageView de_1;

    @FXML
    private ImageView de_2;


    private Jeu jeu;
    private Controleur_ChangementTour controleur_Tour ;
    public void InitJeu(){
        jeu= getInstance();
        controleur_Tour=  new Controleur_ChangementTour(jeu);
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
        // TODO : Lancer les dés
        Des LesDes = new Des();
        int sommes = LesDes.lancer();
        int de1 = LesDes.valDe1();
        int de2 = LesDes.valDe2();

        Vue_De vueDe = new Vue_De(LesDes, 1, this.de_1);
        vueDe.miseAJour();

        Vue_De vueDe2 = new Vue_De(LesDes, 2, this.de_2);
        vueDe2.miseAJour();
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
    public void actionVoirProprieteBoulevardBelleville() throws IOException {
        Jeu.getInstance().initialisation();
        System.out.println((Case_Achat) Jeu.getInstance().getPlateau().getCase("Boulevard de Belleville"));

        new DialogueVoirDetailsPropriete(1);
    }

    @FXML
    public void actionVoirProprieteBoulevardVillette() throws IOException {
        System.out.println((Case_Achat) Jeu.getInstance().getPlateau().getCase("Boulevard de Belleville"));

        new DialogueVoirDetailsPropriete(2);
    }

}
