package model;
import java.util.ArrayList;

public class Plateau {

    private static final int HAUTEUR = 6;
    private static final int LARGEUR = 7;
    
    private ArrayList<ArrayList<String>> plateau;

    public void afficherPlateau() {

        for (int i = HAUTEUR - 1; i >= 0; i--) {
            for (int j = 0; j < LARGEUR; j++) {
                System.out.print("." + plateau.get(j).get(i));
            }
            System.out.println(" ");
        }

        for (int i = 0; i < LARGEUR; i++) {
            System.out.print(" ");
        }

        System.out.println();
    }

    public Plateau() {
        
        plateau = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < LARGEUR; i++) {
            ArrayList<String> colonne = new ArrayList<String>();
            for (int j = 0; j < HAUTEUR; j++) {
                colonne.add(" ");
            }
            plateau.add(colonne);
        }

        afficherPlateau();
    }
}