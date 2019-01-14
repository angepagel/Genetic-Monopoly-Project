package monopoly.vue.dialogue;

import monopoly.modele.Joueur;
import monopoly.vue.controleurFXML.ControleurEchanger;

import java.io.IOException;

public class DialogueEchanger extends Dialogue {

    public DialogueEchanger(Joueur j) throws IOException {
        super("Échanger", "dialogueEchanger.fxml");
        ControleurEchanger ctrl = (ControleurEchanger) this.getControleur();
        ctrl.setJoueur(j);
    }

}
