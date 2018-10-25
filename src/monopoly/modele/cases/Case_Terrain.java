package monopoly.modele.cases;

public class Case_Terrain extends Case_Achat {
    private int nbMaisons;
    private int prixMaison;
    private boolean hotel;
    private CouleurTerrain couleur;

    public Case_Terrain(String nom, CouleurTerrain couleur, int prixMaison, Case suivante) {
        super(nom, suivante);
        this.couleur = couleur;
        this.prixMaison = prixMaison;
        hotel = false;
        nbMaisons = 0;
    }

    @Override
    public int getLoyer() {
        return 0;
    }

    @Override
    public int getPrix() {
        return 0;
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
