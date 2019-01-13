package monopoly.modele.cartes;

import monopoly.modele.Joueur;

public class Carte_ReculerCases extends Carte {
    private int nbCases;

    public Carte_ReculerCases(String texte, int nbCases) {
        super(texte);
        this.nbCases = nbCases;
    }

    public Carte_ReculerCases(int nbCases) {
        super("Reculez de " + nbCases + ((nbCases > 1) ? " cases" : " case") + ".");
        this.nbCases = nbCases;
    }

    @Override
    public void action(Joueur j) {
        j.getPion().reculer(nbCases);
    }
}
