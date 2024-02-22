package structureDonnees;

public class Ateliers {
    int id;
    String theme;
    int nbPlaces;

    int nbCandidats;

    public Ateliers(int id, String theme, int nbPlaces) {
        this.id = id;
        this.theme = theme;
        this.nbPlaces = nbPlaces;
        this.nbCandidats = 0;
    }

    public Ateliers(int id, String theme, int nbPlaces, int nbCandidats) {
        this.id = id;
        this.theme = theme;
        this.nbPlaces = nbPlaces;
        this.nbCandidats = nbCandidats;
    }

    public void ajouterCandidat() {
        this.nbCandidats++;
    }

    public String getTheme() {
        return theme;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public int getPlacesRestantes() {
        return nbPlaces - nbCandidats;
    }

    //Equals
    public boolean equals(Ateliers atelier) {
        return this.id == atelier.id && this.theme.equals(atelier.theme) && this.nbPlaces == atelier.nbPlaces;
    }

    //Clone
    public Ateliers clone() {
        return new Ateliers(this.id, this.theme, this.nbPlaces, this.nbCandidats);
    }

    public String toString(){
        return "Atelier " + id + " : " + theme + " - " + nbCandidats + "/" + nbPlaces;
    }
}
