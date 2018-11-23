package monopoly.vue;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Created by maxim on 23/11/2018.
 */
public class Panel_Case {

    private FlowPane mainPane;

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

    public Panel_Case(Double rotate) {

        this.header = new FlowPane();
        this.emplacementJoueur_1 = new ImageView();
        this.emplacementJoueur_2 = new ImageView();
        this.emplacementJoueur_3 = new ImageView();
        this.emplacementJoueur_4 = new ImageView();
        this.emplacementJoueur_5 = new ImageView();
        this.emplacementJoueur_6 = new ImageView();
        this.emplacementJoueur_7 = new ImageView();
        this.emplacementJoueur_8 = new ImageView();
        this.prix = new Label("$00");

        this.mainPane = new FlowPane();
        this.mainPane.getChildren().addAll(header, emplacementJoueur_1, emplacementJoueur_2,
                emplacementJoueur_3, emplacementJoueur_4, emplacementJoueur_5,
                emplacementJoueur_6, emplacementJoueur_7, emplacementJoueur_8,
                prix);

        this.mainPane.setRotate(rotate);

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


    }

}
