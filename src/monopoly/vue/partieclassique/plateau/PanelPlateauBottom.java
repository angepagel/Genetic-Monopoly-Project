package monopoly.vue.partieclassique.plateau;

import javafx.scene.layout.HBox;

public class PanelPlateauBottom extends PanelPlateauElement {

    public PanelPlateauBottom() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(0);
        this.getChildren().addAll(
            new PanelCaseCarree("Visite en prison", "CaseVisite"),
            new PanelCaseTerrain("Avenue de la République"),
            new PanelCaseTerrain("Rue de Courcelles"),
            new PanelCaseSpeciale("Chance4", "InterrogationRose", false),
            new PanelCaseTerrain("Rue de Vaugirard"),
            new PanelCaseSpeciale("Gare Montparnasse", "Gare", true),
            new PanelCaseSpeciale("Impôts sur le revenu", "Impots", true),
            new PanelCaseTerrain("Rue Lecourbe"),
            new PanelCaseSpeciale("Caisse de communauté5", "Caisse", true),
            new PanelCaseTerrain("Boulevard de Belleville"),
            new PanelCaseCarree("Départ","CaseDepart"));
    }

}
