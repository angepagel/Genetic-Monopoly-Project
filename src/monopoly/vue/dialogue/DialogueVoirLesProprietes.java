package monopoly.vue.dialogue;

import monopoly.modele.cases.Case_Achat;

import java.io.IOException;

public class DialogueVoirLesProprietes extends Dialogue {

    private Case_Achat caseAchat;

    public DialogueVoirLesProprietes() throws IOException {
        super("Voir les propriétés", "DialogueVoirLesProprietes.fxml");
    }

}
