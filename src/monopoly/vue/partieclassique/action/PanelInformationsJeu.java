package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import monopoly.vue.partieclassique.Partie;

public class PanelInformationsJeu extends Pane {

    private PanelActionLabel titre;
    private PanelActionLabel tempsJeuTitre;
    private PanelActionLabel nbToursTitre;
    private PanelActionLabel tempsJeuValeur;
    private PanelActionLabel nbToursValeur;
    private PanelActionRectangle rect;

    public PanelInformationsJeu() {

        this.setWidth(380);
        this.setHeight(100);
        this.setMaxHeight(100);
        this.setMinHeight(100);
        this.setMinWidth(380);
        this.setMaxWidth(380);

        this.rect = new PanelActionRectangle(20, 15, 300, 70);

        // Titre
        this.titre = new PanelActionLabel("Informations de jeu", 20);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(180);
        this.titre.setPrefHeight(30);
        this.titre.setPadding(Insets.EMPTY);
        this.titre.setLayoutX(30);
        this.titre.setLayoutY(0);

        // Temps de jeu
        this.tempsJeuTitre = new PanelActionLabel("Temps de jeu : ", 12);
        this.tempsJeuTitre.setAlignment(null);
        this.tempsJeuTitre.setLayoutX(40);
        this.tempsJeuTitre.setLayoutY(15);

        this.tempsJeuValeur = new PanelActionLabel("02:38", 12);
        this.tempsJeuValeur.setAlignment(null);
        this.tempsJeuValeur.setLayoutX(120);
        this.tempsJeuValeur.setLayoutY(15);
        this.tempsJeuValeur.setTextFill(Color.BLUE);

        // Nombre de tours
        this.nbToursTitre = new PanelActionLabel("Nombre de tours : ", 12);
        this.nbToursTitre.setAlignment(null);
        this.nbToursTitre.setLayoutX(40);
        this.nbToursTitre.setLayoutY(30);

        this.nbToursValeur = new PanelActionLabel("27", 12);
        this.nbToursValeur.setAlignment(null);
        this.nbToursValeur.setLayoutX(140);
        this.nbToursValeur.setLayoutY(30);
        this.nbToursValeur.setTextFill(Color.BLUE);




        this.getChildren().addAll(
                this.rect,
                this.titre,
                this.tempsJeuTitre,
                this.tempsJeuValeur,
                this.nbToursTitre,
                this.nbToursValeur
                );

    }

}
