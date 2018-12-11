package monopoly.vue.partieclassique.plateau;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import monopoly.vue.data.image.GestionnaireImage;
import monopoly.vue.partieclassique.action.VuePion;

/**
 * Created by maxim on 23/11/2018.
 */
public class PanelCaseEmplacementJoueur extends Pane {

    private boolean occupe;
    private ImageView image;
    private VuePion vuePion;

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

        this.vuePion = null;
    }

    /**
     * Retourne true si l'emplacement est déjà occupé par un pion, et false si autrement.
     * @return true si l'emplacement est déjà occupé par un pion, et false si autrement.
     */
    public boolean estOccupe() {
        return (this.vuePion != null);
    }

    public void ajouterPion(VuePion vuePion) {
        this.vuePion = vuePion;
        this.image.setImage(vuePion.getImageView().getImage());
    }

    public void vider() {
        this.vuePion = null;
        this.image.setImage(null);
    }

    public boolean pionIdentique(VuePion vuePion) {
        if(this.vuePion == null)
            return false;
        return this.vuePion.equals(vuePion);
    }

}
