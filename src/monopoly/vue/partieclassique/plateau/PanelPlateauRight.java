package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PanelPlateauRight extends PanelPlateauElement {

    public PanelPlateauRight() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(270);
        this.setAlignment(Pos.BOTTOM_RIGHT);
        this.getChildren().addAll(
                new PanelCaseTerrain("Rue de la paix"),
                new PanelCaseSpeciale("Taxe de luxe", "Luxe", true),
                new PanelCaseTerrain("Avenue des Champs-Élysées"),
                new PanelCaseSpeciale("Chance0", "InterrogationOrange", false),
                new PanelCaseSpeciale("Gare Saint-Lazare", "Gare", true),
                new PanelCaseTerrain("Boulevard des Capucines"),
                new PanelCaseSpeciale("Caisse de communauté1", "Caisse", false),
                new PanelCaseTerrain("Avenue Foch"),
                new PanelCaseTerrain("Avenue de Breteuil")
        );
    }

}
