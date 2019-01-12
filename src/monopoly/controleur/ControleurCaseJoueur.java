package monopoly.controleur;

import monopoly.modele.Pion;
import monopoly.vue.partieclassique.action.PanelCaseActuelle;

/**
 * Contrôleur gérant l'affichage de la case du joueur dans le panel "Case Actuelle".
 */
public class ControleurCaseJoueur {

    private Pion modele;
    private PanelCaseActuelle vue;

    public ControleurCaseJoueur(Pion pion, PanelCaseActuelle vue) {
        this.modele = pion;
        this.modele.setControleurCaseJoueur(this);
        this.vue = vue;
    }

    /**
     * Met à jour la case actuelle du joueur.
     */
    public void actualiserCase() {
        this.vue.actualiserCase(this.modele);
    }

}
