package monopoly.vue.partieclassique.action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import monopoly.controleur.ControleurCaseJoueur;
import monopoly.controleur.ControleurPanelCaseActuelle;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.Pion;
import monopoly.modele.cases.Case_Achat;
import monopoly.modele.cases.Case_Paiement;

public class PanelCaseActuelle extends Pane {

    private PanelActionRectangle rect;
    private PanelActionLabel titre;

    private PanelActionLabel titreCase;
    private PanelActionLabel prixCase;
    private Button acheter;
    private Button encherir;

    private ControleurPanelCaseActuelle controleurPanelCaseActuelle;

    public PanelCaseActuelle() {

        // On définit le contrôleur de case actuelle pour tous les pions du jeu
        for (Joueur joueur : Jeu.getInstance().getJoueurs()) {
            joueur.getPion().setControleurCaseJoueur(new ControleurCaseJoueur(joueur.getPion(), this));
        }

        this.rect = new PanelActionRectangle(10, 10, 275, 120);

        this.titre = new PanelActionLabel("Case actuelle", 15);
        this.titre.setBackgroundColor(Color.web("F4F4F4"));
        this.titre.setPrefWidth(90);
        this.titre.setPrefHeight(30);
        this.titre.setPadding(Insets.EMPTY);
        this.titre.setLayoutX(30);
        this.titre.setLayoutY(0);

        this.titreCase = new PanelActionLabel("Départ", 14);
        this.titreCase.setLayoutX(25);
        this.titreCase.setLayoutY(25);
        this.titreCase.setMaxWidth(100);
        this.titreCase.setAlignment(Pos.CENTER);
        this.prixCase = new PanelActionLabel("", 14);
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

        // Définition du contrôleur du panel
        this.controleurPanelCaseActuelle = new ControleurPanelCaseActuelle(this);

        // Attribut self utilisé pour référencer la classe PanelCaseActuelle dans le EventHandler des boutons
        PanelCaseActuelle self = this;

        this.acheter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                self.controleurPanelCaseActuelle.acheter();
            }
        });

    }

    /**
     * Met à jour la case actuelle du joueur.
     * @param pion Pion utilisé pour mettre à jour la case actuelle.
     */
    public void actualiserCase(Pion pion) {

        this.titreCase.setText(pion.getPosition().getNom());
        if(pion.getPosition().aUnPrix()){
            Case_Paiement casePrix = (Case_Paiement) pion.getPosition();
            this.prixCase.setText("$"+Integer.toString(casePrix.getPrix()));
        }
        else{
            this.prixCase.setText("");
        }
        
    }



}
