package monopoly.vue.partieclassique.plateau;

import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

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

    public PanelCaseConteneurEmplacement() {
        this.emplacementJoueur_1 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_2 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_3 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_4 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_5 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_6 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_7 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_8 = new PanelCaseEmplacementJoueur();

        this.getChildren().addAll(this.emplacementJoueur_1, this.emplacementJoueur_2,
                this.emplacementJoueur_3, this.emplacementJoueur_4,
                this.emplacementJoueur_5, this.emplacementJoueur_6,
                this.emplacementJoueur_7, this.emplacementJoueur_8);
    }

}
