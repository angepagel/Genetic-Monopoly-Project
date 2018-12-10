package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PanelCaseActuelle extends Pane {

    private PanelActionRectangle rect;
    private PanelActionLabel titre;

    public PanelCaseActuelle() {

        this.rect = new PanelActionRectangle(10, 10, 275, 120);

        this.titre = new PanelActionLabel("Case actuelle", 15);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(90);
        this.titre.setPrefHeight(30);
        this.titre.setPadding(Insets.EMPTY);
        this.titre.setLayoutX(30);
        this.titre.setLayoutY(0);

        this.getChildren().addAll(
                this.rect,
                this.titre
        );

    }

}
