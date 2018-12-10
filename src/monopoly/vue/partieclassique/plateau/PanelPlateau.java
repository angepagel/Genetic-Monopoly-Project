package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class PanelPlateau extends BorderPane {

    private ImageView imagePlateau;

    public PanelPlateau() {

        this.setWidth(700);
        this.setHeight(700);
        this.setMaxWidth(700);
        this.setMaxHeight(700);
        this.setMinWidth(700);
        this.setMinHeight(700);

        this.setPadding(Insets.EMPTY);

        // Init components
        this.imagePlateau = new ImageView(new Image("file:src/monopoly/vue/data/image/Plateau.jpg"));
        this.imagePlateau.setFitWidth(700);
        this.imagePlateau.setFitHeight(700);

        //this.getChildren().add(this.imagePlateau);
        this.setCenter(new PanelCentre());
        this.setBottom(new PanelPlateauBottom());
        this.setTop(new PanelPlateauTop());
        this.setLeft(new PanelPlateauLeft());
        this.setRight(new PanelPlateauRight());




    }

}
