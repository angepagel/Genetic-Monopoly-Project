package monopoly.modele.cases;

import monopoly.modele.Jeu;

public class Case_Terrain extends Case_Achat {
    private int nbMaisons;
    private CouleurTerrain couleur;
    private Tarifs tarifs;

    public Case_Terrain(String nom, CouleurTerrain couleur, Tarifs tarifs, Case suivante) {
        super(nom, suivante);
        this.couleur = couleur;
        couleur.ajouterPropriete(this);
        this.tarifs = tarifs;
        nbMaisons = 0;
    }

    @Override
    public Integer getLoyer() {
        int loyer = tarifs.getPrixTerrainNu();
        if(nbMaisons == 0 && couleur.aUnProprietaire()) {
            loyer *= 2;
        }
        else if(nbMaisons > Jeu.getInstance().getNbMaxMaisons()) {
            loyer = tarifs.getPrixHotel();
        }
        else {
            loyer = tarifs.getPrixMaison(nbMaisons);
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
        return nbMaisons > Jeu.getInstance().getNbMaxMaisons();
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public void ameliorer() throws Exception {
        if(!couleur.aUnProprietaire()) {
            throw new Exception("Vous devez posséder toutes les propriétés d'un groupe pour pouvoir construire.");
        }
        int nbMaisons = getNbMaisons() + 1;
        int max = Jeu.getInstance().getNbMaxMaisons() + 1;
        if(nbMaisons > max) {
            throw new Exception("Le niveau d'amélioration maximal est déjà atteint.");
        }
        if(isHypotheque()) {
            throw new Exception("Vous ne pouvez pas construire sur une propriété déjà hypothéquée.");
        }
        if(nbMaisons > couleur.getMaxMaisonsConstruction()) {
            throw new Exception("Vous devez construire un nombre égal de maisons dans chaque propriété avant de pouvoir passer au pallier suivant.");
        }
        this.setNbMaisons(nbMaisons);
    }

    public void vendreAmelioration() throws Exception {
        int newNbMaisons = getNbMaisons()-1;
        if(newNbMaisons < couleur.getMinMaisons()) {
            throw new Exception("Vous devez vendre des maisons sur d'autres propriétés de ce groupe avant de pouvoir passer au pallier en dessous.");
        }

        this.setNbMaisons(nbMaisons);
    }

    @Override
    public void setHypotheque(boolean hypotheque) throws Exception {
        if(hypotheque && (nbMaisons > 0))
        {
            throw new Exception("Il est impossible d'hypothéquer une propriété qui a une maison ou un hôtel.");
        }
        super.setHypotheque(hypotheque);
    }

    @Override
    public void abandonPropriete() {
        setNbMaisons(0);

        super.abandonPropriete();
    }

    public CouleurTerrain getCouleur() {
        return couleur;
    }
}
