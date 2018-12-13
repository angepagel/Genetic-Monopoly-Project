package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import monopoly.controleur.ControleurCaseActuelle;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.Pion;

public class PanelCaseActuelle extends Pane {

    private PanelActionRectangle rect;
    private PanelActionLabel titre;

    private PanelActionLabel titreCase;
    private PanelActionLabel prixCase;
    private Button acheter;
    private Button encherir;

    public PanelCaseActuelle() {

        // On définit le contrôleur de case actuelle pour tous les pions du jeu
        for (Joueur joueur : Jeu.getInstance().getJoueurs()) {
            joueur.getPion().setControleurCaseActuelle(new ControleurCaseActuelle(joueur.getPion(), this));
            System.out.println("lmaoKappa");
        }
        System.out.println("lmaoKappa2");


        this.rect = new PanelActionRectangle(10, 10, 275, 120);

        this.titre = new PanelActionLabel("Case actuelle", 15);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(90);
        this.titre.setPrefHeight(30);
        this.titre.setPadding(Insets.EMPTY);
        this.titre.setLayoutX(30);
        this.titre.setLayoutY(0);

        this.titreCase = new PanelActionLabel("Titre case", 15);
        this.titreCase.setLayoutX(25);
        this.titreCase.setLayoutY(25);
        this.titreCase.setMaxWidth(100);
        this.titreCase.setAlignment(Pos.CENTER_LEFT);
        this.prixCase = new PanelActionLabel("$Prix", 15);
        this.prixCase.setLayoutX(50);
        this.prixCase.setLayoutY(65);
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

    public void actualiser(Pion pion) {
        this.titreCase.setText(pion.getPosition().getNom());
    }

}
