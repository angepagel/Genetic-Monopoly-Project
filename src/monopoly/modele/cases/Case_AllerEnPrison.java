package monopoly.modele.cases;

import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

public class Case_AllerEnPrison extends Case {
    public Case_AllerEnPrison(Case suivante) {
        super("Allez en prison !", suivante);
    }

    @Override
    public void action(Joueur j) {
        j.allerEnPrison();
        Jeu.getInstance().getControleurJeuMessage().afficherMessage("Prison", "Vous allez en prison...");
    }

    @Override
    public ECase getType() {
        return ECase.AllerEnPrison;
    }
}
