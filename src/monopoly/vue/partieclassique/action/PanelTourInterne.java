package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PanelTourInterne extends VBox {

    private Button terminerTour;
    private PanelTirageDes panelTirageDes;
    private PanelTourBoutons panelTourBoutons;
    private PanelCaseActuelle panelCaseActuelle;


    public PanelTourInterne() {

        this.terminerTour = new Button("Terminer mon tour");
        this.terminerTour.setPrefSize(275, 50);

        this.panelTirageDes = new PanelTirageDes();

        this.panelTourBoutons = new PanelTourBoutons();

        this.panelCaseActuelle = new PanelCaseActuelle();
        this.panelCaseActuelle.setPadding(new Insets(0,0,10,0));



        this.getChildren().addAll(
                this.panelTirageDes,
                this.panelTourBoutons,
                this.panelCaseActuelle,
                this.terminerTour
        );
    }

    public PanelTirageDes getPanelTirageDes() {
        return panelTirageDes;
    }
}
