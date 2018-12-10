package monopoly.vue.partieclassique.plateau;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import monopoly.vue.partieclassique.action.PanelCaseActuelle;
import monopoly.vue.partieclassique.action.PanelTirageDes;

public class PanelTourInterne extends VBox {

    private Button terminerTour;


    public PanelTourInterne() {

        this.terminerTour = new Button("Terminer mon tour");

        this.getChildren().addAll(
                new PanelTirageDes(),
                new PanelTourBoutons(),
                new PanelCaseActuelle(),
                this.terminerTour
        );
    }

}
