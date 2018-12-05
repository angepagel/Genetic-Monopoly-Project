package monopoly.vue.partieclassique.action;

import javafx.scene.layout.Pane;

public class PanelInformationsJeu extends Pane {

    private PanelActionLabel titre;
    private PanelActionLabel tempsJeuTitre;
    private PanelActionLabel nbToursTitre;
    private PanelActionLabel tempsJeuValeur;
    private PanelActionLabel nbToursValeur;

    public PanelInformationsJeu() {

        this.titre = new PanelActionLabel("Informations de jeu", 20);
        this.tempsJeuTitre = new PanelActionLabel("Temps de jeu : ", 10);
        this.tempsJeuValeur = new PanelActionLabel("02:38", 10);
        this.nbToursTitre = new PanelActionLabel("Nombre de tours : ", 10);
        this.nbToursValeur = new PanelActionLabel("27", 10);

        this.getChildren().addAll(this.titre);

    }

}
