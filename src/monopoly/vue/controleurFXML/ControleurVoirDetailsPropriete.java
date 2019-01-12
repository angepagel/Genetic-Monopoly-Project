package monopoly.vue.controleurFXML;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import monopoly.controleur.Controleur;
import monopoly.modele.cases.Case_Terrain;

public class ControleurVoirDetailsPropriete extends Controleur {

    @FXML private Label labelNom;
    @FXML private Label labelProprietaire;
    @FXML private Label labelLoyer;
    @FXML private Label labelLoyerAmelioration1;
    @FXML private Label labelLoyerAmelioration2;
    @FXML private Label labelLoyerAmelioration3;
    @FXML private Label labelLoyerAmelioration4;
    @FXML private Label labelLoyerAmelioration5;
    @FXML private Label labelHypotheque;

    @FXML
    public void setCase(Case_Terrain c) {
        labelNom.setText(c.getNom());
        if (c.getProprietaire() != null) {
            labelProprietaire.setText(c.getProprietaire().getNom());
        }
        labelLoyer.setText("$ " + c.getLoyer());
        labelLoyerAmelioration1.setText("$ " + c.getPrixMaison());
        labelLoyerAmelioration2.setText("$ " + c.getPrixMaison()*2);
        labelLoyerAmelioration3.setText("$ " + c.getPrixMaison()*3);
        labelLoyerAmelioration4.setText("$ " + c.getPrixMaison()*4);
        labelLoyerAmelioration5.setText("$ " + c.getPrixMaison()*5);
        labelHypotheque.setText("$ " + c.getValeurHypotheque());
    }

}
