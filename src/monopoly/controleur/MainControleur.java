package monopoly.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import monopoly.modele.Des;
import monopoly.vue.dialogue.DialogueEchanger;
import monopoly.vue.dialogue.DialogueGererMesProprietes;
import monopoly.vue.dialogue.DialogueVoirLesProprietes;
import monopoly.vue.dialogue.DialogueVoirMesProprietes;

import java.io.IOException;

public class MainControleur {

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

}
