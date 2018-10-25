package monopoly.modele;

public class Solde {
    private int monnaie;
    private Joueur joueur;

    public Solde(Joueur joueur)
    {
        monnaie = Jeu.getInstance().getMontantInitial();
        this.joueur = joueur;
    }

    public int getMonnaie() {
        return monnaie;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void ajouter(int monnaie) {
        this.monnaie += monnaie;
    }

    public void payer(int monnaie) {
        this.monnaie -= monnaie;
    }
}
