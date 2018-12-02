package monopoly.vue.plateau;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PanelPlateauBottom extends HBox {

    public PanelPlateauBottom() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(0);
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
