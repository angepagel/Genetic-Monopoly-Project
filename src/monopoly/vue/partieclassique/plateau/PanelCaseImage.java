package monopoly.vue.partieclassique.plateau;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PanelCaseImage extends ImageView {

    public PanelCaseImage(String address) {

        this.setImage(new Image("file:src/monopoly/vue/data/image/Train.png"));
        this.setFitWidth(30);
        this.setFitHeight(20);
        this.setX(15);

    }

}
