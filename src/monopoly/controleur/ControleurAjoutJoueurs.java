package monopoly.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import monopoly.vue.partieclassique.Partie;
import java.io.IOException;

public class ControleurAjoutJoueurs {

    @FXML private TextField textFieldNom;
    @FXML private ComboBox comboPions;
    @FXML private Button boutonAjouter;
    @FXML private TableView tableauJoueurs;
    @FXML private TableColumn colNom;
    @FXML private TableColumn colPion;
    @FXML private Button boutonRetirer;
    @FXML private Button boutonLancerPartie;

    /*
    Il est important de tenir compte des informations suivantes pour coder ce contrôleur:
        - On ne peut pas avoir plus de 8 joueurs dans la partie;
        - Une partie doit comporter au moins 2 joueurs;
        - Pour ajouter un joueur, le textFieldNom ne doit pas être vide;
        - Éventuellement, deux joueurs ne peuvent pas avoir le même nom ?
        - Éventuellement, les couleurs disponibles dans le comboPion sont gérées dynamiquement, compte tenu des
          couleurs déjà prises ?
     */

    @FXML
    public void ajouterJoueur() {
        // TODO : Ajouter un joueur dans le tableauJoueurs avec les informations du textFieldNom et du comboPions
    }

    @FXML
    public void retirerJoueur() {
        // TODO : Retirer un joueur du tableauJoueurs
    }

    @FXML
    public void lancerPartie() throws IOException {
        // TODO : Créer les joueurs de la partie à partir du tableauJoueurs (colNom & colPion)
        new Partie();
    }

}
