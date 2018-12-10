package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class PanelPlateauTop extends PanelPlateauElement {

    public PanelPlateauTop() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(180);
        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(
            new PanelCaseCarree("Allez en prison !","CaseAllezEnPrison"),
            new PanelCaseTerrain("Rue la Fayette"),
            new PanelCaseSpeciale("Compagnie de distribution des eaux", "DistributionEaux", true),
            new PanelCaseTerrain("Place de la Bourse"),
            new PanelCaseTerrain("Faubourg Saint-Honoré"),
            new PanelCaseSpeciale("Gare du Nord", "Gare", true),
            new PanelCaseTerrain("Avenue Henri-Martin"),
            new PanelCaseTerrain("Boulevard Malesherbes"),
            new PanelCaseSpeciale("Chance2", "InterrogationBleue", false),
            new PanelCaseTerrain("Avenue Matignon"),
            new PanelCaseCarree("Parc gratuit", "CaseParcGratuit")
        );
    }

}
