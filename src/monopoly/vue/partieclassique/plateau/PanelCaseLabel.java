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
        this.setPrefWidth(58);
        this.setPrefHeight(16);
        this.setText(text);
        this.setFont(new Font("System", 8));
        this.setAlignment(Pos.CENTER);
        this.setTextAlignment(TextAlignment.CENTER);

    }

    public PanelCaseLabel() {
        this("");
    }



}
