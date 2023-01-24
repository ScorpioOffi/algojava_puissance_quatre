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
            Scanner _scan = new Scanner(System.in);
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

                for (int b = 0; b < C + 2 + 2 * C; b++) System.out.print(' ');
                System.out.println();

                System.out.println(" Au tour du joueur " + (i % 2 == 1 ? 'X' : 'O'));
                boolean placement = false;
                int colonne = -1;
                while (!placement) {
                    colonne = -1;
                    String ligne = _scan.nextLine();
                    try {
                        colonne = Integer.valueOf(ligne);

                        if (colonne >= 1 && colonne <= C) {
                            if (tab[colonne - 1][0] != '.') {
                                System.out.println("Colonne pleine, réessayez");
                            } else {
                                placement = true;
                            }
                        } else {
                            System.out.println("Nombre incorrect, réessayez");
                        }

                    } catch (Exception e) {
                        System.out.println("Nombre incorrect, réessayez");
                    }

                }
                int rang = L - 1;
                while (tab[colonne - 1][rang] != '.') {
                    rang--;
                }
                tab[colonne - 1][rang] = (i % 2 == 1 ? 'X' : 'O');
                char symbole = (i % 2 == 1 ? 'X' : 'O');
                int max = 0;
                int x;
                int y;
                int somme;

                x = colonne - 1;
                y = rang;
                somme = -1;
                while (y >= 0 && x >= 0 && tab[x][y] == symbole) {
                    y--;
                    x--;
                    somme++;
                }
                x = colonne - 1;
                y = rang;
                while (y < L && x < C && tab[x][y] == symbole) {
                    y++;
                    x++;
                    somme++;
                }
                if (somme > max) max = somme;

                x = colonne - 1;
                y = rang;
                somme = -1;
                while (y >= 0 && x < C && tab[x][y] == symbole) {
                    y--;
                    x++;
                    somme++;
                }
                x = colonne - 1;
                y = rang;
                while (y < L && x >= 0 && tab[x][y] == symbole) {
                    y++;
                    x--;
                    somme++;
                }
                if (somme > max) max = somme;

                x = colonne - 1;
                y = rang;
                somme = -1;
                while (y >= 0 && tab[x][y] == symbole) {
                    y--;
                    somme++;
                }
                y = rang;
                while (y < L && tab[x][y] == symbole) {
                    y++;
                    somme++;
                }
                if (somme > max) max = somme;

                x = colonne - 1;
                y = rang;
                somme = -1;
                while (x >= 0 && tab[x][y] == symbole) {
                    x--;
                    somme++;
                }
                x = colonne - 1;
                while (x < C && tab[x][y] == symbole) {
                    x++;
                    somme++;
                }
                if (somme > max) max = somme;


                if (max >= 4) {
                    winner = (i % 2 == 1 ? 1 : 2);
                    i = C * L + 1;
                }

            }

            for (int y = 0; y < L; y++) {
                System.out.print(' ');
                for (int x = 0; x < C; x++) {
                    System.out.print(" " + tab[x][y] + " ");
                }
                System.out.print(' ');
                System.out.println();
            }

            if (winner == 0) {
                System.out.println("Egalité!");
            }


            if (winner== 1) {
                System.out.println("Victoire!");
            }
            if (winner== 2) {
                System.out.println("Victoire!");
            }
        }
    }
}