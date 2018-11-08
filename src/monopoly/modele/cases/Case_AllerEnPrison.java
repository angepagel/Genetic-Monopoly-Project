package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Case_AllerEnPrison extends Case {
    Case prison;
    public Case_AllerEnPrison(Case suivante, Case prison) {
        super("Allez en prison !", suivante);
        this.prison = prison;
    }

    @Override
    public void action(Joueur j) {
        j.getPion().setPosition(prison);
    }

    @Override
    public ECase getType() {
        return ECase.AllerEnPrison;
    }
}
