/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author snake
 */
public class JoueurTemp {
    
    
    private StringProperty pion;
    private StringProperty nomJoueur;
    
    public JoueurTemp(String pion,String nomJoueur){
        this.nomJoueur= new SimpleStringProperty(nomJoueur);
        this.pion= new SimpleStringProperty(pion);
        
        
    }
    
    public String getNomJoueur(){
        return this.nomJoueur.get();
    }
    
    public String getPion(){
        return this.pion.get();
    }
}
