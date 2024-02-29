import algo.AStar;
import algo.BFS;
import algo.Probleme;
import algo.ProblemeEtat;
import reader.CSVReader;
import structureDonnees.Candidats;
import structureDonnees.Donnees;

import java.io.File;
import java.io.IOException;

public class JsonWriter {

    public JsonWriter() throws IOException {
    }

    public static String write(String csv) {
        Donnees donnees = CSVReader.reader(csv);
        Probleme probleme = new Probleme();
        ProblemeEtat etat = new ProblemeEtat(donnees);
        AStar aStar = new AStar(probleme, etat);
        aStar.solve();

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Donnees donneesFinal = aStar.getEnd_node().getDonnees();
        boolean firstUser = true;

        for (Candidats candidats : donneesFinal.getCandidats()) {
            if (!firstUser) {
                jsonBuilder.append(",");
            } else {
                firstUser = false;
            }

            jsonBuilder.append("\"").append(candidats.getId()).append("\":{");
            jsonBuilder.append("\"nom\":\"").append(candidats.getPrenom()).append("\",");
            jsonBuilder.append("\"ateliers\":[");

            boolean firstAtelier = true;
            for (String atelier : candidats.getAteliersAffecte()) {
                if (!firstAtelier) {
                    jsonBuilder.append(",");
                } else {
                    firstAtelier = false;
                }
                jsonBuilder.append("\"").append(atelier).append("\"");
            }

            jsonBuilder.append("]}");
        }

        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}