package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PanelTourInterne extends VBox {

    private Button terminerTour;
    private PanelTirageDes panelTirageDes;
    private PanelTourBoutons panelTourBoutons;
    private PanelCaseActuelle panelCaseActuelle;


    public PanelTourInterne() {

        this.setAlignment(Pos.CENTER);


        this.panelTirageDes = new PanelTirageDes();

        this.panelTourBoutons = new PanelTourBoutons();
        this.panelTourBoutons.setAlignment(Pos.CENTER);
        this.panelTourBoutons.setPadding(new Insets(10,0,0,0));

        this.panelCaseActuelle = new PanelCaseActuelle();
        this.panelCaseActuelle.setPadding(new Insets(0,0,10,0));

        this.terminerTour = new Button("Terminer mon tour");
        this.terminerTour.setPrefSize(295, 50);
        this.terminerTour.setAlignment(Pos.CENTER);


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
