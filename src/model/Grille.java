package model;
import java.util.ArrayList;

public class Grille {
    private  int HAUTEUR = 6;
    private  int LARGEUR = 7;
    private ArrayList<ArrayList<Pion>> grille;




    public void afficherGrille() {
        for (int i = HAUTEUR - 1; i >= 0; i--) {
            for (int j = 0; j < LARGEUR; j++) {
                System.out.print("." + grille.get(j).get(i));
            }
            System.out.println(" ");
        }
        for (int i = 0; i < LARGEUR; i++) {
            System.out.print(" ");
        }
        System.out.println();
    }
     

boolean isColonnePleine(int colonne) {
        for (int i = 0; i < HAUTEUR; i++) {
            if (grille.get(colonne).get(i).equals(".")) {
                return false;
            }
        }
        return true;
    }


    public void ajouterPion(int LARGEUR, int HAUTEUR) {
        if (LARGEUR >= 0 && LARGEUR < LARGEUR && !isColonnePleine(LARGEUR)) {
            for (int i = HAUTEUR - 1; i >= 0; i--) {
                if (grille.get(LARGEUR).get(i).equals(".")) {
                    grille.get(LARGEUR).set(i, null);               
                    break;
                }
            }
        } else {
            System.out.println("Vous ne pouvez pas sélectionner cette colonne !");
        }



    }

    public Grille() {
        grille = new ArrayList<ArrayList<Pion>>();
        for (int i = 0; i < LARGEUR; i++) {
            ArrayList<Pion> colonne = new ArrayList<Pion>();
            for (int j = 0; j < HAUTEUR; j++) {
                colonne.add(new Pion());
            }
            grille.add(colonne);
        }
        afficherGrille();
    }

    
}