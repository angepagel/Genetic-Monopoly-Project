package monopoly.vue.partieclassique.plateau;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class PanelPlateauElement extends HBox {

    public PanelCase getPanelCase(String id) {

        PanelCase res = null;

        for (Node panelCase : this.getChildren()) {

            if (id.equals( ((PanelCase)panelCase).getModele().getId())) {
                res = (PanelCase) panelCase;
            }

        }

        return res;

    }

}
