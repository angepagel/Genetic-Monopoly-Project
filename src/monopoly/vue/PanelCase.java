package monopoly.vue;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Created by maxim on 23/11/2018.
 */
public class PanelCase extends FlowPane {

    private FlowPane header;
    private Label nom;
    private ImageView emplacementJoueur_1;
    private ImageView emplacementJoueur_2;
    private ImageView emplacementJoueur_3;
    private ImageView emplacementJoueur_4;
    private ImageView emplacementJoueur_5;
    private ImageView emplacementJoueur_6;
    private ImageView emplacementJoueur_7;
    private ImageView emplacementJoueur_8;
    private Label prix;

    public PanelCase() {

        this.header = new FlowPane();
        this.nom = new Label();
        this.emplacementJoueur_1 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_2 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_3 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_4 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_5 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_6 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_7 = new PanelCaseEmplacementJoueur();
        this.emplacementJoueur_8 = new PanelCaseEmplacementJoueur();
        this.prix = new Label();

        this.getChildren().addAll(header, emplacementJoueur_1, emplacementJoueur_2,
                emplacementJoueur_3, emplacementJoueur_4, emplacementJoueur_5,
                emplacementJoueur_6, emplacementJoueur_7, emplacementJoueur_8,
                prix);

        this.setPrefWidth(58);
        this.setPrefHeight(90);
        this.setMinWidth(Region.USE_PREF_SIZE);
        this.setMinHeight(Region.USE_PREF_SIZE);
        this.setMaxWidth(Region.USE_PREF_SIZE);
        this.setMaxHeight(Region.USE_PREF_SIZE);
        this.setRotate(0);

        // Header parameters
        this.header.setPrefWidth(56);
        this.header.setPrefHeight(17);
        this.header.setMinWidth(Region.USE_PREF_SIZE);
        this.header.setMinHeight(Region.USE_PREF_SIZE);
        this.header.setMaxWidth(Region.USE_PREF_SIZE);
        this.header.setMaxHeight(Region.USE_PREF_SIZE);
        this.header.setStyle("-fx-border-color: black;");
        this.header.setStyle("-fx-background-color: #944828;");
        this.header.setStyle("-fx-border-width:  0px 0px 1px 0px;");

        // Paramètres du nom
        this.nom.setPrefWidth(56);
        this.nom.setPrefHeight(29);
        this.nom.setText("");
        this.nom.setFont(new Font("System", 7));
        this.nom.setTextAlignment(TextAlignment.CENTER);

        // Paramètres du label de prix
        this.prix.setPrefWidth(56);
        this.prix.setPrefHeight(16);
        this.prix.setText("");
        this.prix.setFont(new Font("System", 7));
        this.prix.setTextAlignment(TextAlignment.CENTER);
    }

}
