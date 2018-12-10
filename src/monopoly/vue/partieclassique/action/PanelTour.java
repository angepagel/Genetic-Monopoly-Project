package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PanelTour extends Pane {

    private PanelActionRectangle rect;
    private PanelActionLabel titre;
    private PanelTourInterne panelTourInterne;


    public PanelTour() {

        this.setWidth(380);
        this.setHeight(430);

        this.rect = new PanelActionRectangle(20, 15, 330, 380);

        this.titre = new PanelActionLabel("Tour", 20);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(44);
        this.titre.setPrefHeight(30);
        this.titre.setPadding(Insets.EMPTY);
        this.titre.setLayoutX(30);
        this.titre.setLayoutY(0);

        panelTourInterne = new PanelTourInterne();
        this.panelTourInterne.setLayoutX(30);
        this.panelTourInterne.setLayoutY(30);

        this.getChildren().addAll(
                this.rect,
                this.titre,
                panelTourInterne
        );

    }

}
