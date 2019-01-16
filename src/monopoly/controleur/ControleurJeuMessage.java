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

    public void demanderSortiePrison(Joueur j) {
        boolean nonSorti;
        j.incToursEnPrison();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "C'est le " + j.getToursEnPrison() + "° tour que vous passez en prison. Souhaitez-vous payer pour en sortir ?");
        a.setHeaderText(null);
        a.setTitle("Sortir de prison");
        ButtonType buttonRester = new ButtonType("Rester en prison");
        ButtonType buttonPayer = new ButtonType("Payer $50");
        ButtonType buttonCarteChance = new ButtonType("Carte chance");
        ButtonType buttonCarteCaisse = new ButtonType("Carte caisse de communauté");
        do {
            nonSorti = false;
            a.getButtonTypes().setAll();
            if(j.getToursEnPrison() < 3) {
                a.getButtonTypes().add(buttonRester);
            }
            a.getButtonTypes().add(buttonPayer);
            if(j.aSortiePrisonChance()) {
                a.getButtonTypes().add(buttonCarteChance);
            }
            if(j.aSortiePrisonCaisse()) {
                a.getButtonTypes().add(buttonCarteCaisse);
            }
            Optional<ButtonType> result = a.showAndWait();
            if(!result.isPresent()) {
                nonSorti = true;
            }
            else if(result.get() == buttonRester) {
                j.resterEnPrison();
            }
            else if(result.get() == buttonPayer) {
                j.payerPrison();
            }
            else if(result.get() == buttonCarteChance) {
                j.sortirPrisonChance();
            }
            else if(result.get() == buttonCarteCaisse) {
                j.sortirPrisonCaisse();
            }
        } while(nonSorti);
    }
}
