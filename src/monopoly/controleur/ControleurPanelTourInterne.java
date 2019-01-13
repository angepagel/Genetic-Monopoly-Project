package monopoly.controleur;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import monopoly.modele.Jeu;

/**
 * Contrôleur gérant le panel de tour interne.
 */
public class ControleurPanelTourInterne {

    private Jeu modele;

    public ControleurPanelTourInterne() {
        this.modele = Jeu.getInstance();
    }

    public void terminerTour() {
        if(Jeu.getInstance().getJoueurEnCours().aDejaJoue()){
            this.modele.prochainJoueur();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "C'est à " + Jeu.getInstance().getJoueurEnCours().getNom() + " de jouer !");
            alert.setHeaderText("Changement de tour : " + Jeu.getInstance().getJoueurEnCours().getNom());
            alert.setTitle("Changement de tour");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Votre tour n'est pas terminé.");
            alert.setHeaderText("Changement de tour : " + Jeu.getInstance().getJoueurEnCours().getNom());
            alert.setTitle("Changement de tour");
            alert.show();
        }
    }

}
