import org.junit.Test;
import reader.CSVReader;
import structureDonnees.Ateliers;
import structureDonnees.Candidats;
import structureDonnees.Donnees;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class testCSVReader {

    @Test
    public void testReader() {
        Donnees donnees = CSVReader.reader("infraLogi/src/reader/probleme1.csv");
        Ateliers atelier = new Ateliers(1, "JP", 2);
        Ateliers atelier2 = new Ateliers(2, "OR", 2);
        ArrayList<String> candidatures = new ArrayList<String>();
        candidatures.add("JP");candidatures.add("FR");candidatures.add("OR");candidatures.add("MEX");candidatures.add("IT");candidatures.add("GR");
        Candidats candidat = new Candidats(1, "Albert", 3, candidatures);
        ArrayList<String> candidatures2 = new ArrayList<String>();
        candidatures2.add("OR");candidatures2.add("JP");candidatures2.add("FR");candidatures2.add("IT");candidatures2.add("MEX");candidatures2.add("GR");
        Candidats candidat2 = new Candidats(2, "Bertrand", 3, candidatures2);
        ArrayList<String> candidatures3 = new ArrayList<String>();
        candidatures3.add("JP");candidatures3.add("OR");candidatures3.add("FR");candidatures3.add("IT");candidatures3.add("MEX");candidatures3.add("GR");
        Candidats candidat3 = new Candidats(3, "Clement", 3, candidatures3);
        ArrayList<Candidats> candidatsTest = new ArrayList<Candidats>();
        candidatsTest.add(candidat);candidatsTest.add(candidat2);candidatsTest.add(candidat3);
        ArrayList<Ateliers> ateliersTest = new ArrayList<Ateliers>();
        ateliersTest.add(atelier);ateliersTest.add(atelier2);
        //on compare le contenu des listes
        assertEquals(donnees.getAteliers().size(), ateliersTest.size());
        assertEquals(donnees.getCandidats().size(), candidatsTest.size());
    }
}
