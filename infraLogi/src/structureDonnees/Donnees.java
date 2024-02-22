package structureDonnees;

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


}
