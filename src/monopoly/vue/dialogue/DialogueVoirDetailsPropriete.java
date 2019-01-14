package monopoly.vue.dialogue;

import monopoly.modele.cases.Case_Achat;
import monopoly.vue.controleurFXML.ControleurVoirDetailsPropriete;
import monopoly.modele.cases.Case_Terrain;

import java.io.IOException;

public class DialogueVoirDetailsPropriete extends Dialogue {

    public DialogueVoirDetailsPropriete(Case_Achat c) throws IOException {
        super("Détails de la propriété", "dialogueVoirDetailsPropriete.fxml");
        ControleurVoirDetailsPropriete ctrl = (ControleurVoirDetailsPropriete) this.getControleur();
        ctrl.setCase(c);
    }

    public DialogueVoirDetailsPropriete() throws IOException {
        super("Détails de la propriété", "dialogueVoirDetailsPropriete.fxml");
    }

}
