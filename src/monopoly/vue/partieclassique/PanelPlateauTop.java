package monopoly.vue.partieclassique;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PanelPlateauTop extends HBox {

    public PanelPlateauTop() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(180);
        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().add(new PanelCaseDepart());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCase());
        this.getChildren().add(new PanelCaseDepart());
    }

}