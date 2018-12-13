package monopoly.controleur;

import javafx.scene.control.Button;
import monopoly.modele.Jeu;

public class ControleurTerminerTour {

    private Jeu modele;

    public ControleurTerminerTour() {
        this.modele = Jeu.getInstance();
    }

    public void terminerTour() {
        this.modele.prochainJoueur();
    }

}
