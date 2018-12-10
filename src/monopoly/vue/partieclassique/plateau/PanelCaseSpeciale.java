package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import monopoly.modele.Jeu;
import monopoly.modele.cases.Case;
import monopoly.vue.data.image.GestionnaireImage;

public class PanelCaseSpeciale extends PanelCase {

    private PanelCaseLabel nom;
    private PanelCaseConteneurEmplacement emplacements;
    private Label prix;

    public PanelCaseSpeciale(String id, String image, boolean prix) {
        super(id);

        this.setBackground(new Background(new BackgroundImage(
                GestionnaireImage.getImage(image),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, false))));


        this.nom = new PanelCaseLabel(this.getModele().getNom().toUpperCase());
        this.nom.setFont(new Font("System", 7));
        this.emplacements = new PanelCaseConteneurEmplacement();
        this.getChildren().addAll(this.nom, this.emplacements);


        if (prix) {
            this.prix = new PanelCaseLabel("$Prix");
            this.prix.setPadding(new Insets(27,0,0,0));
            this.getChildren().add(this.prix);
        }


    }

}
