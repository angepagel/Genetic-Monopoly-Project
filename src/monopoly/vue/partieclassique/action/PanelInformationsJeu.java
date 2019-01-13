package monopoly.vue.partieclassique.action;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import monopoly.controleur.ControleurPanelInformationsJeu;
import monopoly.modele.Jeu;

public class PanelInformationsJeu extends Pane {

    private PanelActionLabel titre;
    private PanelActionLabel tempsJeuTitre;
    private PanelActionLabel nbToursTitre;
    private PanelActionLabel tempsJeuValeur;
    private PanelActionLabel nbToursValeur;
    private PanelActionLabel nomJoueurTitre;
    private PanelActionLabel nomJoueurValeur;
    private PanelActionLabel couleurPionTitre;
    private PanelActionLabel couleurPionValeur;
    private PanelActionRectangle rect;

    private ControleurPanelInformationsJeu controleurPanelInformationsJeu;

    public PanelInformationsJeu() {

        this.setWidth(380);
        this.setHeight(100);
        this.setMaxHeight(100);
        this.setMinHeight(100);
        this.setMinWidth(380);
        this.setMaxWidth(380);

        this.rect = new PanelActionRectangle(20, 15, 330, 70);

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

        this.tempsJeuValeur = new PanelActionLabel("00:00", 12);
        this.tempsJeuValeur.setAlignment(null);
        this.tempsJeuValeur.setLayoutX(120);
        this.tempsJeuValeur.setLayoutY(15);
        this.tempsJeuValeur.setTextFill(Color.BLUE);

        // Nombre de tours
        this.nbToursTitre = new PanelActionLabel("Numéro du tour : ", 12);
        this.nbToursTitre.setAlignment(null);
        this.nbToursTitre.setLayoutX(40);
        this.nbToursTitre.setLayoutY(30);

        this.nbToursValeur = new PanelActionLabel("1", 12);
        this.nbToursValeur.setAlignment(null);
        this.nbToursValeur.setLayoutX(140);
        this.nbToursValeur.setLayoutY(30);
        this.nbToursValeur.setTextFill(Color.BLUE);

        // Nom du joueur
        this.nomJoueurTitre = new PanelActionLabel("Nom du joueur :", 12);
        this.nomJoueurTitre.setAlignment(null);
        this.nomJoueurTitre.setLayoutX(200);
        this.nomJoueurTitre.setLayoutY(15);

        this.nomJoueurValeur = new PanelActionLabel("[NomJoueur]", 12);
        this.nomJoueurValeur.setAlignment(null);
        this.nomJoueurValeur.setLayoutX(200);
        this.nomJoueurValeur.setLayoutY(30);
        this.nomJoueurValeur.setTextFill(Color.BLUE);

        // Couleur du pion
        this.couleurPionTitre = new PanelActionLabel("Couleur du pion :", 12);
        this.couleurPionTitre.setAlignment(null);
        this.couleurPionTitre.setLayoutX(40);
        this.couleurPionTitre.setLayoutY(45);

        this.couleurPionValeur = new PanelActionLabel("[Couleur]", 12);
        this.couleurPionValeur.setAlignment(null);
        this.couleurPionValeur.setLayoutX(140);
        this.couleurPionValeur.setLayoutY(45);
        this.couleurPionValeur.setTextFill(Color.BLUE);



        this.getChildren().addAll(
                this.rect,
                this.titre,
                this.tempsJeuTitre,
                this.tempsJeuValeur,
                this.nbToursTitre,
                this.nbToursValeur,
                this.nomJoueurTitre,
                this.nomJoueurValeur,
                this.couleurPionTitre,
                this.couleurPionValeur
        );

        this.controleurPanelInformationsJeu = new ControleurPanelInformationsJeu(this);
        Jeu.getInstance().initialiserTimer();
        this.actualiser();

    }

    public void actualiser() {
        this.tempsJeuValeur.setText(Jeu.getInstance().getChronometre().afficher());
        int nbTours = Jeu.getInstance().getNbTours();
        this.nbToursValeur.setText(Integer.toString(nbTours+1));
        this.nomJoueurValeur.setText(Jeu.getInstance().getJoueurEnCours().getNom());
        this.couleurPionValeur.setText(Jeu.getInstance().getJoueurEnCours().getPion().getNom());
    }

}
