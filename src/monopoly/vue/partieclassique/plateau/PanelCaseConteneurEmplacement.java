package monopoly.vue.partieclassique.plateau;

import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import monopoly.vue.data.image.GestionnaireImage;

import java.util.ArrayList;

/**
 * Created by maxim on 03/12/2018.
 */
public class PanelCaseConteneurEmplacement extends FlowPane {

    private ImageView emplacementJoueur_1;
    private ImageView emplacementJoueur_2;
    private ImageView emplacementJoueur_3;
    private ImageView emplacementJoueur_4;
    private ImageView emplacementJoueur_5;
    private ImageView emplacementJoueur_6;
    private ImageView emplacementJoueur_7;
    private ImageView emplacementJoueur_8;

    private ArrayList<PanelCaseEmplacementJoueur> listeEmplacements;

    public PanelCaseConteneurEmplacement() {
        // TODO : Ajouter des getters et setters dans le futur, ou convertir ces attributs en un tableau

        // Init liste
        this.listeEmplacements = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            this.listeEmplacements.add(new PanelCaseEmplacementJoueur());
            this.getChildren().add(this.listeEmplacements.get(i));
        }

    }



}
