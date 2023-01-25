package model;

import java.util.ArrayList;
public class Plateau<Gridbox> {
    // creer un plateau de jeu avec des arraylist
    private ArrayList<ArrayList<Gridbox>> plateau = new ArrayList<ArrayList<Gridbox>>();
    
    private int colonne = 7;
    private int ligne = 6;

    public Plateau() {
        for (int i = 0; i < colonne; i++) {
            ArrayList<Gridbox> line = new ArrayList<Gridbox>();
            for (int j = 0; j < ligne; j++) {
                Gridbox gridbox = new Gridbox();
                line.add(gridbox);

            }
            this.plateau.add(line);
        }
    }
    //plateau.get(i).add(null);
    public ArrayList<ArrayList<Gridbox>> getBoard() {
        return plateau;


    }
}

