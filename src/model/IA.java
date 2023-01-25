package model;

public class IA {

    public static void level_1() {
        int C = 6;
        int L = 7;
        char[][] pris = new char[C][L];
        boolean dejaPris = true; 
        boolean pasPris = false;

        if(pris != null && pris.length != 0){

            for(int i =0; i < pris.length; i++){
                for(int j = 0; j < pris[i].length; j++){
                  System.out.print(pris[i][j]+".");
                }
                System.out.println();
            }
        } else{

            double rand = Math.random();

            System.out.println(rand);
        }
    }

    public static void level_2() {
        
    }

    public static void level_3() {
        
    }

    public static void level_4() {
        
    }
    
}
