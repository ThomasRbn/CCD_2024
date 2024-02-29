import algo.AStar;
import algo.BFS;
import algo.Probleme;
import algo.ProblemeEtat;
import reader.CSVReader;
import structureDonnees.Donnees;

public class test {
    public static void main(String[] args) {
        String donnees = "ateliers;\n" +
        "id;theme;nb;\n" +
        "1;JP;2;\n" +
        "2;OR;2;\n" +
        "\n" +
        "candidats;\n" +
        "id;nom;nbDemande;ordre1;ordre2;ordre3;ordre4;ordre5;ordre6;\n" +
        "1;Albert;3;JP;FR;OR;MEX;IT;GR;\n" +
        "2;Bertrand;3;OR;JP;FR;IT;MEX;GR;\n" +
        "3;Celine;3;JP;OR;FR;IT;MEX;GR;);" ;
       System.out.println(JsonWriter.write(donnees));
    }
}
