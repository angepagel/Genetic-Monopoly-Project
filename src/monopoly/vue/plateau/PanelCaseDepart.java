package monopoly.vue.plateau;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PanelCaseDepart extends ImageView {

    public PanelCaseDepart() {

        this.setImage(new Image("file:src/monopoly/vue/data/image/CaseDepart.png"));
        this.setFitWidth(90);
        this.setFitHeight(90);
        this.maxHeight(90);
        this.maxWidth(90);
        this.minHeight(90);
        this.minWidth(90);

    }

}
