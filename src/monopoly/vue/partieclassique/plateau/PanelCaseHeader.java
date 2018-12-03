package monopoly.vue.partieclassique.plateau;

import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class PanelCaseHeader extends FlowPane {

    private Rectangle rectangle;
    private Line line;

    public PanelCaseHeader(Color couleur) {

        this.rectangle = new Rectangle(0,0,56,17);
        this.rectangle.setFill(couleur);

        // TODO : La ligne s'affiche, mais seulement derrière le plateau ? Régler ce soucis
        this.line = new Line(0,18,56,18);
        this.line.setStroke(Color.BLACK);
        this.line.setStrokeWidth(2);
        this.line.toFront();
        // Ajouter la ligne, plus tard
        this.getChildren().addAll(this.rectangle);

    }

}
