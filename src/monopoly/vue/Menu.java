/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.vue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import monopoly.modele.Jeu;

import java.io.IOException;

import static monopoly.modele.Jeu.getInstance;

public class Menu {

    public Menu(String titre, String fichierFxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fichierFxml));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle(titre);
        stage.getIcons().add(new Image("file:src/monopoly/vue/data/image/Icone.png"));
        stage.setScene(scene);
        stage.show();
    }

}
