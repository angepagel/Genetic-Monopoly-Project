package monopoly.modele;

/**
 * Représente l'argent du joueur.
 */
public class Solde {
    /**
     * Argent possédé par le joueur.
     */
    private int monnaie;

    /**
     * Joueur qui possède ce solde.
     */
    private Joueur joueur;


    /**
     * Constructeur, initialise le joueur et le montant avec le montant initial.
     * @param joueur Joueur possédant ce solde.
     */
    public Solde(Joueur joueur)
    {
        monnaie = Jeu.getInstance().getMontantInitial();
        this.joueur = joueur;
    }

    /**
     * Récupère la quantité d'argent que le joueur possède.
     * @return Argent qu'il possède.
     */
    public int getMonnaie() {
        return monnaie;
    }

    /**
     * Permet de récupérer le joueur à qui appartient ce solde.
     * @return Joueur possédant le solde.
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Permet d'ajouter un montant au solde.
     * @param monnaie Montant à ajouter.
     */
    public void ajouter(int monnaie) {
        this.monnaie += monnaie;
        Jeu.getInstance().getControleurPanelJoueurs().actualiser();
    }

    /**
     * Permet d'ôter un montant du solde.
     * @param monnaie Montant à retirer.
     */
    public void payer(int monnaie) {
        this.monnaie -= monnaie;
        Jeu.getInstance().getControleurPanelJoueurs().actualiser();
    }

    /**
     * Permet au joueur de payer des impôts, qui seront reversés au parc gratuit.
     * @param monnaie Argent que le joueur doit payer aux impôts.
     */
    public void payerImpots(int monnaie) {
        payer(monnaie);
        Jeu.getInstance().addArgentParcGratuit(monnaie);
    }
}
