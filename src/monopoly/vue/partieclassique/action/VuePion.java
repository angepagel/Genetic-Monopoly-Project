package monopoly.vue.partieclassique.action;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monopoly.controleur.ControleurDeplacementPion;
import monopoly.modele.Pion;
import monopoly.vue.data.image.GestionnaireImage;
import monopoly.vue.partieclassique.plateau.PanelPlateau;

import java.util.Objects;

public class VuePion {

    private Pion pion;
    private ControleurDeplacementPion controleurDeplacementPion;
    private ImageView imageView;
    private PanelPlateau panelPlateau;

    public VuePion(Pion pion, PanelPlateau panelPlateau) {
        this.pion = pion;
        this.controleurDeplacementPion = new ControleurDeplacementPion(pion, this);
        this.pion.setControleur(this.controleurDeplacementPion);
        System.out.println(this.pion);
        this.panelPlateau = panelPlateau;
        this.imageView = new ImageView(GestionnaireImage.getImage("PionRouge"));
    }

    public void miseAJour() {
        this.panelPlateau.getPanelCase(this.pion.getPosition().getId()).getConteneurEmplacements().insererPion(this);
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
