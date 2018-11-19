package monopoly.vue.dialogue;

import monopoly.modele.cases.Case_Achat;

import java.io.IOException;

public class DialogueVoirDetailsPropriete extends Dialogue {

    private Case_Achat caseAchat;

    public DialogueVoirDetailsPropriete() throws IOException {
        super("Détails de la propriété", "dialogueVoirDetailsPropriete.fxml");
    }

    public DialogueVoirDetailsPropriete(Case_Achat c) throws IOException {
        super("Détails de la propriété", "dialogueVoirDetailsPropriete.fxml");
        this.caseAchat = c;

        this.getControleur().update(c);

    }

}
