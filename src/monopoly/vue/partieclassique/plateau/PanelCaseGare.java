package monopoly.vue.partieclassique.plateau;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import monopoly.modele.Jeu;
import monopoly.modele.cases.Case_Gare;

public class PanelCaseGare extends PanelCase {

    private PanelCaseLabel nom;
    private ImageView image;
    private PanelCaseConteneurEmplacement emplacements;
    private Label prix;
    private Case_Gare modele;

    public PanelCaseGare(String nom) {

        this.modele = (Case_Gare) Jeu.getInstance().getPlateau().getCase(nom);

        this.nom = new PanelCaseLabel(this.modele.getNom().toUpperCase());
        this.image = new PanelCaseImage("");
        this.emplacements = new PanelCaseConteneurEmplacement();
        this.prix = new PanelCaseLabel("$Prix");

        this.getChildren().addAll(this.nom, this.image, this.emplacements, this.prix);

    }

}
