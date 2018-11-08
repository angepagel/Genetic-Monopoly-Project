package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Case_Depart extends Case {
    public Case_Depart(Case suivante) {
        super("Départ", suivante);
    }

    @Override
    public void action(Joueur j) {
        // Rien, ce n'est pas ici qu'on vérifie si le joueur passe par cette case
    }

    @Override
    public ECase getType() {
        return ECase.Depart;
    }
}
