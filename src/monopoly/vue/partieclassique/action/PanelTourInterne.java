package monopoly.vue.partieclassique.action;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PanelTourInterne extends VBox {

    private Button terminerTour;
    private PanelTirageDes panelTirageDes;

    public PanelTourInterne() {

        this.terminerTour = new Button("Terminer mon tour");
        panelTirageDes = new PanelTirageDes();

        this.getChildren().addAll(
                panelTirageDes,
                new PanelTourBoutons(),
                new PanelCaseActuelle(),
                this.terminerTour
        );
    }

    public PanelTirageDes getPanelTirageDes() {
        return panelTirageDes;
    }
}
