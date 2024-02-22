import algo.AStar;
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

    public static String write(String csv) {
        Donnees donnees = CSVReader.reader(csv);
        Probleme probleme = new Probleme();
        ProblemeEtat etat = new ProblemeEtat(donnees);
        AStar aStar = new AStar(probleme, etat);
        aStar.solve();
        StringBuilder csvFinal = new StringBuilder();
        Donnees donneesfinal = aStar.getEnd_node().getDonnees();
        for (Candidats candidats : donneesfinal.getCandidats()) {
            csvFinal.append(candidats.getId()).append(";").append(candidats.getPrenom()).append(";");
            for (String atelier : candidats.getAteliersAffecte()) {
                csvFinal.append(atelier).append(";");
            }
            csvFinal.append("\n");
        }
        return csvFinal.toString();
    }
}
