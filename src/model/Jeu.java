package model;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Jeu {

    private static final char[] Joueurs = {'X', 'O'};
    private final int width, height;
    private final char[][] grille;
    private int lastCol = -1, lastTop = -1;
    
    public Jeu(int w, int h) {
        width = w;
        height = h;
        grille = new char[h][];

        for (int i = 0; i < h; i++) {
            Arrays.fill(grille[i] = new char[w], '.');
        }
    }

    public String toString() {
        return IntStream.range(0, width).mapToObj(Integer::toString).collect(Collectors.joining()) + "\n" + 
            Arrays.stream(grille).map(String::new).collect(Collectors.joining("\n"));
    }

    public String horizontal() {
        return new String(grille[lastTop]);
    }

    public String vertical() {
        StringBuilder sb = new StringBuilder(height);

        for (int h = 0; h < height; h++) {
            sb.append(grille[h][lastCol]);
        }
        return sb.toString();
    }

    public String slashDiagonal() {
        StringBuilder sb = new StringBuilder(height);

        for (int h = 0; h < height; h++) {
            int w = lastCol + lastTop - h;

            if (0 <= w && w < width) {
                sb.append(grille[h][w]);
            }
        }
        return sb.toString();
    }

    public String backSlashDiagonal() {
        StringBuilder sb = new StringBuilder(height);

        for (int h = 0; h < height; h++) {
            int w = lastCol - lastTop + h;

            if (0 <= w && w < width) {
                sb.append(grille[h][w]);
            }
        }
        return sb.toString();
    }

    public static boolean contains(String str, String subString) {
        return str.indexOf(subString) >= 0;
    }

    public boolean isWinningPlay() {
        if (lastCol == -1) {
            System.out.println(Color.ROUGE + "Aucun déplacement n'a encore été effectué" + Color.RESET);
            return false;
        }

        char sym = grille[lastTop][lastCol];
        String streak = String.format("%c%c%c%c", sym, sym, sym, sym);

        return contains(horizontal(), streak) || contains(vertical(), streak)
                || contains(slashDiagonal(), streak) || contains(backSlashDiagonal(), streak);
    }

    public void chooseAndDrop(char symbol, Scanner input) {
        do {
            System.out.println(Color.BLEU + "\nJoueur " + Color.CYAN + symbol + Color.BLEU + " tour : " + Color.RESET);
            int col = input.nextInt();

            if (!(0 <= col && col < width)) {
                System.out.println(Color.CYAN + "La colonne doit être comprise entre 0 et " + (width - 1) + Color.RESET);
                continue;   
            }

            for (int h = height - 1; h >= 0; h--) {
                if (grille[h][col] == '.') {
                    grille[lastTop = h][lastCol = col] = symbol;
                    return;
                }
            }
            System.out.println(Color.BLEU + "Colonne " + Color.CYAN + col + Color.BLEU +" est remplie" + Color.RESET);
        } while(true);
    }

    public static void play() {
        try (Scanner input = new Scanner(System.in)) {
            int height = 6; int width = 7; int moves = height * width;

            Jeu game = new Jeu(width, height);

            System.out.println(Color.CYAN + "Utiliser 0-" + (width - 1) + " choisir une colonne" + Color.RESET);
            System.out.println(game);

            for (int player = 0; moves-- > 0; player = 1 - player) {
                char symbol = Joueurs[player];

                game.chooseAndDrop(symbol, input);

                System.out.println(game);

                if (game.isWinningPlay()) {
                    System.out.println(Color.VERT + "\nJoueur " + Color.CYAN + symbol + Color.VERT + " gagne !" + Color.RESET);
                    return;
                }
            }

            System.out.println(Color.ROUGE + "Partie perdu, pas de gagnant. Recommancer !" + Color.RESET);
        }
    }
}
