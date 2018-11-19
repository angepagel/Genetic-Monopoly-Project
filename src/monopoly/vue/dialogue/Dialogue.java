package monopoly.vue.dialogue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dialogue {

    public Dialogue(String fichierFxml) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fichierFxml));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
