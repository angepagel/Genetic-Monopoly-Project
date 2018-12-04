package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PanelPlateauTop extends HBox {

    public PanelPlateauTop() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(180);
        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(
            new PanelCaseDepart(),
            new PanelCaseTerrain("Avenue Matignon"),
            new PanelCaseSpeciale("Chance", "InterrogationBleue", false),
            new PanelCaseTerrain("Boulevard Malesherbes"),
            new PanelCaseTerrain("Avenue Henri-Martin"),
            new PanelCaseSpeciale("Gare du Nord", "Gare", true),
            new PanelCaseTerrain("Faubourg Saint-Honoré"),
            new PanelCaseTerrain("Place de la Bourse"),
            new PanelCaseSpeciale("Compagnie de distribution des eaux", "DistributionEaux", true),
            new PanelCaseTerrain("Rue la Fayette"),
            new PanelCaseDepart()
        );
    }

}
