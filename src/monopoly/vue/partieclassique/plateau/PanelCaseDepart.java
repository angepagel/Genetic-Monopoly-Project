package monopoly.vue.partieclassique.plateau;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PanelCaseDepart extends ImageView {

    public PanelCaseDepart() {

        this.setImage(new Image("file:src/monopoly/vue/data/image/CaseDepart.png"));

        double height = 90;
        double width = 88;

        this.setFitWidth(width);
        this.setFitHeight(height);

    }

}
