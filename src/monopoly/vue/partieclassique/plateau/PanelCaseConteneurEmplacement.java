package monopoly.vue.partieclassique.plateau;

import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import monopoly.vue.data.image.GestionnaireImage;
import monopoly.vue.partieclassique.action.VuePion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by maxim on 03/12/2018.
 */
public class PanelCaseConteneurEmplacement extends FlowPane {

    private ImageView emplacementJoueur_1;
    private ImageView emplacementJoueur_2;
    private ImageView emplacementJoueur_3;
    private ImageView emplacementJoueur_4;
    private ImageView emplacementJoueur_5;
    private ImageView emplacementJoueur_6;
    private ImageView emplacementJoueur_7;
    private ImageView emplacementJoueur_8;

    private ArrayList<PanelCaseEmplacementJoueur> listeEmplacements;

    public PanelCaseConteneurEmplacement() {
        // TODO : Ajouter des getters et setters dans le futur, ou convertir ces attributs en un tableau

        this.setPrefSize(56,28);
        this.setMaxSize(56,28);
        this.setMinSize(56,28);

        // Init liste
        this.listeEmplacements = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            this.listeEmplacements.add(new PanelCaseEmplacementJoueur());
            this.getChildren().add(this.listeEmplacements.get(i));
        }

    }

    public void insererPion(VuePion vuePion) {

        ArrayList<PanelCaseEmplacementJoueur> emplacementsLibres = new ArrayList<>();

        // On constitue la liste des emplacements libres
        for (int i = 0; i <= 7; i++) {
            if (!this.listeEmplacements.get(i).estOccupe()) {
                emplacementsLibres.add(this.listeEmplacements.get(i));
            }
        }


        // Aléatoire
        Collections.shuffle(emplacementsLibres);
        emplacementsLibres.get(0).ajouterPion(vuePion);

    }

    public void enleverPion(VuePion vuePion) {

        for (int i = 0; i <= 7; i++) {
            if (this.listeEmplacements.get(i).pionIdentique(vuePion)) {
                this.listeEmplacements.get(i).vider();
            }
        }

    }



}
