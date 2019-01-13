package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

public abstract class Case_Achat extends Case_Paiement {
    private Joueur proprietaire;
    private boolean hypotheque;

    public Case_Achat(String nom, Case suivante) {
        super(nom, suivante);
        hypotheque = false;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * La propriété est abandonnée par son possesseur, parce qu'il fait faillite.
     */
    public void abandonPropriete() {
        setHypothequeSansVerif(false);
        setProprietaire(null);
    }

    public void payerLoyer(Joueur joueur) {
        if(proprietaire == null) {
            return;
        }
        if(isHypotheque()) {
            return;
        }

        joueur.getSolde().payer(getLoyer());
        proprietaire.getSolde().ajouter(getLoyer());
        Jeu.getInstance().getControleurJeuMessage().afficherMessage(joueur.getNom() + " est tombé sur la case " + this.getNom() + " qui est la propriété de " + proprietaire.getNom() + ", et lui a versé $" + this.getLoyer() + ".");
    }

    public abstract Integer getLoyer();

    /**
     * Permet de savoir si la case est hypothéquée.
     * @return Valeur de l'hypothèque.
     */
    public boolean isHypotheque() {
        return hypotheque;
    }

    /**
     * Permet de changer le statut de l'hypothèque.
     * @param hypotheque Vrai si la case doit être hypothéquée, faux sinon.
     * @throws Exception Si la propriété a une maison, ou pas de propriétaire.
     */
    public void setHypotheque(boolean hypotheque)
    throws Exception{
        if(hypotheque && proprietaire == null) {
            throw new Exception("Une case a besoin d'un propriétaire pour être hypothéquée.");
        }
        setHypothequeSansVerif(hypotheque);
    }

    private void setHypothequeSansVerif(boolean hypotheque) {
        this.hypotheque = hypotheque;
    }

    @Override
    public void action(Joueur j) {
        if(proprietaire != null && proprietaire != j) {
            payerLoyer(j);
        }
    }

    public Integer getValeurHypotheque() {
        return getPrix()/2;
    }
}
