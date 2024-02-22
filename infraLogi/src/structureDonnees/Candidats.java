package structureDonnees;

import score.Regles;

import java.util.ArrayList;

public class Candidats {
    int id;
    String prenom;

    int nbAteliersAffecte;

    int nbDemande;

    // Liste des candidatures
    ArrayList<String> candidatures;

    // Liste des ateliers affectés
    ArrayList<String> ateliersAffecte;


    public Candidats(int id, String prenom, int nbDemande, ArrayList<String> candidatures) {
        this.id = id;
        this.prenom = prenom;
        this.nbDemande = nbDemande;
        this.candidatures = candidatures;
        this.ateliersAffecte = new ArrayList<String>();
    }

    public void affecterAteliers(String ateliers) {
        this.ateliersAffecte.add(ateliers);
        nbAteliersAffecte++;
    }

    public int getPoints() {
        int points = 0;
        for (int i = 0; i < nbAteliersAffecte; i++) {
            String atelier = ateliersAffecte.get(i);
            // Calcul des points : Numéro de la candidature + la dégression
            points += Regles.getPoints(candidatures.indexOf(atelier) + 1+i);
        }
        return points;
    }

    public int getPointRestantMax() {
        // Calcul du nombre de points restant possible a obtenir
        int points = 0;
        int index = -1;
        int malus = 0;
        if (nbAteliersAffecte != 0) {
            //On récupère le premier atelier
            malus = nbAteliersAffecte;
            String dernierAtelier = ateliersAffecte.getLast();
            index = candidatures.indexOf(dernierAtelier);

        }
        for (int i = index + 1; i < candidatures.size(); i++) {
            points += Regles.getPoints(i + 1-malus);
            malus++;
        }
        return points;
    }

    public int getNbAteliers() {
        return nbAteliersAffecte;
    }

    public boolean estAffecte(String atelier) {
        return ateliersAffecte.contains(atelier);
    }

    public String getCandidatures(int index) {
        return candidatures.get(index);
    }

    //Equals
    public boolean equals(Candidats candidat) {
        // Vérification des listes
        if (this.nbAteliersAffecte != candidat.nbAteliersAffecte) {
            return false;
        }
        for (int i = 0; i < this.nbAteliersAffecte; i++) {
            if (!this.ateliersAffecte.get(i).equals(candidat.ateliersAffecte.get(i))) {
                return false;
            }
        }
        return this.id == candidat.id && this.prenom.equals(candidat.prenom);
    }

    //Clone
    public Candidats clone() {
        Candidats candidats = new Candidats(this.id, this.prenom, this.nbDemande, this.candidatures);
        for (String atelier : this.ateliersAffecte) {
            candidats.affecterAteliers(atelier);
        }
        return candidats;
    }

    public String toString() {
        String str = "Candidat " + id + " : " + prenom + " - " + nbAteliersAffecte + "/" + nbDemande + "\n";
        str += "Candidatures: \n";
        for (String candidature : candidatures) {
            str += candidature + "\t";
        }
        str += "\nAteliers: \n";
        for (String atelier : ateliersAffecte) {
            str += atelier + "\t";
        }
        return str + "\n";
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

    public ArrayList<String> getAteliersAffecte() {
        return ateliersAffecte;
    }
}
