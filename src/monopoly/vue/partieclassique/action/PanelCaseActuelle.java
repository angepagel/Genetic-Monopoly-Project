package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PanelCaseActuelle extends Pane {

    private PanelActionRectangle rect;
    private PanelActionLabel titre;

    private PanelActionLabel titreCase;
    private PanelActionLabel prixCase;
    private Button acheter;
    private Button encherir;

    public PanelCaseActuelle() {

        this.rect = new PanelActionRectangle(10, 10, 275, 120);

        this.titre = new PanelActionLabel("Case actuelle", 15);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(90);
        this.titre.setPrefHeight(30);
        this.titre.setPadding(Insets.EMPTY);
        this.titre.setLayoutX(30);
        this.titre.setLayoutY(0);

        this.titreCase = new PanelActionLabel("Titre case", 20);
        this.titreCase.setLayoutX(25);
        this.titreCase.setLayoutY(25);
        this.titreCase.setAlignment(Pos.CENTER_LEFT);
        this.prixCase = new PanelActionLabel("$Prix", 18);
        this.prixCase.setLayoutX(25);
        this.prixCase.setLayoutY(50);
        this.prixCase.setAlignment(Pos.CENTER_LEFT);
        this.prixCase.setTextFill(Color.BLUE);

        this.acheter = new Button("Acheter");
        this.acheter.setLayoutX(175);
        this.acheter.setLayoutY(40);
        this.acheter.setPrefWidth(90);

        this.encherir = new Button("Enchérir");
        this.encherir.setLayoutX(175);
        this.encherir.setLayoutY(75);
        this.encherir.setPrefWidth(90);


        this.getChildren().addAll(
                this.rect,
                this.titre,
                this.titreCase,
                this.prixCase,
                this.acheter,
                this.encherir
        );

    }

}
