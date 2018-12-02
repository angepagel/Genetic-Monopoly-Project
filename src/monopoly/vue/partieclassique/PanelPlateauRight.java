package monopoly.vue.partieclassique;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PanelPlateauRight extends HBox {

    public PanelPlateauRight() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(270);
        this.setAlignment(Pos.BOTTOM_RIGHT);
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
    }

}
