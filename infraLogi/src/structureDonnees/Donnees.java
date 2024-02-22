package structureDonnees;

import algo.Action;

import java.util.*;

public class Donnees {
    //Liste d'ateliers
    private ArrayList<Ateliers> ateliers;

    //Liste des candidats
    private ArrayList<Candidats> candidats;

    public Donnees() {
        this.ateliers = new ArrayList<Ateliers>();
        this.candidats = new ArrayList<Candidats>();
    }

    public void ajouterAtelier(Ateliers atelier) {
        this.ateliers.add(atelier);
    }

    public void ajouterCandidat(Candidats candidat) {
        this.candidats.add(candidat);
    }

    public int calculerScore() {
        int score = 0;
        for (Candidats candidat : candidats) {
            int pointCandidat = candidat.getPoints();
            //Application du malus "tout le monde est servi"
            score += pointCandidat ==0 ? -100 : pointCandidat ;
        }
        return score;
    }

    public void affecter(int idCandidat, int idAtelier) {
        Ateliers atelier = ateliers.get(idAtelier);
        atelier.ajouterCandidat();
        candidats.get(idCandidat).affecterAteliers(atelier.getTheme());
    }

    public boolean estAffectable(int idCandidat, int idAtelier) {
        Ateliers atelier = ateliers.get(idAtelier);
        return atelier.getPlacesRestantes()>0 && !candidats.get(idCandidat).estAffecte(atelier.getTheme());
    }

    public boolean estRempli(int idAtelier) {
        return ateliers.get(idAtelier).getPlacesRestantes() == 0;
    }

    public int getIdAtelier(String theme) {
        for (int i = 0; i < ateliers.size(); i++) {
            if (ateliers.get(i).getTheme().equals(theme)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Action> getActions() {
        ArrayList<Action> actions = new ArrayList<Action>();

        //Pour chaque candidat
        for (int i = 0; i < candidats.size(); i++) {
            // On récupère son premier vœu qu'on ajoute à la liste des actions
            for (int j = 0; j < 6; j++) {
                String atelier = candidats.get(i).getCandidatures(j);
                int idAtelier = getIdAtelier(atelier);
                if(idAtelier == -1){
                    continue;
                }
                if (estAffectable(i, idAtelier)) {
                    actions.add(new Action(i, idAtelier));
                    break;
                }
            }
        }

        return actions;
    }

    public boolean estFinal(){
        // On regarde si tous les ateliers sont pleins
        for(Ateliers atelier : ateliers){
            if(atelier.getPlacesRestantes() > 0){
                return false;
            }
        }
        // On regarde si tous les étudiants ont le nombre de cours voulu
//        for(Candidats candidat : candidats){
//            if(candidat.getNbAteliers() < candidat.getNbDemande()){
//                return false;
//            }
//        }
        return true;
    }

    public ArrayList<Ateliers> getAteliers() {
        return ateliers;
    }

    public ArrayList<Candidats> getCandidats() {
        return candidats;
    }

    //Equals
    @Override
    public boolean equals(Object o){
        Donnees donnees = (Donnees) o;
        for(int i = 0; i < this.ateliers.size(); i++){
            if(!this.ateliers.get(i).equals(donnees.ateliers.get(i))){
                return false;
            }
        }
        for(int i = 0; i < this.candidats.size(); i++){
            if(!this.candidats.get(i).equals(donnees.candidats.get(i))){
                return false;
            }
        }
        return true;
    }

    //Clone
    public Donnees clone(){
        Donnees donnees = new Donnees();
        for(Ateliers atelier : ateliers){
            donnees.ajouterAtelier(atelier.clone());
        }
        for(Candidats candidat : candidats){
            donnees.ajouterCandidat(candidat.clone());
        }
        return donnees;
    }

    public String toString(){
        String str = "Ateliers: \n";
        for(Ateliers atelier : ateliers){
            str += atelier.toString() + "\n";
        }
        str += "Candidats: \n";
        for(Candidats candidat : candidats){
            str += candidat.toString();
        }
        str += "Score: " + calculerScore() + "\n";
        return str;
    }

    public int calculerHeuristique() {
        int scoreRestant = 0;
        for (Candidats candidat : candidats) {
            scoreRestant += candidat.getPointRestantMax();
        }

        return scoreRestant;


    }
}
