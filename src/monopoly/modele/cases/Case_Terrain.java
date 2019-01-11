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

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    @Override
    public void setHypotheque(boolean hypotheque) throws Exception {
        if(hypotheque && (nbMaisons > 0 || hotel))
        {
            throw new Exception("Il est impossible d'hypothéquer une propriété qui a une maison ou un hôtel.");
        }
        super.setHypotheque(hypotheque);
    }

    @Override
    public void abandonPropriete() {
        setNbMaisons(0);
        setHotel(false);

        super.abandonPropriete();
    }

    public CouleurTerrain getCouleur() {
        return couleur;
    }
}
