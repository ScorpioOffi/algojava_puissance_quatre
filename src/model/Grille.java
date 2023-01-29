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

    /**
     * Permet d'afficher la grille de jeu
     */
    
    
    public void afficherGrille() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                System.out.print(grille.get(j).get(i) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Fonction qui crée une grille
     */
    public Grille() {
        grille = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < colonne; i++) {
            ArrayList<String> colonne = new ArrayList<String>();
            for (int j = 0; j < ligne; j++) {
                colonne.add(".");
            }
            grille.add(colonne);
        }
        //afficherGrille();
    }
    
    private static Scanner _scan = new Scanner(System.in);
    Pion pion =  new Pion(Joueur.creerJoueur());
    int column = _scan.nextInt();
    
    /**
     * Vérifie si la case est vide
     * @return
     */
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
    /**
     * Permet d'ajouter un pion dans la grille
     * @param symbole
     * @param column
     */
    public void ajouterPion(String symbole, int column) {
        if (column >= 0 && column <= colonne - 1 && !isColonnePleine(column)) {
            for (int i = ligne - 1; i >= 0; i--) {
                if (grille.get(i).get(column).equals(".")) {
                    grille.get(i).set(column, symbole);
                    break;
                }
            }
        }
    }
    
    
    /**
     * Vérifie si une colonne de la grille est pleine 
     * @param column
     * @return
     */
    public boolean isColonnePleine(int column) {
        if (!grille.get(0).get(column).equals(".")) {
            return true;
        }
        return false;
    }
    /**
     * Vérifie si la grille est pleine
     * @return
     */
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
    /**
     * permet de vérifier une victoire lors d'une partie 
     * @return
     */
    public boolean victoire() {
        for (int i = 0; i < grille.size(); i++) {
            for (int j = 0; j < grille.get(i).size(); j++) {
                String pion = grille.get(i).get(j);
                if (pion.equals(".")) {
                    continue;
                }
    
                // Vérification des alignements verticaux
                if (i <= grille.size() - 4) {
                    int compteur = 0;
                    for (int k = i; k < i + 4; k++) {
                        if (grille.get(k).get(j).equals(pion)) {
                            compteur++;
                        } else {
                            break;
                        }
                    }
                    if (compteur == 4) {
                        return true;
                    }
                }
    
                // Vérification des alignements horizontaux
                if (j <= grille.get(i).size() - 4) {
                    int compteur = 0;
                    for (int k = j; k < j + 4; k++) {
                        if (grille.get(i).get(k).equals(pion)) {
                            compteur++;
                        } else {
                            break;
                        }
                    }
                    if (compteur == 4) {
                        return true;
                    }
                }
    
                // Vérification des alignements diagonaux à gauche
                if (i <= grille.size() - 4 && j >= 3) {
                    int compteur = 0;
                    for (int k = 0; k < 4; k++) {
                        if (grille.get(i + k).get(j - k).equals(pion)) {
                            compteur++;
                        } else {
                            break;
                        }
                    }
                    if (compteur == 4) {
                        return true;
                    }
                }
    
                // Vérification des alignements diagonaux à droite
                if (i <= grille.size() - 4 && j <= grille.get(i).size() - 4) {
                    int compteur = 0;
                    for (int k = 0; k < 4; k++) {
                        if (grille.get(i + k).get(j + k).equals(pion)) {
                            compteur++;
                        } else {
                            break;
                        }
                    }
                    if (compteur == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * fonction qui permet de créer le jeu
     */
    public static void jeu(){
        Grille grille  = new Grille();
        grille.afficherGrille();
        System.out.println("Colonne?");
        int column = _scan.nextInt();
        while(!grille.victoire()){
            if(!grille.isColonnePleine(column)){
                grille.ajouterPion("@", column);
                grille.afficherGrille();
            }
            System.out.println("Colonne?");
            int column1 = _scan.nextInt();
            grille.ajouterPion("@", column1);
            grille.afficherGrille();
        }
    }
    /**
     * Création de l'IA niveau 1
     * @return
     */
    public int IA_level_1(){
        int column = rand.nextInt(6 - 0) + 0;
        while(isColonnePleine(column)){
            column = rand.nextInt(6 - 0) + 0;
        }
        return column;
    }
}
