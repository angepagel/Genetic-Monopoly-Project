package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import monopoly.modele.Jeu;
import monopoly.modele.cases.Case;
import monopoly.modele.cases.Case_Terrain;

/**
 * Created by maxim on 23/11/2018.
 */
public class PanelCaseTerrain extends PanelCase {

    private PanelCaseHeader header;
    private Label nom;
    private PanelCaseConteneurEmplacement emplacements;
    private Label prix;

    private Case_Terrain modele;

    public PanelCaseTerrain(String nom) {

        this.modele = (Case_Terrain) Jeu.getInstance().getPlateau().getCase(nom);

        // Component properties
        this.header = new PanelCaseHeader(this.modele.getCouleur().getCouleur());
        this.nom = new PanelCaseLabel(this.modele.getNom().toUpperCase());
        this.emplacements = new PanelCaseConteneurEmplacement();
        this.prix = new PanelCaseLabel("$Prix");
        this.prix.setPadding(new Insets(10,0,0,0));

        this.getChildren().addAll(this.header, this.nom, this.emplacements, this.prix);

    }

}
