import java.io.IOException;

public class Joueur {


    /*La classe "Joueur" a trois variables d'instance privées qui sont "name", "symbol" et "color"
     utilisées pour stocker respectivement le name, symbol et color du joueur.
    */
    private String name;
    private char symbol;
    private String color;

    /*La classe "Joueur" a également trois méthodes "get" qui sont utilisées pour récupérer la valeur
     des variables d'instance respectives.
    */
    public String getname() {
        return name;
    }

    public char getsymbol() {
        return symbol;
    }
    
    public String getcolor() {
        return color;
    }
    
    /*La classe "Joueur" a également trois méthodes "set" qui sont utilisées pour mettre à jour la valeur
      des variables d'instance respectives.
     */
    public void setname(String name) {
        this.name = name;
    }
    
    public void setsymbol(char symbol) {
        this.symbol = symbol;
    }

     public void setcolor(String color){
        this.color = color;
    }
    
    private static void addname() throws IOException{
        Joueur n = new Joueur();
        System.out.println("veuillez saisirs votre nom ! "); 
    }
}

