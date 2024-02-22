import algo.AStar;
import algo.BFS;
import algo.Probleme;
import algo.ProblemeEtat;
import reader.CSVReader;
import reader.CSVReaderFile;
import structureDonnees.Donnees;

public class TestWithFile {

        public static void main(String[] args) {
            Donnees donnees = CSVReaderFile.reader("infraLogi/src/reader/probleme9.csv");
            Probleme probleme = new Probleme();
            ProblemeEtat etat = new ProblemeEtat(donnees);
            AStar aStar = new AStar(probleme, etat);
            aStar.solve();
            System.out.println(aStar.getEnd_node().getDonnees());
        }
}
