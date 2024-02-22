package structureDonnees;

import score.Regles;

import java.util.ArrayList;

public class Candidats {
    int id;
    String prenom;

    int nbAteliersInscrit;

    int nbDemande;

    // Liste des candidatures
    ArrayList<String> candidatures;

    // Liste des atteliers affectés
    ArrayList<String> ateliers;


    public Candidats(int id, String prenom, int nbDemande, ArrayList<String> candidatures) {
        this.id = id;
        this.prenom = prenom;
        this.nbDemande = nbDemande;
        this.candidatures = candidatures;
    }

    public void affecterAteliers(String ateliers) {
        this.ateliers.add(ateliers);
    }

    public int getPoints() {
        int points = 0;
        for(String atelier : ateliers){
            points += Regles.getPoints(candidatures.indexOf(atelier));
        }
        return points;
    }

    public int getNbAteliers() {
        return ateliers.size();
    }

    public boolean estAffecte(String atelier) {
        return ateliers.contains(atelier);
    }

    public String getAtelier(int index) {
        return ateliers.get(index);
    }


}
