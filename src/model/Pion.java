package model;

import java.util.Scanner;
import java.util.ArrayList;

public class Pion {
    private static Scanner _scan = new Scanner(System.in);
    private static final int HAUTEUR = 6;
    private static final int LARGEUR = 7;
    private ArrayList<ArrayList<String>> grille;
    public void ajouterPion() {
        boolean placement = false;
        int colonne = -1;
    
        // Initialisation de la grille
        for (int i = 0; i < HAUTEUR; i++) {
            ArrayList<String> ligne = new ArrayList<String>();
            for (int j = 0; j < LARGEUR; j++) {
                ligne.add(".");
            }
            grille.add(ligne);
        }
    
        while (!placement) {
            colonne = -1;
            if (isColonnePleine(colonne)) {
                System.out.println("Colonne pleine, réessayez");
            } else {
                String ligne = _scan.nextLine();
                switch (ligne) {
                    case "1":
                        colonne = 0;
                        break;
                    case "2":
                        colonne = 1;
                        break;
                    case "3":
                        colonne = 2;
                        break;
                    case "4":
                        colonne = 3;
                        break;
                    case "5":
                        colonne = 4;
                        break;
                    case "6":
                        colonne = 5;
                        break;
                    case "7":
                        colonne = 6;
                        break;
                    default:
                        System.out.println("Nombre incorrect, réessayez");
                        break;
                }
                if (colonne >= 0 && colonne < LARGEUR) {
                    for (int i = HAUTEUR - 1; i >= 0; i--) {
                        if (grille.get(colonne).get(i).equals(".")) {
                            grille.get(colonne).set(i, "X");
                            placement = true;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public boolean isColonnePleine(int colonne) {
        boolean colonnePleine = true;
        for (int i = 0; i < HAUTEUR; i++) {
            if (grille.get(colonne).get(i).equals(".")) {
                colonnePleine = false;
                break;
            }
        }
        return colonnePleine;
    }


    public Pion() {
        ajouterPion();
    }

    
}