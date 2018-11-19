package monopoly.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monopoly.modele.Des;
import monopoly.modele.Jeu;
import monopoly.modele.cases.Case;
import monopoly.modele.cases.Case_Achat;
import monopoly.vue.VueDe;
import monopoly.vue.dialogue.*;

import java.io.IOException;

public class ControleurMain {

    // Attributs

    @FXML
    private ImageView de_1;

    @FXML
    private ImageView de_2;








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

        VueDe vueDe = new VueDe(LesDes, 1, this.de_1);
        vueDe.miseAJour();

        VueDe vueDe2 = new VueDe(LesDes, 2, this.de_2);
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
        // TODO : Terminer le tour
    }

    @FXML
    public void actionVoirProprieteBoulevardBelleville() throws IOException {
        Jeu.getInstance().initialisation();
        System.out.println((Case_Achat) Jeu.getInstance().getPlateau().getCase("Boulevard de Belleville"));

        new DialogueVoirDetailsPropriete((Case_Achat) Jeu.getInstance().getPlateau().getCase("Boulevard de Belleville"));
    }

}
