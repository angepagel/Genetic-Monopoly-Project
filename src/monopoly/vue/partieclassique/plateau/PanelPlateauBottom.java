package monopoly.vue.partieclassique.plateau;

import javafx.scene.layout.HBox;

public class PanelPlateauBottom extends HBox {

    public PanelPlateauBottom() {

        this.setWidth(500);
        this.setHeight(500);
        this.setRotate(0);
        this.getChildren().add(new PanelCaseDepart());
        this.getChildren().add(new PanelCaseTerrain("Avenue de la République"));
        this.getChildren().add(new PanelCaseTerrain("Rue de Courcelles"));
        //this.getChildren().add(new PanelCaseTerrain());
        this.getChildren().add(new PanelCaseTerrain("Rue de Vaugirard"));
        //this.getChildren().add(new PanelCaseTerrain("Gare Montparnasse"));
        //this.getChildren().add(new PanelCaseTerrain("Impôts sur le revenu"));
        this.getChildren().add(new PanelCaseTerrain("Rue Lecourbe"));
        //this.getChildren().add(new PanelCaseTerrain());
        this.getChildren().add(new PanelCaseTerrain("Boulevard de Belleville"));
        this.getChildren().add(new PanelCaseDepart());
    }

}
