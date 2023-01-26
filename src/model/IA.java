package model;

<<<<<<< HEAD
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;
=======
import java.util.ArrayList;
>>>>>>> 185d84d08ae0eee70d5b053a019554709954ebcc
import java.util.Random;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;


public class IA {
    
    private static int addrang;

    public static void level_1() {
        Random rand = new Random();
        int i = rand.nextInt(7 - 0) -0; 
        addrang = i; 
        int o = rand.nextInt(7 - 0) -0;
<<<<<<< HEAD

    }

       /* int C = 7;
        int L = 6;
        char[][] pris = new char[C][L];
        boolean dejaPris = true; 
        boolean pasPris = false;
        
        if(pris != null && pris.length != 0){

            for(int i =0; i < pris.length; i++){
                for(int j = 0; j < pris[i].length; j++){
                  System.out.print(pris[i][j]+" ");
                }
                System.out.println(i);
            }
        }

        else{

            double rand = Math.random();
    
            System.out.println(rand);
        }
=======
>>>>>>> 185d84d08ae0eee70d5b053a019554709954ebcc
    }

        
<<<<<<< HEAD
        if(dejaPris == rand ){
            System.out.println(true)
        }
        else{
            
            double rand = Math.random();
    
            System.out.println(rand);
        }*/




    public static int level_2( int[][] board, int player ) {
        
                Random rand = new Random();
                ArrayList<Integer> prisColumns = new ArrayList<Integer>();
                int blockedCol=-1;
                // Ajout des colonnes valides dans l'ArrayList
                for (int i = 0; i < board[0].length; i++) {
                    if (board[0][i] == 0) {
                        prisColumns.add(i);
                    }
                }
                // Vérifie s'il y a une possibilité de victoire pour le joueur humain
                blockedCol = detect_win(board, player);
                if(blockedCol>-1) return blockedCol; // si oui, bloque
                
=======
        
>>>>>>> 185d84d08ae0eee70d5b053a019554709954ebcc
    }

    public static void level_3() {
        
    }

    public static void level_4() {
        
    }
    
}