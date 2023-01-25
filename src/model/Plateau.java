package model;

import java.util.ArrayList;



public class Plateau {
    // creer un plateau de jeu avec des arraylist
    ArrayList<ArrayList<Pion>> plateau = new ArrayList<ArrayList<Pion>>();
    int colonne = 7;
    int ligne = 6;
    public Plateau() {
        for (int i = 0; i < colonne; i++) {
            plateau.add(new ArrayList<Pion>());
            for (int j = 0; j < ligne; j++) {
                plateau.get(i).add(null);
            }
        }
    }


    
}
