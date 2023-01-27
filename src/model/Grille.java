package model;
import java.util.ArrayList;
import model.Pion;

public class Grille {
    private static final int ligne = 6;
    private static final int colonne = 7;
    private ArrayList<ArrayList<String>> grille;

    public void afficherGrille() {
        for (int i = ligne - 1; i >= 0; i--) {
            for (int j = 0; j < colonne; j++) {
                System.out.print("." + grille.get(j).get(i));
            }
            System.out.println(" ");
        }
        for (int i = 0; i < colonne; i++) {
            System.out.print(" ");
        }
        System.out.println();
    }

    public Grille() {
        grille = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < colonne; i++) {
            ArrayList<String> colonne = new ArrayList<String>();
            for (int j = 0; j < ligne; j++) {
                colonne.add(" ");
            }
            grille.add(colonne);
        }
        afficherGrille();
    }
    public ArrayList<ArrayList<String>> getGrille() {
        return grille;
    }

    public void setGrid(ArrayList<ArrayList<String>> grid) {
        this.grille = grille;
    }
}