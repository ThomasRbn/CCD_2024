package algo;

public class Action {
    int idCandidat;
    int idAtelier;

    public Action(int idCandidat, int idAtelier) {
        this.idCandidat = idCandidat;
        this.idAtelier = idAtelier;
    }

    public String toString(){
        return "Action: Candidat " + idCandidat + " -> Atelier " + idAtelier;
    }
}
