package monopoly.controleur;

import javafx.scene.control.Alert;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cases.Case_Achat;
import monopoly.vue.partieclassique.action.PanelCaseActuelle;

public class ControleurPanelCaseActuelle {

    private PanelCaseActuelle vue;

    public ControleurPanelCaseActuelle(PanelCaseActuelle v) {
        this.vue = v;
    }

    /**
     * Gère l'action effectuée par le bouton Acheter.
     * Le bouton permet d'acheter une propriété.
     */
    public void acheter() {
        Joueur joueurCourant = Jeu.getInstance().getJoueurEnCours();

        try {
            Case_Achat caseCourante = (Case_Achat) joueurCourant.getPion().getPosition();
            joueurCourant.acheterCase(caseCourante);
            new Alert(Alert.AlertType.INFORMATION, "La case " + caseCourante.getNom() + " est achetée par " + joueurCourant.getNom() + " au prix de $" + caseCourante.getPrix()+ ".").show();
        }
        catch (ClassCastException e)
        {
            new Alert(Alert.AlertType.WARNING, "Cette case ne peut pas être achetée.").show();
        }
        catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
    }

    /**
     * Gère l'action effectuée par le bouton Enchérir.
     * Le bouton permet d'enchérir sur l'achat d'une propriété.
     */
    public void encherir() {
        // TODO : Gérer les enchères
    }

}
