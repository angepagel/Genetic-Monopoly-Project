package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PanelJoueurs extends Pane {

    private PanelActionRectangle rect;
    private PanelActionLabel titre;
    private ArrayList<PanelInfosJoueur> joueurs;

    public PanelJoueurs() {

        this.setWidth(380);
        this.setHeight(170);
        this.setMaxHeight(170);
        this.setMinHeight(170);
        this.setMinWidth(380);
        this.setMaxWidth(380);

        this.rect = new PanelActionRectangle(20, 15, 330, 140);

        this.titre = new PanelActionLabel("Joueurs", 20);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(74);
        this.titre.setPrefHeight(30);
        this.titre.setPadding(Insets.EMPTY);
        this.titre.setLayoutX(30);
        this.titre.setLayoutY(0);

        this.joueurs = new ArrayList<>();

        for (int i = 1; i <=8; i++) {

            // If factorisable avec des mathématiques (mais moins intuitif)
            if (i <= 4) {
                this.joueurs.add(new PanelInfosJoueur(40, 22+((i-1)*25)));
            }
            else {
                this.joueurs.add(new PanelInfosJoueur(200, 22+((i-5)*25)));
            }

            this.joueurs.get(i-1).setPrefWidth(70);
            this.getChildren().add(this.joueurs.get(i-1));
        }



        this.getChildren().addAll(
                this.rect,
                this.titre
        );

    }

}
