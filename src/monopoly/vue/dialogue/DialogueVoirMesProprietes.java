package monopoly.vue.dialogue;

import monopoly.modele.Jeu;
import monopoly.vue.controleurFXML.ControleurVoirMesProprietes;

import java.io.IOException;

public class DialogueVoirMesProprietes extends Dialogue {

    public DialogueVoirMesProprietes() throws IOException {
        super("Voir mes propriétés", "dialogueVoirMesProprietes.fxml");
        ControleurVoirMesProprietes ctrl = (ControleurVoirMesProprietes) this.getControleur();
        ctrl.setJoueur(Jeu.getInstance().getJoueurEnCours());
    }

}