package monopoly.controleur;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;
import monopoly.modele.cartes.Carte_AmendeOuChance;

import java.util.Optional;

public class ControleurJeuMessage {

    public ControleurJeuMessage() {
        Jeu.getInstance().setControleurJeuMessage(this);
    }

    public void afficherMessage(String titre, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION, message);
        a.setHeaderText(null);
        a.setTitle(titre);
        a.show();
    }

    public void afficherMessage(String message) {
        afficherMessage("message", message);
    }

    public void demanderPaiementPioche(Carte_AmendeOuChance c, Joueur j) {
        boolean nonSorti;
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, c.getTexte());
        a.setHeaderText(null);
        a.setTitle("Carte à choix");
        ButtonType buttonTypeAmende = new ButtonType("Payer $" + c.getMontant());
        ButtonType buttonTypeChance = new ButtonType("Piocher une carte chance");
        do {
            nonSorti = false;
            a.getButtonTypes().setAll(buttonTypeAmende, buttonTypeChance);
            Optional<ButtonType> result = a.showAndWait();
            if(!result.isPresent()) {
                nonSorti = true;
            }
            else if(result.get() == buttonTypeAmende) {
                c.amende(j);
            }
            else if(result.get() == buttonTypeChance) {
                c.piocher(j);
            }
        }while(nonSorti);
    }
}
