package monopoly.vue.partieclassique.action;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PanelActionRectangle extends Rectangle {

    public PanelActionRectangle(double x, double y, double width, double height) {
        super(x,y,width,height);

        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.BLACK);
        this.setStrokeWidth(1);
        this.setArcHeight(5);
        this.setArcWidth(5);
    }


}
