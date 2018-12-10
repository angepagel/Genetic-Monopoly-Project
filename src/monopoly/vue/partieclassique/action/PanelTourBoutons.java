package monopoly.vue.partieclassique.action;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class PanelTourBoutons extends HBox {

    private Button gererProprietes;
    private Button echanger;

    public PanelTourBoutons() {

        this.gererProprietes = new Button("Gérer mes propriétés");
        this.echanger = new Button("Echanger");

        this.getChildren().addAll(
            this.gererProprietes,
                this.echanger
        );

    }

}
