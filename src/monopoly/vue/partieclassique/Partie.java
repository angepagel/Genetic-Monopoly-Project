/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.vue.partieclassique;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.vue.IVuePartie;
import monopoly.vue.data.image.GestionnaireImage;
import monopoly.vue.partieclassique.action.PanelAction;
import monopoly.vue.partieclassique.action.VuePion;
import monopoly.vue.partieclassique.plateau.PanelPlateau;

import java.io.IOException;

public class Partie implements IVuePartie {

    private HBox root;

    private PanelPlateau panelPlateau;
    private PanelAction panelAction;

    public Partie() throws IOException {

        // Initialisation de la partie
        Jeu j = Jeu.getInstance();
        j.initialisation();
        j.initPositions();

        j.setJoueurAleatoire();

        this.panelPlateau = new PanelPlateau();
        this.panelAction = new PanelAction();

        for(Joueur joueur : j.getJoueurs()) {
            VuePion vp = new VuePion(joueur.getPion(), this.panelPlateau);
            vp.getImageView().setImage(GestionnaireImage.getImage("Pion" + joueur.getPion().getNom()));
            vp.miseAJour();
        }

        // Initialisation des composants
        root = new HBox();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        root.getChildren().add(panelPlateau);
        root.getChildren().add(panelAction);

        root.setPrefSize(1080,700);

        stage.setTitle("Partie Classique");
        stage.getIcons().add(new Image("file:src/monopoly/vue/data/image/Icone.png"));
        stage.setScene(scene);
        stage.show();

        // Initialisation des vues
//        VuePion vuePionJ1 = new VuePion(j.getJoueurs().get(0).getPion(), this.panelPlateau);
//        vuePionJ1.getImageView().setImage(GestionnaireImage.getImage("PionRouge"));
//        vuePionJ1.miseAJour();
//
//        VuePion vuePionJ2 = new VuePion(j.getJoueurs().get(1).getPion(), this.panelPlateau);
//        vuePionJ2.getImageView().setImage(GestionnaireImage.getImage("PionJaune"));
//        vuePionJ2.miseAJour();
//
//        VuePion vuePionJ3 = new VuePion(j.getJoueurs().get(2).getPion(), this.panelPlateau);
//        vuePionJ3.getImageView().setImage(GestionnaireImage.getImage("PionBleu"));
//        vuePionJ3.miseAJour();

    }

    public PanelPlateau getPanelPlateau() {
        return this.panelPlateau;
    }

}
