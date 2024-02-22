package algo;

import structureDonnees.Donnees;

public class ProblemeEtat {
    Donnees donnees;

    public ProblemeEtat(Donnees donnees){
        this.donnees = donnees.clone();
    }

    public ProblemeEtat clone() {
        return new ProblemeEtat(this.donnees);
    }

    public boolean equalsEtat(ProblemeEtat etat) {
        return donnees.equals(etat.donnees);
    }

    @Override
    public boolean equals(Object o){
        if (o != null && getClass() == o.getClass()) {
            ProblemeEtat s = (ProblemeEtat) o;
            return equalsEtat(s);
        }
        return false;
    }
    @Override
    public String toString() {
        return donnees.toString();
    }

    public int getScore(){
        return donnees.calculerScore();
    }

    public Donnees getDonnees() {
        return donnees;
    }

    public int getHeuristique(){
        return donnees.calculerHeuristique();
    }
}
