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
    private PanelCaseConteneurEmplacement emplacements;
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
        this.emplacements = new PanelCaseConteneurEmplacement();
        this.prix = new PanelCaseLabel("$PRIX");

        this.getChildren().addAll(header, nom, emplacements, prix);

        // Header parameters

        this.header.setFill(Color.web("#944828"));



    }

}
