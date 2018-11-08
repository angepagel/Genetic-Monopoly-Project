package monopoly.modele;

import javafx.scene.paint.Color;
import monopoly.modele.cases.*;

import java.util.ArrayList;

public class Plateau {
    private ArrayList<Case> listeCases;
    private Case_Depart caseDepart;
    public Plateau() {
        listeCases = new ArrayList<>();

        caseDepart = new Case_Depart(null);
        listeCases.add(caseDepart);

        CouleurTerrain bleuFinal = new CouleurTerrain(Color.BLUE, 200);
        Case_Terrain rueDeLaPaix = new Case_Terrain("Rue de la paix", bleuFinal, new Tarifs(400,50,200,600,1400,1700,2000),caseDepart);
        listeCases.add(rueDeLaPaix);

        Case_Impots taxeDeLuxe = new Case_Impots("Taxe de luxe", 100, rueDeLaPaix);
        listeCases.add(rueDeLaPaix);

        Case_Terrain avenueCA = new Case_Terrain("Avenue des Champs-Élysées", bleuFinal, new Tarifs(350, 35, 175, 500, 1100, 1300, 1500), taxeDeLuxe);
        listeCases.add(avenueCA);

        Case_Chance c1 = new Case_Chance(avenueCA);
        listeCases.add(c1);

        Case_Gare saintLazare = new Case_Gare("Gare Saint-Lazare", c1);
        listeCases.add(saintLazare);

        CouleurTerrain vert = new CouleurTerrain(Color.GREEN, 200);
        Case_Terrain capucines = new Case_Terrain("Boulevard des Capucines", vert, new Tarifs(320,28, 150, 450, 1000, 1200, 1400), saintLazare);
        listeCases.add(capucines);

        Case_CaisseCommunaute cc1 = new Case_CaisseCommunaute(capucines);
        listeCases.add(cc1);

        Tarifs minVert = new Tarifs(300,26, 130, 390, 900, 1100, 1275);
        Case_Terrain foch = new Case_Terrain("Avenue Foch", vert, minVert, cc1);
        listeCases.add(foch);

        Case_Terrain breteuil = new Case_Terrain("Avenue de Breteuil", vert, minVert, foch);
        listeCases.add(breteuil);
    }

    public Case_Depart getCaseDepart() {
        return caseDepart;
    }
}
