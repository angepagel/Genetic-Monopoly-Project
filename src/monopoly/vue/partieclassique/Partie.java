/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.vue.partieclassique;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import monopoly.controleur.ControleurPlateau;
import monopoly.modele.Humain;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.Pion;
import monopoly.vue.IVuePartie;
import monopoly.vue.partieclassique.action.PanelAction;
import monopoly.vue.partieclassique.action.VuePion;
import monopoly.vue.partieclassique.plateau.PanelPlateau;

import java.io.IOException;

public class Partie implements IVuePartie {

    private HBox root;
    private ControleurPlateau controleurPlateau;

    private PanelPlateau panelPlateau;
    private PanelAction panelAction;

    public Partie() throws IOException {

        root = new HBox();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        // Init components
        this.panelPlateau = new PanelPlateau();
        this.panelAction = new PanelAction();

        root.getChildren().add(panelPlateau);
        root.getChildren().add(panelAction);

        root.setPrefSize(1080,700);

        stage.setTitle("Partie Classique");
        stage.getIcons().add(new Image("file:src/monopoly/vue/data/image/Icone.png"));
        stage.setScene(scene);
        stage.show();


        // Initialisation de la partie (a déplacer ?)
        Jeu j = Jeu.getInstance();
        //j.initialisation();

        Joueur j1 = new Humain("Yan");
        j.getJoueurs().add(j1);
        j1.choisirPion(new Pion("Canon"));
        VuePion vuePionJ1 = new VuePion(j.getJoueurs().get(2).getPion(), this.panelPlateau);
        vuePionJ1.miseAJour();

        Joueur j2 = new Humain("Ange");
        j.getJoueurs().add(j2);
        j2.choisirPion(new Pion("Cheval"));
        VuePion vuePionJ2 = new VuePion(j.getJoueurs().get(3).getPion(), this.panelPlateau);
        vuePionJ2.miseAJour();

        j.setJoueurEnCours(j1);

        // La case prison ne possède pas de panel, il y a donc un plantage quand on tombe dessus


        // Instanciation de controleurs
        this.controleurPlateau = new ControleurPlateau(panelPlateau);

    }

    public PanelPlateau getPanelPlateau() {
        return this.panelPlateau;
    }

}
