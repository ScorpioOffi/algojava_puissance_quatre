package model;

public class IA {

    public static void level_1() {
        int C = 7;
        int L = 6;
        char[][] tab = new char[C][L];

        for (int x = 0; x < C; x++) {
            for (int y = 0; y < L; y++) {
                tab[x][y] = '.';
            }
        }
        int winner = 0;
            for (int i = 1; i <= C * L; i++) {

                for (int a = 0; a < C + 2 + 2 * C; a++) System.out.print(' ');
                System.out.println();

                for (int y = 0; y < L; y++) {
                    System.out.print(' ');
                    for (int x = 0; x < C; x++) {
                        System.out.print(" " + tab[x][y] + " ");
                    }
                    System.out.print(' ');
                    System.out.println();
                }
            }
    }

  

    public static void level_2() {
        
    }

    public static void level_3() {
        
    }

    public static void level_4() {
        
    }
    
}