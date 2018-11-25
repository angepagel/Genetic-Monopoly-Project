package monopoly.controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import monopoly.modele.Pion;

import java.util.ArrayList;
import java.util.Observable;

public class ControleurChoixPion {

    private ObservableList<Pion> listePions;

    public ControleurChoixPion(){

    }

    public void InitPion() {
        Pion cheval = new Pion("cheval");
        Pion DeAcoudre = new Pion("DeAcoudre");
        Pion bateau = new Pion("bateau");
        Pion canon = new Pion("canon");
        listePions = FXCollections.observableArrayList(cheval, DeAcoudre, bateau,canon);





    }

    public ObservableList<Pion> getListePions(){
        return listePions;
    }
}
