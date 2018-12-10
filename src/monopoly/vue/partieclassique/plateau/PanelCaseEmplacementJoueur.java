package monopoly.vue.partieclassique.plateau;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by maxim on 23/11/2018.
 */
public class PanelCaseEmplacementJoueur extends Pane {

    private boolean occupe;
    private ImageView image;

    public PanelCaseEmplacementJoueur() {

        this.setWidth(14);
        this.setHeight(14);
        this.setMaxHeight(14);
        this.setMaxWidth(14);
        this.setMinHeight(14);
        this.setMinWidth(14);

        this.image = new ImageView();
        this.image.setFitHeight(14);
        this.image.setFitWidth(14);
        this.getChildren().add(image);

        this.occupe = false;
    }

    /**
     * Retourne true si l'emplacement est déjà occupé par un pion, et false si autrement.
     * @return true si l'emplacement est déjà occupé par un pion, et false si autrement.
     */
    public boolean estOccupe() {
        return this.occupe;
    }


    public void setImage(Image image) {
        this.image.setImage(image);
        this.occupe = true;
    }

    public void vider() {
        this.image.setImage(null);
        this.occupe = false;
    }

}
