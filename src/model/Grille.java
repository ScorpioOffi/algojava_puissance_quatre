package model;
import java.util.ArrayList;
import java.util.Scanner;

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



    protected Joueur joueur;
    protected String symbole;
    protected String couleur;
    
    private static Scanner _scan = new Scanner(System.in);
    private static final int ligne = 6;
    private static final int colonne = 7;

    int column = _scan.nextInt();
    private ArrayList<ArrayList<Pion>> grille;

    public void ajouterPion(Pion string, int column) {
        if (column >= 0 && column <= colonne - 1 && !isColonnePleine(column)) {
            for (int i = ligne - 1; i >= 0; i--) {
                if (grille.get(i).get(column).equals(".")) {
                    grille.get(i).set(column, string);
                    break;
                }
            }
        } else {
            System.out.println("Mauvaise colonne, réessayez");
        }
    }
    
    public boolean isColonnePleine(int column) {
        if (!grille.get(0).get(column).equals(".")) {
            return true;
        }
        return false;
    }
    
}

