package monopoly.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monopoly.modele.Des;

public class MainControleur {

    @FXML
    private ImageView de_1;

    @FXML
    private ImageView de_2;

    @FXML
    public void actionVoirMesProprietes(ActionEvent event) {
        // TODO : Afficher le dialogueVoirMesProprietes
    }

    @FXML
    public void actionVoirLesProprietes(ActionEvent action) {
        // TODO : Afficher le dialogueVoirLesProprietes
    }

    @FXML
    public void actionLancerDes(ActionEvent action) {
        // TODO : Lancer les dés
        Des LesDes = new Des();
        int sommes = LesDes.lancer();
        int de1 = LesDes.valDe1();
        int de2 = LesDes.valDe2();

        Image spr_de1 = new Image("file:src/monopoly/vue/sprites/dice_1.png", true);
        this.de_1.setImage(spr_de1);
    }

    @FXML
    public void actionGererMesProprietes(ActionEvent action) {
        // TODO : Afficher le dialogueGererMesProprietes
    }

    @FXML
    public void actionEchanger(ActionEvent action) {
        // TODO : Afficher le dialogueEchanger
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
