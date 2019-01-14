package monopoly.vue.controleurFXML;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import monopoly.modele.cases.Case_Achat;
import monopoly.modele.cases.Case_Compagnie;
import monopoly.modele.cases.Case_Gare;
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
    public void setCase(Case_Achat c) {
        labelNom.setText(c.getNom());

        if (c.getProprietaire() != null) {
            labelProprietaire.setText(c.getProprietaire().getNom());
        }

        if (c instanceof Case_Terrain || c.getProprietaire() != null) {
            labelLoyer.setText("$" + c.getLoyer());
        }
        else {
            labelLoyer.setText("$0");
        }

        if (c instanceof Case_Terrain) {
            labelLoyerAmelioration1.setText("$" + ((Case_Terrain) c).getPrixMaison());
            labelLoyerAmelioration2.setText("$" + ((Case_Terrain) c).getPrixMaison()*2);
            labelLoyerAmelioration3.setText("$" + ((Case_Terrain) c).getPrixMaison()*3);
            labelLoyerAmelioration4.setText("$" + ((Case_Terrain) c).getPrixMaison()*4);
            labelLoyerAmelioration5.setText("$" + ((Case_Terrain) c).getPrixMaison()*5);
        }

        labelHypotheque.setText("$" + c.getValeurHypotheque());
    }

}
