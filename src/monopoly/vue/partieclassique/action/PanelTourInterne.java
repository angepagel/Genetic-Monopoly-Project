package monopoly.vue.partieclassique.action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import monopoly.controleur.ControleurPanelTourInterne;

public class PanelTourInterne extends VBox {

    private Button terminerTour;
    private PanelTirageDes panelTirageDes;
    private PanelTourBoutons panelTourBoutons;
    private PanelCaseActuelle panelCaseActuelle;
    private ControleurPanelTourInterne controleurPanelTourInterne;


    public PanelTourInterne() {

        PanelTourInterne self = this;

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
        this.controleurPanelTourInterne = new ControleurPanelTourInterne();

        this.terminerTour.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                self.controleurPanelTourInterne.terminerTour();
            }

        });

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
