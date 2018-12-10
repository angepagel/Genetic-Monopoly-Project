package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import monopoly.modele.Jeu;
import monopoly.modele.cases.Case;

public abstract class PanelCase extends FlowPane {

    private Case modele;

    public PanelCase(String id) {

        this.modele = Jeu.getInstance().getPlateau().getCase(id);

        // Panel properties
        this.setWidth(58);
        this.setHeight(90);
        this.setMinWidth(58);
        this.setMinHeight(90);
        this.setMaxWidth(58);
        this.setMaxHeight(90);
        //this.setStyle("-fx-background-color: #DAE9D4");
        this.setBackground(new Background(new BackgroundFill(Color.web("DAE9D4"), CornerRadii.EMPTY, Insets.EMPTY)));

        this.setRotate(0);
        this.setBorder(
                new Border(new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        BorderWidths.DEFAULT))
        );

    }

    public Case getModele() {
        return modele;
    }

    public abstract PanelCaseConteneurEmplacement getConteneurEmplacements();

    public void vider() {

    }
}
