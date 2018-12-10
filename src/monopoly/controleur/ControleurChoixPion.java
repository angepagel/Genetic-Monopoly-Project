package monopoly.controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import monopoly.modele.Pion;

import java.util.ArrayList;
import java.util.Observable;
import static monopoly.modele.EJoueur.IA;
import monopoly.modele.Humain;
import monopoly.modele.Jeu;
import monopoly.modele.Joueur;

public class ControleurChoixPion {

    private ObservableList<Pion> listePions;
    private ArrayList<Joueur> joueurs;
    private Jeu j;
    public ControleurChoixPion(){
        j= Jeu.getInstance();
        joueurs= j.getJoueurs();
    }

    public void InitPion() {
        j.initialisation();
        Pion cheval = new Pion("cheval");
        Pion DeAcoudre = new Pion("DeAcoudre");
        Pion bateau = new Pion("bateau");
        Pion canon = new Pion("canon");
        listePions = FXCollections.observableArrayList(cheval, DeAcoudre, bateau,canon);
    }

    public ObservableList<Pion> getListePions(){
        return listePions;
    }
    
    
    

    public void setPionJoueurs(Pion PjoueurOne, Pion PjoueurTwo) {
        
        Joueur j1 = new Humain("random");
        Joueur j2 = new Humain("random2");
        j.setJoueur(j1,PjoueurOne);
        j.setJoueur(j2,PjoueurTwo);
        
        
        
        
    }
}
