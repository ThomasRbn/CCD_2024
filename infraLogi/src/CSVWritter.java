import algo.BFS;
import algo.Probleme;
import algo.ProblemeEtat;
import reader.CSVReader;
import structureDonnees.Candidats;
import structureDonnees.Donnees;

import java.io.File;
import java.io.IOException;

public class CSVWritter {

    public CSVWritter() throws IOException {
    }

    public static String write(File file) {
        Donnees donnees = CSVReader.reader(file.getPath());
        Probleme probleme = new Probleme();
        ProblemeEtat etat = new ProblemeEtat(donnees);
        BFS bfs = new BFS(probleme, etat);
        bfs.solve();
        StringBuilder csv = new StringBuilder();
        Donnees donneesfinal = bfs.getEnd_node().getDonnees();
        for (Candidats candidats : donneesfinal.getCandidats()) {
            csv.append(candidats.getId()).append(";").append(candidats.getPrenom()).append(";");
            for (String atelier : candidats.getAteliersAffecte()) {
                csv.append(atelier).append(";");
            }
            csv.append("\n");
        }
        return csv.toString();
    }
}
