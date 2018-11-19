package monopoly.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import monopoly.modele.cases.Case_Achat;

public class ControleurVoirDetailsPropriete extends Controleur{

    @FXML
    private Label labelNom;

    @FXML
    private Label labelProprietaire;

    @FXML
    private Label labelLoyer;

    @FXML
    private Label labelLoyerAmelioration1;

    @FXML
    private Label labelLoyerAmelioration2;

    @FXML
    private Label labelLoyerAmelioration3;

    @FXML
    private Label labelLoyerAmelioration4;

    @FXML
    private Label labelLoyerAmelioration5;

    @FXML
    private Label labelHypotheque;


    public void update(Case_Achat c) {
        labelNom.setText("Boulevard de Belleville");
        labelProprietaire.setText("Joueur1");
        labelLoyer.setText("$60");
        labelLoyerAmelioration1.setText("$100");
        labelLoyerAmelioration2.setText("$140");
        labelLoyerAmelioration3.setText("$180");
        labelLoyerAmelioration4.setText("$220");
        labelLoyerAmelioration5.setText("$260");
        labelHypotheque.setText("$100");

    }

}
