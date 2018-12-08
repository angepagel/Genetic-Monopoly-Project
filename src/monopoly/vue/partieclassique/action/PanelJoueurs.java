package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PanelJoueurs extends Pane {

    private PanelActionRectangle rect;
    private PanelActionLabel titre;

    public PanelJoueurs() {

        this.setWidth(380);
        this.setHeight(170);
        this.setMaxHeight(170);
        this.setMinHeight(170);
        this.setMinWidth(380);
        this.setMaxWidth(380);

        this.rect = new PanelActionRectangle(20, 15, 330, 140);

        this.titre = new PanelActionLabel("Joueurs", 20);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(74);
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
