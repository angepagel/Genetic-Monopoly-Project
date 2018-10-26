package monopoly.modele.cases;

public class Case_Terrain extends Case_Achat {
    private int nbMaisons;
    private int prix;
    private int prixMaison;
    private boolean hotel;
    private CouleurTerrain couleur;
    private PrixLocation tarifs;

    public Case_Terrain(String nom, CouleurTerrain couleur, int prix, int prixMaison, PrixLocation tarifs, Case suivante) {
        super(nom, suivante);
        this.couleur = couleur;
        this.prixMaison = prixMaison;
        this.tarifs = tarifs;
        this.prix = prix;
        hotel = false;
        nbMaisons = 0;
    }

    @Override
    public int getLoyer() {
        int loyer = tarifs.getPrixTerrainNu();
        if(nbMaisons == 0 && couleur.aUnProprietaire()) {
            loyer *= 2;
        }
        else if(!hotel) {
            loyer = tarifs.getPrixMaison(nbMaisons);
        }
        else {
            loyer = tarifs.getPrixHotel();
        }

        return loyer;
    }

    @Override
    public int getPrix() {
        return prix;
    }

    @Override
    public ECase getType() {
        return ECase.Terrain;
    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public int getPrixMaison() {
        return prixMaison;
    }

    public boolean isHotel() {
        return hotel;
    }

    public CouleurTerrain getCouleur() {
        return couleur;
    }
}
