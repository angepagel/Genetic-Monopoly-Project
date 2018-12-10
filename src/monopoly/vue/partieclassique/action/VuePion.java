package monopoly.vue.partieclassique.action;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monopoly.modele.Pion;
import monopoly.vue.data.image.GestionnaireImage;

import java.util.Objects;

public class VuePion {

    private Pion pion;
    private ImageView imageView;

    public VuePion(Pion pion) {
        this.pion = pion;
        this.imageView = new ImageView(GestionnaireImage.getImage("PionRouge"));
    }

    public void miseAJour() {

    }

    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VuePion vuePion = (VuePion) o;
        return Objects.equals(pion, vuePion.pion) &&
                Objects.equals(imageView, vuePion.imageView);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pion, imageView);
    }
}
