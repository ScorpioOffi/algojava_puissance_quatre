import java.util.Scanner;

import model.Menu;
import model.State_Game;

public class Jeu {

    public static void main(String[] args) throws Exception {

        State_Game.setGameState(State_Game.WAITING);
        
        if (State_Game.isGameState(State_Game.WAITING)) {
            Menu.afficher_menus();
        }

        if (State_Game.isGameState(State_Game.PLAYING)) {
            Scanner scanner = new Scanner(System.in);
            int N = 4;
            int C = 7;
            int L = 6;
            char[][] plateau = new char[C][L];
            for (int x = 0; x < C; x++) {
                for (int y = 0; y < L; y++) {
                    plateau[x][y] = '.';
                }
            }
            int gagnant = 0;
            for (int i = 1; i <= C * L; i++) {

                for (int loop = 0; loop < C + 2 + 2 * C; loop++) System.out.print(' ');
                System.out.println();

                for (int y = 0; y < L; y++) {
                    System.out.print(' ');
                    for (int x = 0; x < C; x++) {
                        System.out.print(" " + plateau[x][y] + " ");
                    }
                    System.out.print(' ');
                    System.out.println();
                }

                for (int loop = 0; loop < C + 2 + 2 * C; loop++) System.out.print(' ');
                System.out.println();

                System.out.println(" Au tour du joueur " + (i % 2 == 1 ? 'X' : 'O'));
                boolean placement = false;
                int colonne = -1;
                while (!placement) {
                    colonne = -1;
                    String ligne = scanner.nextLine();
                    try {
                        colonne = Integer.valueOf(ligne);

                        if (colonne >= 1 && colonne <= C) {
                            if (plateau[colonne - 1][0] != '.') {
                                System.out.println("Colonne pleine, réitérez");
                            } else {
                                placement = true;
                            }
                        } else {
                            System.out.println("Nombre incorrect, réitérez");
                        }

                    } catch (Exception e) {
                        System.out.println("Nombre incorrect, réitérez");
                    }

                }
                int rang = L - 1;
                while (plateau[colonne - 1][rang] != '.') {
                    rang--;
                }
                plateau[colonne - 1][rang] = (i % 2 == 1 ? 'X' : 'O');
                char symbole = (i % 2 == 1 ? 'X' : 'O');
                int max = 0;
                int x;
                int y;
                int somme;

                x = colonne - 1;
                y = rang;
                somme = -1;
                while (y >= 0 && x >= 0 && plateau[x][y] == symbole) {
                    y--;
                    x--;
                    somme++;
                }
                x = colonne - 1;
                y = rang;
                while (y < L && x < C && plateau[x][y] == symbole) {
                    y++;
                    x++;
                    somme++;
                }
                if (somme > max) max = somme;

                x = colonne - 1;
                y = rang;
                somme = -1;
                while (y >= 0 && x < C && plateau[x][y] == symbole) {
                    y--;
                    x++;
                    somme++;
                }
                x = colonne - 1;
                y = rang;
                while (y < L && x >= 0 && plateau[x][y] == symbole) {
                    y++;
                    x--;
                    somme++;
                }
                if (somme > max) max = somme;

                x = colonne - 1;
                y = rang;
                somme = -1;
                while (y >= 0 && plateau[x][y] == symbole) {
                    y--;
                    somme++;
                }
                y = rang;
                while (y < L && plateau[x][y] == symbole) {
                    y++;
                    somme++;
                }
                if (somme > max) max = somme;

                x = colonne - 1;
                y = rang;
                somme = -1;
                while (x >= 0 && plateau[x][y] == symbole) {
                    x--;
                    somme++;
                }
                x = colonne - 1;
                while (x < C && plateau[x][y] == symbole) {
                    x++;
                    somme++;
                }
                if (somme > max) max = somme;


                if (max >= N) {
                    gagnant = (i % 2 == 1 ? 1 : 2);
                    i = C * L + 1;
                }

            }

            for (int y = 0; y < L; y++) {
                System.out.print(' ');
                for (int x = 0; x < C; x++) {
                    System.out.print(" " + plateau[x][y] + " ");
                }
                System.out.print(' ');
                System.out.println();
            }

            if (gagnant == 0) {
                System.out.println("Match Nul");
            }


            if (gagnant == 1) {
                System.out.println("Victoire");
            }

        }
    }
}