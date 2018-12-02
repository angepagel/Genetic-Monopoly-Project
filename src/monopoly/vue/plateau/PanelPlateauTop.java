package monopoly.vue.plateau;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
