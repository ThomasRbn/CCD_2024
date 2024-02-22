import algo.AStar;
import algo.BFS;
import algo.Probleme;
import algo.ProblemeEtat;
import reader.CSVReader;
import structureDonnees.Donnees;

public class test {
    public static void main(String[] args) {
        Donnees donnees = CSVReader.reader("ateliers;\n" +
        "id;theme;nb;\n" +
        "1;JP;2;\n" +
        "2;OR;2;\n" +
        "\n" +
        "candidats;\n" +
        "id;nom;nbDemande;ordre1;ordre2;ordre3;ordre4;ordre5;ordre6;\n" +
        "1;Albert;3;JP;FR;OR;MEX;IT;GR;\n" +
        "2;Bertrand;3;OR;JP;FR;IT;MEX;GR;\n" +
        "3;Celine;3;JP;OR;FR;IT;MEX;GR;);" );
        Probleme probleme = new Probleme();
        ProblemeEtat etat = new ProblemeEtat(donnees);
        AStar aStar = new AStar(probleme, etat);
        aStar.solve();
        Donnees donneesfinal = aStar.getEnd_node().getDonnees();
        for (int i = 0; i < donneesfinal.getCandidats().size(); i++) {
            System.out.print(donneesfinal.getCandidats().get(i).getId() + ";" + donneesfinal.getCandidats().get(i).getPrenom() + ";");
            for (int j = 0; j < donneesfinal.getCandidats().get(i).getAteliersAffecte().size(); j++) {
                System.out.print(donneesfinal.getCandidats().get(i).getAteliersAffecte().get(j) + ";");
            }
            System.out.println();
        }
    }
}
