package monopoly.vue.partieclassique.action;

import javafx.scene.layout.VBox;

/**
 * Panel affichant les informations liées aux jeu,
 * qui permet au joueur d'exécuter des actions.
 */
public class PanelAction extends VBox {

    public PanelAction() {

        this.setWidth(380);
        this.setHeight(700);
        this.setMaxWidth(380);
        this.setMaxHeight(700);
        this.setMinWidth(380);
        this.setMinHeight(700);

        this.getChildren().add(new PanelInformationsJeu());
        this.getChildren().add(new PanelJoueurs());
        this.getChildren().add(new PanelTour());

    }

}
