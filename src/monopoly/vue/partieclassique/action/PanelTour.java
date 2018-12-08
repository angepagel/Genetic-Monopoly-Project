package monopoly.vue.partieclassique.action;

import javafx.scene.layout.Pane;

public class PanelTour extends Pane {

    private PanelActionRectangle rect;

    public PanelTour() {

        this.setWidth(380);
        this.setHeight(430);

        this.rect = new PanelActionRectangle(20, 20, 300, 430);

        this.getChildren().addAll(
                this.rect
        );

    }

}
