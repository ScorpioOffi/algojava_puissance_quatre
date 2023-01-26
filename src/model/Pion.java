package model;

import java.util.Scanner;
import java.util.ArrayList;

public class Pion {


    protected Joueur joueur;
    protected String symbole;
    protected String couleur;


    public Pion(Joueur joueur){
        this.joueur = joueur;
        symbole = joueur.getSymb();
        couleur = joueur.getCouleur();
    }

    public String getSymbole() {
        return symbole;
    }

    public String getCouleur() {
        return couleur;
    }



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

