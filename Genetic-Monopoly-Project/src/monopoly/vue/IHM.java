/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.vue;

import java.awt.Image;
import java.util.ArrayList;
import javafx.scene.Parent;

/**
 *
 * @author rg686289
 */
public class IHM extends Parent {
    
    private ArrayList<Vue> listeVues;
    
    public IHM(){
        listeVues = new ArrayList<Vue>();
        
    }
    
   /* public Main getMonopoly(){
        
    }*/
    
    public void AjouteVue(Vue v){
        listeVues.add(v);
    }
    
    public void supprimeVue(Vue v){
        listeVues.remove(v);
    }
    
    public ArrayList<Vue> getListeVues(){
        return listeVues;
    }  
    
    
}
