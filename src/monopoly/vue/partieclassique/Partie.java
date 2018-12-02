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
import monopoly.vue.partieclassique.action.PanelAction;
import monopoly.vue.partieclassique.plateau.PanelPlateau;

import java.io.IOException;

public class Partie {

    public Partie() throws IOException {
        HBox root = new HBox();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        // Init components
        root.getChildren().add(new PanelPlateau());
        root.getChildren().add(new PanelAction());

        root.setPrefSize(1080,700);

        stage.setTitle("Partie Classique");
        stage.getIcons().add(new Image("file:src/monopoly/vue/data/image/Icone.png"));
        stage.setScene(scene);
        stage.show();
    }

}
