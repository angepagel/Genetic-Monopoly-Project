package monopoly.vue.partieclassique.plateau;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PanelCase extends FlowPane {

    public PanelCase() {

        // Panel properties
        this.setWidth(58);
        this.setHeight(90);
        this.setMinWidth(58);
        this.setMinHeight(90);
        this.setMaxWidth(58);
        this.setMaxHeight(90);
        this.setStyle("-fx-background-color: #DAE9D4");

        this.setRotate(0);
        this.setBorder(
                new Border(new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        BorderWidths.DEFAULT))
        );

    }

}
