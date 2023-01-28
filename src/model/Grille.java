package model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Pion;

public class Grille {
    private static final int ligne = 6;
    private static final int colonne = 7;
    private Random rand = new Random();
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
                colonne.add(".");
            }
            grille.add(colonne);
        }
    }
    public ArrayList<ArrayList<String>> getGrille() {
        return grille;
    }

    public void setGrid(ArrayList<ArrayList<String>> grille) {
        this.grille = grille;
    }
    private static Scanner _scan = new Scanner(System.in);
    Pion pion =  new Pion(Joueur.creerJoueur());

    int column = _scan.nextInt();
    
    public boolean estVide() {
        return this.pion == null;
    }

    /*public void ajouterPion(int column) {
        if (column >= 0 && column < colonne && !isColonnePleine(column)) {
            for (int i = ligne - 1; i >= 0; i--) {
                if (grille.get(i).get(column).estVide()) {
                    grille.get(i).get(column).Pion.setPion(pion);
                    break;
                }
            }
        } else {
            System.out.println("Mauvaise colonne, réessayez");
        }
    }*/
    public void ajouterPion(String symbole, int column) {
        if (column >= 0 && column <= colonne - 1 && !isColonnePleine(column)) {
            for (int i = ligne - 1; i >= 0; i--) {
                if (grille.get(i).get(column).equals(".")) {
                    grille.get(i).set(column, symbole);
                    break;
                }
            }
        } else {
            System.out.println("Vous ne pouvez pas sélectionner cette colonne !");
        }
    }
    
    
    public boolean isColonnePleine(int column) {
        if (!grille.get(0).get(column).equals(".")) {
            return true;
        }
        return false;
    }
    public boolean grillePleine() {
        for (int i = 0; i < grille.size(); i++) {
            for (int j = 0; j < grille.get(i).size(); j++) {
                if (grille.get(i).get(j).equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }
    public int IA_level_1(){
        int column = rand.nextInt(6 - 0) + 0;
        while(isColonnePleine(column)){
            column = rand.nextInt(6 - 0) + 0;
        }
        return column;
    }
}
