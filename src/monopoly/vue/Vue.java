package monopoly.vue;

import javafx.scene.image.ImageView;

public abstract class Vue {

    private ImageView image;

    public Vue(ImageView imgView) {
        this.image = imgView;
    }

    public ImageView getImageView() {
        return this.image;
    }

    public void setImageView(ImageView i) {
        this.image = i;
    }

    public abstract void miseAJour();

}
