package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Case_CaisseCommunaute extends Case {

    public Case_CaisseCommunaute(Case suivante) {
        super("Caisse de communauté", suivante);
    }

    @Override
    public void action(Joueur j) {
        // TODO : Piocher une carte Caisse de communauté
    }

    @Override
    public ECase getType() {
        return ECase.CaisseCommunaute;
    }
}
