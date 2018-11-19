package monopoly.modele.cases;

public class Case_Terrain extends Case_Achat {
    private int nbMaisons;
    private boolean hotel;
    private CouleurTerrain couleur;
    private Tarifs tarifs;

    public Case_Terrain(String nom, CouleurTerrain couleur, Tarifs tarifs, Case suivante) {
        super(nom, suivante);
        this.couleur = couleur;
        couleur.ajouterPropriete(this);
        this.tarifs = tarifs;
        hotel = false;
        nbMaisons = 0;
    }

    @Override
    public Integer getLoyer() {
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
        return tarifs.getPrixAchat();
    }

    @Override
    public ECase getType() {
        return ECase.Terrain;
    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public int getPrixMaison() {
        return couleur.getPrixMaison();
    }

    public boolean isHotel() {
        return hotel;
    }

    public CouleurTerrain getCouleur() {
        return couleur;
    }
}
