package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Created by maxim on 23/11/2018.
 */
public class PanelCase extends FlowPane {

    private Rectangle header;
    private Label nom;
    private ImageView emplacementJoueur_1;
    private ImageView emplacementJoueur_2;
    private ImageView emplacementJoueur_3;
    private ImageView emplacementJoueur_4;
    private ImageView emplacementJoueur_5;
    private ImageView emplacementJoueur_6;
    private ImageView emplacementJoueur_7;
    private ImageView emplacementJoueur_8;
    private Label prix;

    public PanelCase() {

        // Panel properties
        this.setWidth(58);
        this.setHeight(90);
        this.setMinWidth(58);
        this.setMinHeight(90);
        this.setMaxWidth(58);
        this.setMaxHeight(90);
        this.setStyle("-fx-background-color: #DAE9D4");

        this.setRotate(0);
        this.setBorder(
                new Border(new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        BorderWidths.DEFAULT))
        );

        // Component properties
        this.header = new Rectangle(0,0,56,17);
        this.nom = new PanelCaseLabel("PROPRIETE");
        this.emplacementJoueur_1 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_2 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_3 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_4 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_5 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_6 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_7 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_8 = new PanelCaseEmplacementJoueur();
        this.prix = new PanelCaseLabel("$PRIX");

        this.getChildren().addAll(header, nom, emplacementJoueur_1, emplacementJoueur_2,
                emplacementJoueur_3, emplacementJoueur_4, emplacementJoueur_5,
                emplacementJoueur_6, emplacementJoueur_7, emplacementJoueur_8,
                prix);

        // Header parameters

        this.header.setFill(Color.web("#944828"));



    }

}
