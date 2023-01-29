package model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Pion;

public class Grille {

    public static int ligne = 6;
    public static int colonne = 7;
    //public static String[][] grille = new String[ligne][colonne];
    private Random random = new Random();
    private ArrayList<ArrayList<String>> grille = new ArrayList<ArrayList<String>>();
    private Scanner _scan = new Scanner(System.in);

    public Grille() {
        // Initialisation de la grille
        for (int i = 0; i < ligne; i++) {
            ArrayList<String> ligne = new ArrayList<String>();
            for (int j = 0; j < colonne; j++) {
                ligne.add(".");
            }
            grille.add(ligne);
        }
    }
    //afficher la grille
    public void afficherGrille() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                System.out.print(grille.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    //vérifier si la colonne du haut est pleine
    public boolean isColonnePleine(int colonne) {
        if (grille.get(colonne).get(0).equals(".")) {
            return false;
        } else {
            return true;
        }
    }

    //ajouter un pion dans la grille 
    public void ajouterPion(String look, int column) {
        if (column >= 0 && column <= colonne - 1 && !isColonnePleine(column)) {
            for (int i = ligne - 1; i >= 0; i--) {
                if (grille.get(i).get(column).equals(".")) {
                    grille.get(i).set(column, look);
                    break;
                }
            }
        } else {
            System.out.println("Vous ne pouvez pas sélectionner cette colonne !");
        }
    }


   
            
       
    
    










}