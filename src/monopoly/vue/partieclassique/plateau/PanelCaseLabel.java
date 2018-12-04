package monopoly.vue.partieclassique.plateau;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Created by maxim on 03/12/2018.
 */
public class PanelCaseLabel extends Label {

    public PanelCaseLabel(String text) {

        // Paramètres du label de prix
        this.setPrefWidth(54);
        this.setPrefHeight(32);
        this.setText(text);
        this.setFont(new Font("System", 8));
        this.setAlignment(Pos.TOP_CENTER);
        this.setTextAlignment(TextAlignment.CENTER);
        this.setWrapText(true);

    }

    public PanelCaseLabel() {
        this("");
    }

}
