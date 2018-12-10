package monopoly.vue.partieclassique.plateau;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import monopoly.vue.data.image.GestionnaireImage;

public class PanelCaseCarree extends PanelCase {

    private PanelCaseConteneurEmplacement conteneurEmplacement;

    public PanelCaseCarree(String nomCase, String nomImage) {
        super(nomCase);

        this.setPrefSize(90,90);
        this.setMaxSize(90,90);
        this.setMinSize(90,90);

        this.setBackground(new Background(new BackgroundImage(GestionnaireImage.getImage(nomImage),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(90, 90, true, true, true, true))));

        this.conteneurEmplacement = new PanelCaseConteneurEmplacement();

        this.getChildren().addAll(
                this.conteneurEmplacement
        );

    }

    @Override
    public PanelCaseConteneurEmplacement getConteneurEmplacements() {
        return this.conteneurEmplacement;
    }

}
