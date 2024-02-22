package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import structureDonnees.Donnees;
import structureDonnees.Ateliers;
import structureDonnees.Candidats;

import static reader.CSVReader.readCSV;

public class CSVReaderFile {

    public static Donnees reader(String csvFile) {

        // Création de l'instance Donnees
        Donnees donnees = new Donnees();

        try {
            List<String[]> data = readCSV(csvFile);

            // Indicateurs pour savoir si nous traitons les ateliers ou les candidats
            boolean ateliersSection = false;
            boolean candidatsSection = false;

            // Boucle pour remplir les données
            for (String[] row : data) {
                if (row.length > 0) {
                    // Si la première colonne contient "ateliers", nous commençons à traiter les ateliers
                    if (row[0].equalsIgnoreCase("ateliers")) {
                        ateliersSection = true;
                        candidatsSection = false;
                        continue;  // Passez à la prochaine ligne
                    }
                    // Si la première colonne contient "candidats", nous commençons à traiter les candidats
                    else if (row[0].equalsIgnoreCase("candidats")) {
                        ateliersSection = false;
                        candidatsSection = true;
                        continue;  // Passez à la prochaine ligne
                    }

                    //On recupere les mots qui sont espacés par des points virgules
                    if (row.length < 3) {
                        continue;
                    }
                    if (row[0].equalsIgnoreCase("id")) {
                        continue;
                    }
                    if (ateliersSection) {
                        //System.out.println(row[0] + " " + row[1] + " " + row[2]);
                        Ateliers ateliers = new Ateliers(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]));
                        donnees.ajouterAtelier(ateliers);
                    }
                    if (candidatsSection) {
                        ArrayList<String> candidatures = new ArrayList<String>(Arrays.asList(row).subList(3, row.length));
                        //System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + candidatures.toString());
                        Candidats candidats = new Candidats(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]), candidatures);
                        donnees.ajouterCandidat(candidats);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return donnees;
    }
}
