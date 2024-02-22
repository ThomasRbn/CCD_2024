package algo;

import structureDonnees.Donnees;

import java.util.ArrayList;

public class Probleme {
    public Probleme(){

    }

    public ArrayList<Action> getActions(ProblemeEtat etat){
        return etat.donnees.getActions();
    }

    public ProblemeEtat executer(ProblemeEtat etat, Action action){
        ProblemeEtat etatSuivant = etat.clone();
        etatSuivant.donnees.affecter(action.idCandidat, action.idAtelier);
        return etatSuivant;
    }

    public boolean estFinal(ProblemeEtat etat){
        return etat.donnees.estFinal();
    }
}
