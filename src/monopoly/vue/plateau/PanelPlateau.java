package monopoly.vue.plateau;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class PanelPlateau extends BorderPane {

    private ImageView imagePlateau;

    public PanelPlateau() {

        // Init components
        this.imagePlateau = new ImageView(new Image("file:src/monopoly/vue/data/image/Plateau.jpg"));
        this.imagePlateau.setFitWidth(700);
        this.imagePlateau.setFitHeight(700);

        //this.getChildren().add(this.imagePlateau);
        this.setBottom(new PanelPlateauBottom());
        this.setLeft(new PanelPlateauLeft());
        this.setRight(new PanelPlateauRight());
        this.setTop(new PanelPlateauTop());


    }

}
