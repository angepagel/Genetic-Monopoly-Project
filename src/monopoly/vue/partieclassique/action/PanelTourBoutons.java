package monopoly.vue.partieclassique.action;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class PanelTourBoutons extends HBox {

    private Button gererProprietes;
    private Button echanger;

    public PanelTourBoutons() {

        this.gererProprietes = new Button("Gérer mes propriétés");
        this.gererProprietes.setAlignment(Pos.CENTER_LEFT);
        this.echanger = new Button("Echanger");
        this.echanger.setAlignment(Pos.CENTER_RIGHT);

        this.getChildren().addAll(
            this.gererProprietes,
                this.echanger
        );

    }

}
