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

    // Liste des ateliers affectés
    ArrayList<String> ateliers;


    public Candidats(int id, String prenom, int nbDemande, ArrayList<String> candidatures) {
        this.id = id;
        this.prenom = prenom;
        this.nbDemande = nbDemande;
        this.candidatures = candidatures;
        this.ateliers = new ArrayList<String>();
    }

    public void affecterAteliers(String ateliers) {
        this.ateliers.add(ateliers);
    }

    public int getPoints() {
        int points = 0;
        for(String atelier : ateliers){
            points += Regles.getPoints(candidatures.indexOf(atelier)+1);
        }
        return points;
    }

    public int getNbAteliers() {
        return ateliers.size();
    }

    public boolean estAffecte(String atelier) {
        return ateliers.contains(atelier);
    }

    public String getCandidatures(int index) {
        return candidatures.get(index);
    }

    //Equals
    public boolean equals(Candidats candidat) {
        // Vérification des listes
        if(this.ateliers.size() != candidat.ateliers.size()){
            return false;
        }
        for(int i = 0; i < this.ateliers.size(); i++){
            if(!this.ateliers.get(i).equals(candidat.ateliers.get(i))){
                return false;
            }
        }
        return this.id == candidat.id && this.prenom.equals(candidat.prenom);
    }

    //Clone
    public Candidats clone() {
        Candidats candidats = new Candidats(this.id, this.prenom,this.nbDemande, this.candidatures);
        for(String atelier : this.ateliers){
            candidats.affecterAteliers(atelier);
        }
        return candidats;
    }

    public String toString(){
        String str = "Candidat " + id + " : " + prenom + " - " + nbAteliersInscrit + "/" + nbDemande + "\n";
        str += "Candidatures: \n";
        for(String candidature : candidatures){
            str += candidature + "\t";
        }
        str += "\nAteliers: \n";
        for(String atelier : ateliers){
            str += atelier + "\t" ;
        }
        return str+ "\n";
    }

    public int getNbDemande() {
        return nbDemande;
    }

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<String> getAteliers() {
        return ateliers;
    }
}
