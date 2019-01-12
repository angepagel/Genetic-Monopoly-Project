package monopoly.vue.partieclassique.action;

import javafx.scene.layout.VBox;

/**
 * Panel affichant les informations liées aux jeu,
 * qui permet au joueur d'exécuter des actions.
 */
public class PanelAction extends VBox {

    private PanelTour panelTour;
    private PanelJoueurs panelJoueurs;
    private PanelInformationsJeu panelInformationsJeu;

    public PanelAction() {
        this.setWidth(380);
        this.setHeight(700);
        this.setMaxWidth(380);
        this.setMaxHeight(700);
        this.setMinWidth(380);
        this.setMinHeight(700);

        panelInformationsJeu = new PanelInformationsJeu();
        panelJoueurs = new PanelJoueurs();
        panelTour = new PanelTour();

        this.getChildren().add(panelInformationsJeu);
        this.getChildren().add(panelJoueurs);
        this.getChildren().add(panelTour);
    }

    public PanelTour getPanelTour() {
        return panelTour;
    }

    public PanelJoueurs getPanelJoueurs() {
        return panelJoueurs;
    }

    public PanelInformationsJeu getPanelInformationsJeu() {
        return panelInformationsJeu;
    }
}
