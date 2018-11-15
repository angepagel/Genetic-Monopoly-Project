package monopoly.vue;

import java.awt.Image;
import monopoly.controleur.Controleur;

public abstract  class Vue {
    private Image image;
    private Controleur controleur;
    
    public Vue(IHM p,Controleur controleur){
        
    }
    
    public abstract void MiseAJour();
    
 
    
    /*public Modele getModel(){
        
    }*/
    
    public void setImage(Image image){
        this.image = image;
        
    }
    
    public Controleur getControleur(){
        return controleur;
    }

}
