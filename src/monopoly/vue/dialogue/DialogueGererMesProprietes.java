package monopoly.vue.dialogue;

import monopoly.modele.Joueur;
import monopoly.vue.controleurFXML.ControleurGererMesProprietes;

import java.io.IOException;

public class DialogueGererMesProprietes extends Dialogue {

    public DialogueGererMesProprietes(Joueur j) throws IOException {
        super("Gérer mes propriétés", "dialogueGererMesProprietes.fxml");
        ControleurGererMesProprietes ctrl = (ControleurGererMesProprietes) this.getControleur();
        ctrl.setJoueur(j);
    }

}
