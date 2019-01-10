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

        this.addImage("De_1", "dice_1.png");
        this.addImage("De_2", "dice_2.png");
        this.addImage("De_3", "dice_3.png");
        this.addImage("De_4", "dice_4.png");
        this.addImage("De_5", "dice_5.png");
        this.addImage("De_6", "dice_6.png");

        this.addImage("CaseDepart", "CaseDepart.png");
        this.addImage("CaseParcGratuit", "CaseParcGratuit.png");
        this.addImage("CaseVisite", "CaseVisite.png");
        this.addImage("CaseAllezEnPrison", "CaseAllezEnPrison.png");

        this.addImage("PionRouge", "PionRouge.png");
        this.addImage("PionJaune", "PionJaune.png");
        this.addImage("PionBleu", "PionBleu.png");
        this.addImage("PionVert", "PionVert.png");
        this.addImage("PionCyan", "PionCyan.png");
        this.addImage("PionOrange", "PionOrange.png");
        this.addImage("PionViolet", "PionViolet.png");
        this.addImage("PionRose", "PionRose.png");

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
