package monopoly.vue.partieclassique.action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import monopoly.controleur.ControleurDe;
import monopoly.controleur.ControleurJoueurs;
import monopoly.modele.Jeu;
import monopoly.vue.data.image.GestionnaireImage;

public class PanelTirageDes extends Pane {

    private ImageView de_1;
    private ImageView de_2;
    private VueDes vueDes;
    private Button lancerDes;

    private ControleurDe controleurDe;
    private ControleurJoueurs controleurJoueurs;

    public PanelTirageDes() {
        PanelTirageDes self = this;



        // Image dés
        this.de_1 = new ImageView(GestionnaireImage.getImage("De_4"));
        this.de_2 = new ImageView(GestionnaireImage.getImage("De_3"));
        this.vueDes = new VueDes(Jeu.getInstance().getDes(), de_1, de_2);

        this.de_1.setFitWidth(30);
        this.de_1.setFitHeight(30);
        this.de_2.setFitWidth(30);
        this.de_2.setFitHeight(30);

        this.de_1.setX(140);
        this.de_2.setX(180);

        // Instanciation des contrôleurs
        this.controleurDe = new ControleurDe(this.vueDes);
        this.controleurJoueurs = new ControleurJoueurs();

        // Bouton de lancer des dés
        this.lancerDes = new Button("Lancer de dés");
        //this.lancerDes.setOnAction(new EventLancerDes());
        this.lancerDes.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                self.controleurDe.lancerDes();
                self.controleurJoueurs.deplacer();
            }

        });


        this.getChildren().addAll(
                lancerDes,
                de_1,
                de_2
        );

    }


}
