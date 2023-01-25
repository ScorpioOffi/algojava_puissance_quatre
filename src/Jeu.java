import java.util.Scanner;

import model.Color;
import model.Menu;
import model.State_Game;

public class Jeu {

    public static void main(String[] args) throws Exception {

        State_Game.setGameState(State_Game.WAITING);
        
        if (State_Game.isGameState(State_Game.WAITING)) {
            Menu.afficher_menus();
        }

        State_Game.setGameState(State_Game.PLAYING);
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

                System.out.println(Color.CYAN + "Au tour du joueur " + Color.BLEU + (i % 2 == 1 ? 'X' : 'O') + Color.RESET);
                boolean placement = false;
                int colonne = -1;
                while (!placement) {
                    colonne = -1;
                    String ligne = _scan.nextLine();
                    try {
                        colonne = Integer.valueOf(ligne);

                        if (colonne >= 1 && colonne <= C) {
                            if (tab[colonne - 1][0] != '.') {
                                System.out.println(Color.CYAN + "Colonne pleine, réessayez" + Color.RESET);
                            } else {
                                placement = true;
                            }
                        } else {
                            System.out.println(Color.CYAN + "Nombre incorrect, réessayez" + Color.RESET);
                        }

                    } catch (Exception e) {
                        System.out.println(Color.CYAN + "Nombre incorrect, réessayez" + Color.RESET);
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
                compare(somme, max);
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
                compare(somme, max);
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
                compare(somme, max);
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
                compare(somme, max);
                if (max >= 4) {
                    winner = (i % 2 == 1 ? 1 : 2);
                    i = C * L + 1;
                }
            }

            if (winner == 0) {
                afficher_victoire_pion(C, L, tab);
                egalite();
            }

            if (winner== 1) {
                afficher_victoire_pion(C, L, tab);
                victoire();
            }

            if (winner== 2) {
                afficher_victoire_pion(C, L, tab);
                victoire();
            }
        }
    }

    public static void victoire() {
        System.out.println(Color.VERT + "Victoire!" + Color.RESET);
    }

    public static void egalite() {
        System.out.println(Color.BLACK + "Egalité!" + Color.RESET);
    }

    public static void afficher_victoire_pion(int C, int L, char[][] tab) {
        for (int y = 0; y < L; y++) {
            System.out.print(' ');
            for (int x = 0; x < C; x++) {
                System.out.print(" " + tab[x][y] + " ");
            }
            System.out.print(' ');
            System.out.println();
        }
    }

    public static void compare(int somme, int max) {
        if (somme > max){
            max = somme;
        } 
    }
}