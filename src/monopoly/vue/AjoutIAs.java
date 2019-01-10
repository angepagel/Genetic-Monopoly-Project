package monopoly.vue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AjoutIAs {

    public AjoutIAs() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutIAs.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Ajout des IAs");
        stage.getIcons().add(new Image("file:src/monopoly/vue/data/image/Icone.png"));
        stage.setScene(scene);
        stage.show();
    }
}
