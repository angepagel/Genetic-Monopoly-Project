package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Case_Prison extends Case {
    Case sortie;

    public Case_Prison(Case sortie) {
        super("Prison", null);

        this.sortie = sortie;
        setSuivante(this);
    }

    @Override
    public void action(Joueur j) {

    }

    @Override
    public ECase getType() {
        return ECase.Prison;
    }

    public void sortir(Joueur j) {
        j.getPion().setPosition(this.sortie);
    }
}
