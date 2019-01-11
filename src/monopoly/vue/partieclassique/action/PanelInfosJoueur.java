package monopoly.vue.partieclassique.action;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PanelInfosJoueur extends Pane {

    // Représente le couple de labels "Joueur 1 : $500"

    private PanelActionLabel nom;
    private PanelActionLabel argent;

    public PanelInfosJoueur(int x, int y) {

        this.setLayoutX(x);
        this.setLayoutY(y);

        this.nom = new PanelActionLabel("Joueur : ", 12);
        this.nom.setAlignment(null);
        this.nom.setLayoutX(0);
        this.nom.setLayoutY(0);

        this.argent = new PanelActionLabel("$640000", 12);
        this.argent.setAlignment(null);
        this.argent.setLayoutX(55);
        this.argent.setLayoutY(0);
        this.argent.setTextFill(Color.BLUE);

        this.getChildren().addAll(this.nom, this.argent);

    }

    public void setText(String text) {
        this.argent.setText(text);
    }

    
}
