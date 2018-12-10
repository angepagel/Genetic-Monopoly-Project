package monopoly.vue.partieclassique.plateau;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import monopoly.vue.data.image.GestionnaireImage;

public class PanelCaseCarree extends PanelCase {

    private ImageView image;
    private PanelCaseConteneurEmplacement conteneurEmplacement;

    public PanelCaseCarree(String nomCase, String nomImage) {
        super(nomCase);

        this.setPrefSize(90,90);
        this.setMaxSize(90,90);
        this.setMinSize(90,90);

        this.image = new ImageView(GestionnaireImage.getImage(nomImage));
        this.image.setFitWidth(90);
        this.image.setFitHeight(90);

        this.conteneurEmplacement = new PanelCaseConteneurEmplacement();

        this.getChildren().addAll(
                this.image,
                this.conteneurEmplacement
        );

    }

    @Override
    public PanelCaseConteneurEmplacement getConteneurEmplacements() {
        return this.conteneurEmplacement;
    }

}
