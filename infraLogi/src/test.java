import algo.AStar;
import algo.BFS;
import algo.Probleme;
import algo.ProblemeEtat;
import reader.CSVReader;
import structureDonnees.Donnees;

public class test {
    public static void main(String[] args) {
        Donnees donnees = CSVReader.reader("infraLogi/src/reader/probleme4.csv");
        Probleme probleme = new Probleme();
        ProblemeEtat etat = new ProblemeEtat(donnees);
        AStar bfs = new AStar(probleme, etat);
        bfs.solve();
        System.out.println(bfs.getEnd_node());
    }
}
