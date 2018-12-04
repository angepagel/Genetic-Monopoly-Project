package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PanelPlateauLeft extends HBox {

    public PanelPlateauLeft() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(90);
        this.setAlignment(Pos.BOTTOM_LEFT);
        this.getChildren().addAll(
                new PanelCaseTerrain("Boulevard de la Villette"),
                new PanelCaseSpeciale("Compagnie de distribution d'électricité", "Electricite", true),
                new PanelCaseTerrain("Avenue de Neuilly"),
                new PanelCaseTerrain("Rue de Paradis"),
                new PanelCaseSpeciale("Gare de Lyon", "Gare", true),
                new PanelCaseTerrain("Avenue Mozart"),
                new PanelCaseSpeciale("Caisse de communauté", "Caisse", false),
                new PanelCaseTerrain("Boulevard Saint-Michel"),
                new PanelCaseTerrain("Place Pigalle"));
    }

}
