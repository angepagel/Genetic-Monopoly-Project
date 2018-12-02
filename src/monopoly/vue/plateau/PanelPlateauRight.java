package monopoly.vue.plateau;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
