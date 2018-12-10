package monopoly.vue.data.image;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;

public class GestionnaireImage {

    private static GestionnaireImage instance = null;

    private HashMap<String, Image> images;

    private GestionnaireImage() {
        this.images = new HashMap<>();

        this.addImage("Caisse", "Caisse.png");
        this.addImage("Electricite", "Electricite.png");
        this.addImage("CaseDepart", "CaseDepart.png");
        this.addImage("DistributionEaux", "DistributionEaux.png");
        this.addImage("Gare", "Train.png");
        this.addImage("Impots", "Impots.png");
        this.addImage("InterrogationBleue", "InterrogationBleue.png");
        this.addImage("InterrogationOrange", "InterrogationOrange.png");
        this.addImage("InterrogationRose", "InterrogationRose.png");
        this.addImage("Luxe", "Luxe.png");
    }

    private String getFolder() {
        return "file:src/monopoly/vue/data/image/";
    }

    private void addImage(String name, String address) {
        this.images.put(name, new Image(this.getFolder()+address));
    }

    public static Image getImage(String name) {
        return getInstance().images.get(name);
    }

    public static GestionnaireImage getInstance() {
        if (instance == null) {
            instance = new GestionnaireImage();
        }
        return instance;
    }

}
