package monopoly.vue.partieclassique.action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import monopoly.controleur.ControleurPanelTirageDes;
import monopoly.modele.Jeu;
import monopoly.vue.data.image.GestionnaireImage;


public class PanelTirageDes extends Pane {

    private PanelActionRectangle rect;
    private PanelActionLabel titre;

    private ImageView de_1;
    private ImageView de_2;
    private VueDes vueDes;
    private Button lancerDes;

    private ControleurPanelTirageDes controleurPanelTirageDes;

    public PanelTirageDes() {
        PanelTirageDes self = this;

        this.rect = new PanelActionRectangle(10, 10, 275, 120);

        this.titre = new PanelActionLabel("Tirage des dés", 15);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(100);
        this.titre.setPrefHeight(30);
        this.titre.setPadding(Insets.EMPTY);
        this.titre.setLayoutX(30);
        this.titre.setLayoutY(0);

        // Image dés
        this.de_1 = new ImageView(GestionnaireImage.getImage("De_4"));
        this.de_2 = new ImageView(GestionnaireImage.getImage("De_3"));
        this.vueDes = new VueDes(Jeu.getInstance().getDes(), de_1, de_2);

        this.de_1.setFitWidth(65);
        this.de_1.setFitHeight(65);
        this.de_2.setFitWidth(65);
        this.de_2.setFitHeight(65);

        this.de_1.setX(25);
        this.de_1.setY(50);
        this.de_2.setX(105);
        this.de_2.setY(50);

        // Instanciation des contrôleurs
        this.controleurPanelTirageDes = new ControleurPanelTirageDes();

        // Bouton de lancer des dés
        this.lancerDes = new Button("Lancer de dés");
        this.lancerDes.setLayoutX(175);
        this.lancerDes.setLayoutY(70);
        this.lancerDes.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                self.controleurPanelTirageDes.lancerDes();
            }

        });

        this.getChildren().addAll(
                rect,
                titre,
                de_1,
                de_2,
                lancerDes
        );

    }

    public VueDes getVueDes() {
        return vueDes;
    }
}
