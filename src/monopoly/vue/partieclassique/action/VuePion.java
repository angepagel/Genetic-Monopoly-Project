package monopoly.vue.partieclassique.action;

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
    private String casePresente;

    public VuePion(Pion pion, PanelPlateau panelPlateau) {
        this.pion = pion;
        this.controleurDeplacementPion = new ControleurDeplacementPion(pion, this);
        this.pion.setControleurDeplacement(this.controleurDeplacementPion);
        this.panelPlateau = panelPlateau;
        this.imageView = new ImageView(GestionnaireImage.getImage("PionRouge"));
        casePresente = pion.getPosition().getId();
    }

    public void miseAJour() {
        if(casePresente != null) {
            this.panelPlateau.getPanelCase(casePresente).getConteneurEmplacements().enleverPion(this);
        }
        casePresente = pion.getPosition().getId();
        this.panelPlateau.getPanelCase(casePresente).getConteneurEmplacements().insererPion(this);
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
