package monopoly.vue.partieclassique.action;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import monopoly.modele.Jeu;

public class PanelInfosJoueur extends Pane {

    // Représente le couple de labels "Joueur 1 : $500"

    private PanelActionLabel nom;
    private PanelActionLabel argent;

    public PanelInfosJoueur(int x, int y, String nomJoueur) {

        this.setLayoutX(x);
        this.setLayoutY(y);

        this.nom = new PanelActionLabel(nomJoueur+" : ", 12);
        this.nom.setAlignment(null);
        this.nom.setLayoutX(0);
        this.nom.setLayoutY(10);
        this.nom.setMaxSize(50, 30);
        this.nom.setMinSize(50, 30);

        this.argent = new PanelActionLabel("$"+ Jeu.getInstance().getMontantInitial(), 12);
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
