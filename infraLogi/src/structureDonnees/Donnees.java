package structureDonnees;

import algo.Action;

import java.util.ArrayList;

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
            score += candidat.getPoints();
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
        return atelier.getPlacesRestantes()>0 && candidats.get(idCandidat).estAffecte(atelier.getTheme());
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
                String atelier = candidats.get(i).getAtelier(j);
                int idAtelier = getIdAtelier(atelier);
                if (!estRempli(idAtelier)) {
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
    }


}
