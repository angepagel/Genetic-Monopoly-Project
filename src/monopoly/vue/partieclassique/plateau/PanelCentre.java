package monopoly.vue.partieclassique.plateau;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PanelCentre extends ImageView {

    public PanelCentre() {
        double w = 524;
        double h = 520;

        this.setFitWidth(w);
        this.setFitHeight(h);
        this.maxHeight(h);
        this.maxWidth(w);
        this.minHeight(h);
        this.minWidth(w);
        this.setImage(new Image("file:src/monopoly/vue/data/image/Centre.png"));
    }

}
