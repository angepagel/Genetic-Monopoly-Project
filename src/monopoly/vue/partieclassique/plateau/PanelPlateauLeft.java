package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PanelPlateauLeft extends PanelPlateauElement {

    public PanelPlateauLeft() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(90);
        this.setAlignment(Pos.BOTTOM_LEFT);
        this.getChildren().addAll(
                new PanelCaseTerrain("Place Pigalle"),
                new PanelCaseTerrain("Boulevard Saint-Michel"),
                new PanelCaseSpeciale("Caisse de communauté3", "Caisse", false),
                new PanelCaseTerrain("Avenue Mozart"),
                new PanelCaseSpeciale("Gare de Lyon", "Gare", true),
                new PanelCaseTerrain("Rue de Paradis"),
                new PanelCaseTerrain("Avenue de Neuilly"),
                new PanelCaseSpeciale("Compagnie de distribution d'électricité", "Electricite", true),
                new PanelCaseTerrain("Boulevard de la Villette")
        );

    }

}
