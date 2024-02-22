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
}
