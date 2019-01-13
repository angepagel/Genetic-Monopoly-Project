package monopoly.modele;

import javafx.scene.paint.Color;
import monopoly.modele.cases.*;

import java.util.ArrayList;

public class Plateau {
    /**
     * Liste des cases du plateau.
     */
    private ArrayList<Case> listeCases;

    /**
     * Case départ.
     */
    private Case_Depart caseDepart;

    /**
     * Case prison.
     */
    private Case_Prison prison;

    /**
     * Créé le plateau.
     */
    public Plateau() {
        listeCases = new ArrayList<>();

        caseDepart = new Case_Depart(null);
        listeCases.add(caseDepart);

        CouleurTerrain bleuFinal = new CouleurTerrain(Color.web("0369B3"), 200);
        Case_Terrain rueDeLaPaix = new Case_Terrain("Rue de la paix", bleuFinal, new Tarifs(400,50,200,600,1400,1700,2000),caseDepart);
        listeCases.add(rueDeLaPaix);

        Case_Impots taxeDeLuxe = new Case_Impots("Taxe de luxe", 100, rueDeLaPaix);
        listeCases.add(taxeDeLuxe);

        Case_Terrain avenueCA = new Case_Terrain("Avenue des Champs-Élysées", bleuFinal, new Tarifs(350, 35, 175, 500, 1100, 1300, 1500), taxeDeLuxe);
        listeCases.add(avenueCA);

        Case_Chance c1 = new Case_Chance(avenueCA);
        listeCases.add(c1);

        Case_Gare saintLazare = new Case_Gare("Gare Saint-Lazare", c1);
        listeCases.add(saintLazare);

        CouleurTerrain vert = new CouleurTerrain(Color.web("1FA54C"), 200);
        Case_Terrain capucines = new Case_Terrain("Boulevard des Capucines", vert, new Tarifs(320,28, 150, 450, 1000, 1200, 1400), saintLazare);
        listeCases.add(capucines);

        Case_CaisseCommunaute cc1 = new Case_CaisseCommunaute(capucines);
        listeCases.add(cc1);

        Tarifs minVert = new Tarifs(300,26, 130, 390, 900, 1100, 1275);
        Case_Terrain foch = new Case_Terrain("Avenue Foch", vert, minVert, cc1);
        listeCases.add(foch);

        Case_Terrain breteuil = new Case_Terrain("Avenue de Breteuil", vert, minVert, foch);
        listeCases.add(breteuil);

        CouleurTerrain jaune = new CouleurTerrain(Color.web("FEED00"), 150);
        Case_Terrain laFayette = new Case_Terrain("Rue la Fayette", jaune, new Tarifs(280,24, 120, 360, 850, 1020,1200), null);
        listeCases.add(laFayette);

        Case_Compagnie compagnieEau = new Case_Compagnie("Compagnie de distribution des eaux", laFayette);
        listeCases.add(compagnieEau);

        Tarifs minJaune = new Tarifs(260,22,110,330,800,975,1150);
        Case_Terrain bourse = new Case_Terrain("Place de la Bourse", jaune, minJaune, compagnieEau);
        listeCases.add(bourse);

        Case_Terrain fsh = new Case_Terrain("Faubourg Saint-Honoré", jaune, minJaune, bourse);
        listeCases.add(fsh);

        Case_Gare gareDuNord = new Case_Gare("Gare du Nord" , fsh);
        listeCases.add(gareDuNord);

        CouleurTerrain rouge = new CouleurTerrain(Color.web("E3010F"), 150);
        Case_Terrain henriMartin = new Case_Terrain("Avenue Henri-Martin", rouge, new Tarifs(240,20,100,300,750,920,1100), gareDuNord);
        listeCases.add(henriMartin);

        Tarifs minRouge = new Tarifs(220,18,90,250,700,875,105);
        Case_Terrain malesherbes = new Case_Terrain("Boulevard Malesherbes", rouge, minRouge, henriMartin);
        listeCases.add(malesherbes);

        Case_Chance c2 = new Case_Chance(malesherbes);
        listeCases.add(c2);

        Case_Terrain matignon = new Case_Terrain("Avenue Matignon", rouge, minRouge, c2);
        listeCases.add(matignon);

        Case_ParcGratuit parc = new Case_ParcGratuit(matignon);
        listeCases.add(parc);

        CouleurTerrain orange = new CouleurTerrain(Color.web("F49102"), 100);
        Case_Terrain pigalle = new Case_Terrain("Place Pigalle", orange, new Tarifs(200,16,80,220,600,800,1000), parc);
        listeCases.add(pigalle);

        Tarifs minOrange = new Tarifs(180,14,70,200,550,750,950);
        Case_Terrain saintMichel = new Case_Terrain("Boulevard Saint-Michel", orange, minOrange, pigalle);
        listeCases.add(saintMichel);

        Case_CaisseCommunaute cc2 = new Case_CaisseCommunaute(saintMichel);
        listeCases.add(cc2);

        Case_Terrain mozart = new Case_Terrain("Avenue Mozart", orange, minOrange, cc2);
        listeCases.add(mozart);

        Case_Gare lyon = new Case_Gare("Gare de Lyon", mozart);
        listeCases.add(lyon);

        CouleurTerrain violet = new CouleurTerrain(Color.web("D72F87"), 100);
        Case_Terrain paradis = new Case_Terrain("Rue de Paradis", violet, new Tarifs(160, 12,60,180,500,700,900), lyon);
        listeCases.add(paradis);

        Tarifs minViolet = new Tarifs(140,10,50,150,450,625,750);
        Case_Terrain neuilly = new Case_Terrain("Avenue de Neuilly", violet, minViolet, paradis);
        listeCases.add(neuilly);

        Case_Compagnie electricite = new Case_Compagnie("Compagnie de distribution d'électricité", neuilly);
        listeCases.add(electricite);

        Case_Terrain vilette = new Case_Terrain("Boulevard de la Villette", violet, minViolet, electricite);
        listeCases.add(vilette);

        Case_VisitePrison vep = new Case_VisitePrison(vilette);
        listeCases.add(vep);
        prison = new Case_Prison(vep);
        listeCases.add(prison);
        Case_AllerEnPrison aep = new Case_AllerEnPrison(breteuil);
        listeCases.add(aep);

        laFayette.setSuivante(aep);

        CouleurTerrain bleuDebut = new CouleurTerrain(Color.web("BAE4FA"),50);
        Case_Terrain republique = new Case_Terrain("Avenue de la République", bleuDebut, new Tarifs(120,8,40,100,300,450,600), vep);
        listeCases.add(republique);

        Tarifs minBleu = new Tarifs(100,6,30,90,270,400,550);
        Case_Terrain courcelles = new Case_Terrain("Rue de Courcelles", bleuDebut, minBleu, republique);
        listeCases.add(courcelles);

        Case_Chance c3 = new Case_Chance(courcelles);
        listeCases.add(c3);

        Case_Terrain vaugirard = new Case_Terrain("Rue de Vaugirard",bleuDebut,minBleu,c3);
        listeCases.add(vaugirard);

        Case_Gare montparnasse = new Case_Gare("Gare Montparnasse", vaugirard);
        listeCases.add(montparnasse);

        Case_Impots revenu = new Case_Impots("Impôts sur le revenu",200, montparnasse);
        listeCases.add(revenu);

        CouleurTerrain marron = new CouleurTerrain(Color.web("944828"),50);
        Case_Terrain lecourbe = new Case_Terrain("Rue Lecourbe", marron, new Tarifs(60,4,20,60,180,320,450),revenu);
        listeCases.add(lecourbe);

        Case_CaisseCommunaute cc3 = new Case_CaisseCommunaute(lecourbe);
        listeCases.add(cc3);


        Case_Terrain belleville = new Case_Terrain("Boulevard de Belleville", marron, new Tarifs(60,2,10,30,90,160,250), cc3);
        listeCases.add(belleville);

        caseDepart.setSuivante(belleville);
    }

    /**
     * Permet de récupérer une case en fonction de son nom.
     * @param nom Nom de la case qu'on souhaite récupérer.
     * @return Case récupérée (ou null).
     */
    public Case getCase(String nom) {
        Case res = null;

        for(Case c : listeCases) {
            if (c.getId().equals(nom)) {
                res = c;
            }
        }

        return res;
    }

    /**
     * Permet de récupérer la prison.
     * @return Case prison.
     */
    public Case_Prison getPrison() {
        return prison;
    }

    /**
     * Permet de récupérer la case départ de la map.
     * @return Case départ
     */
    public Case_Depart getCaseDepart() {
        return caseDepart;
    }

    /**
     * Permet de récupérer la liste des cases.
     * @return La liste des cases du plateau
     */
    public ArrayList<Case> getListeCases() {
        return listeCases;
    }
}
