package model;

import java.util.*;
import model.Jeu;
public class IA {

    

    public static void level_1() {
        Position[][] grille = new Position[6][7];
        Random rand = new Random();
        
        int i = rand.nextInt(7); 
        boolean ia = true ; 
        while(ia){
            System.out.println(i);
            if (grille[0][i] != null){
                i = rand.nextInt(7);
            }else{
                ia = false;
            }
        }
        
        i = rand.nextInt(6);
    }


  

    public static void level_2() {

    }

    public static void level_3() {

    }

    public static void level_4() {

    }
    
}