package score;
// 1 = 10
// 2 = 8
// 3 = 6
// 4 = 4
// 5 = 2
// 6 = 1

// Classe retournant le nombre de points pour une position donnée
public class Regles {
    public static int getPoints(int position) {
        switch (position) {
            case 1:
                return 10;
            case 2:
                return 8;
            case 3:
                return 6;
            case 4:
                return 4;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 0;
        }
    }
}

