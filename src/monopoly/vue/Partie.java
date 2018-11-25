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

import java.io.IOException;

public class Partie {
    
    public void start() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("partie.fxml"));
        primaryStage.setTitle("Monopoly Génétique");
        primaryStage.getIcons().add(new Image("file:src/monopoly/vue/data/image/Icone.png"));
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.setResizable(false);
        primaryStage.showAndWait();
    } 
}
