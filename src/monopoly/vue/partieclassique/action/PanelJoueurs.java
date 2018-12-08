package monopoly.vue.partieclassique.action;

import javafx.scene.layout.Pane;

public class PanelJoueurs extends Pane {

    private PanelActionRectangle rect;

    public PanelJoueurs() {

        this.setWidth(380);
        this.setHeight(170);

        this.rect = new PanelActionRectangle(20, 20, 300, 170);

        this.getChildren().addAll(
                this.rect
        );

    }

}
