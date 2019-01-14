package monopoly.vue.partieclassique.action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import monopoly.modele.Jeu;
import monopoly.vue.dialogue.DialogueEchanger;
import monopoly.vue.dialogue.DialogueGererMesProprietes;

import java.io.IOException;

public class PanelTourBoutons extends HBox {

    private Button gererProprietes;
    private Button echanger;

    public PanelTourBoutons() {

        this.gererProprietes = new Button("Gérer mes propriétés");
        this.gererProprietes.setAlignment(Pos.CENTER_LEFT);
        this.gererProprietes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new DialogueGererMesProprietes(Jeu.getInstance().getJoueurEnCours());
                }
                catch (IOException e) {
                    return;
                }
            }
        });

        this.echanger = new Button("Echanger");
        this.echanger.setAlignment(Pos.CENTER_RIGHT);
        this.echanger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new DialogueEchanger(Jeu.getInstance().getJoueurEnCours());
                }
                catch (IOException e) {
                    return;
                }
            }
        });

        this.getChildren().addAll(
                this.gererProprietes,
                this.echanger
        );

    }

}
