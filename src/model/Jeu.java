package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    static final int ROWS = 6;
    static final int COLS = 7;
    static final char PLAYER1 = 'X';
    static final char PLAYER2 = 'O';

    static List<List<Character>> board = new ArrayList<>();
    
    public static void Game() throws Exception {

        State_Game.setGameState(State_Game.WAITING);

        
        if (State_Game.isGameState(State_Game.WAITING)) {
            Menu.afficher_menus();
        }

        if (State_Game.isGameState(State_Game.PLAYING)) {
            // initialisation du tableau de jeu
            for (int i = 0; i < ROWS; i++) {
                List<Character> row = new ArrayList<>();
                for (int j = 0; j < COLS; j++) {
                    row.add(' ');
                }
                board.add(row);
            }

            // variable pour stocker le joueur actuel
            char currentPlayer = PLAYER1;

            // variable pour stocker la position de la dernière pièce jouée
            int lastRow = -1;
            int lastCol = -1;

            // boucle de jeu
            while (true) {
                // affichage du tableau de jeu
                printBoard();

                // demande de la colonne où jouer
                System.out.print("Joueur " + currentPlayer + ", choisissez une colonne (1-7) : ");
                Scanner scanner = new Scanner(System.in);
                int col = scanner.nextInt() - 1;

                // vérification de la colonne choisie
                if (col < 0 || col >= COLS) {
                    System.out.println("Colonne non valide, choisissez une colonne entre 1 et 7.");
                    continue;
                }

                // trouver la première case vide dans la colonne choisie
                int row = ROWS - 1;
                while (row >= 0 && board.get(row).get(col) != ' ') {
                    row--;
                }

                // vérification de la ligne choisie
                if (row < 0) {
                    System.out.println("Colonne pleine, choisissez une autre colonne.");
                    continue;
                }

                // placer la pièce
                board.get(row).set(col, currentPlayer);
                lastRow = row;
                lastCol = col;

                // vérifier si le joueur a gagné
                if (checkWin(lastRow, lastCol)) {
                    System.out.println("Joueur " + currentPlayer + " a gagné !");
                    break;
                }

                // vérifier s'il y a match nul
                if (checkDraw()) {
                    System.out.println("Match nul !");
                    break;
                }

                // changer de joueur
                currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
            }
        }

        
    }

    

    public static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print("|" + board.get(i).get(j));
            }
            System.out.println("|");
        }
        for (int i = 1; i <= COLS; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static boolean checkWin(int row, int col) {
        char currentPlayer = board.get(row).get(col);
        // vérifier la colonne
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            if (board.get(i).get(col) == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // vérifier la ligne
        count = 0;
        for (int j = 0; j < COLS; j++) {
            if (board.get(row).get(j) == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // vérifier la diagonale principale
        count = 0;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j) == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                break;
            }
        }
        for (int i = row + 1, j = col + 1; i < ROWS && j < COLS; i++, j++) {
            if (board.get(i).get(j) == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                break;
            }
        }

        // vérifier la diagonale secondaire
        count = 0;
        for (int i = row, j = col; i >= 0 && j < COLS; i--, j++) {
            if (board.get(i).get(j) == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {            break;
            }
        }
        for (int i = row + 1, j = col - 1; i < ROWS && j >= 0; i++, j--) {
            if (board.get(i).get(j) == currentPlayer) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                break;
            }
        }

        // aucune combinaison gagnante n'a été trouvée
        return false;
    }

    public static boolean checkDraw() {
        // vérifier si toutes les cases sont remplies
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board.get(i).get(j) == ' ') {
                    return false;
                }
            }
        }
        // s'il n'y a pas de case vide, il y a match nul
        return true;
    }

    private static void afficherListe() {
        ArrayList<Score> list = Score.listeOrdre();
        if (list.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println((i+1) + " - " + list.get(i).getJoueur().getNom() + " : " + list.get(i).getScore());
            }
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + " - " + list.get(i).getJoueur().getNom() + " : " + list.get(i).getScore());
            }
        }
    }
}
