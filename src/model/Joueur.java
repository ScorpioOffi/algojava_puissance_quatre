package model;

import java.util.Scanner;


public class Joueur { // on commence par créer une classe joueur
    
    public static String currentPlayer;
    //on declare les variables de la classe joueur
    private String nom; // une variable nom de type String qui va nous permettre de stocker le nom du joueur
    private String symbol; // le meme principe pour la variable symbols qui va nous permettre de stocker le symbole du joueur
    private String couleur; // et la variable couleur qui va nous permettre de stocker la couleur du joueur

    // ON CRÉER LES METHODES DE LA CLASSE JOUEUR
    public String getNom() { // et pour la variable nom
        return nom;
    }

    public String getSymb() { // on crée une méthode getSymb qui va nous permettre de récupérer la valeur de la variable symbols
        
        return symbol;
    }

    public String getCouleur() { // on fait la même pour la variable couleur

        return couleur;
    }
    public Joueur() {
        currentPlayer = "1";
    }

    public static String getCurrentPlayer() {
            return currentPlayer;
    }

    


   

    public Joueur(String nom, String symbols, String couleur) { // on crée une méthode constructeur qui va nous permettre de créer un joueur
        this.nom = nom; // on initialise la variable nom
        this.symbol = symbols; // on initialise la variable symbols
        this.couleur = couleur;// on initialise la variable couleur
    }
}

   /* public String choixCouleur(int couleur) {
        if (couleur == 1) {
            return Color.JAUNE;
        } else if (couleur == 2) {
            return Color.ROUGE;
        } else if (couleur == 3) {
            return Color.VERT;
        } else if (couleur == 4) {
            return Color.BLEU;
        } else if (couleur == 5) {
            return Color.VIOLET;
        
    }
        return "Veuillez choisir une couleur";
    }
*/ 
    
    //public Joueur creerJoueur() { // on crée une méthode customisationJoueur qui va nous permettre de personnaliser le joueur
        
        //boolean isOk = false; // on crée une variable isOk de type boolean qui va nous permettre de savoir si l'utilisateur a bien rentré les données demandées
    

        //Scanner scann = new Scanner(System.in); // on crée un scanner qui va nous permettre de récupérer les données entrées par l'utilisateur
     

      //personnalisation des couleurs
    
     
     
      //isOk = false;
      //while(!isOk){ // si la couleur n'est pas isOk


        
        /*Scanner scanncolor = new Scanner(System.in);// on crée un scanner qui va nous permettre de récupérer les données entrées par l'utilisateur
          if(scanncolor.hasNextInt()) { 
              int choixcouleurjoueur = scanncolor.nextInt();
             { 

                  boolean symbcolor= false;// on crée une variable isOk de type boolean qui va nous permettre de savoir si l'utilisateur a bien rentré les données demandées
                  while (!symbcolor) { //tant que la couleur n'est pas isOk
                      Scanner color1 = new Scanner(System.in);
                      
                      System.out.println("\nQuelle couleur souhaitez vous utiliser ?\nVous pouvez choisir parmis les couleurs suivantes : ["+Color.BLEU+"Bleu"+Color.RESET+", "+Color.JAUNE+"Jaune"+Color.RESET+", "+Color.VIOLET+"Violet"+Color.BLEU+" et "+Color.ROUGE+"Rouge"+Color.RESET+"]");

                        String colorJoueur =
                        color1.nextLine();// on récupère la couleur entrée par l'utilisateur
                     

                      //changement de la couleur de l'objet celon la reponse donné
                      if (colorJoueur.toLowerCase().equals("bleu")) {
                        this.couleur = Color.BLEU;
                      }
                      if (colorJoueur.toLowerCase().equals("jaune")) {
                          this.couleur = Color.JAUNE;
                      }
                      if (colorJoueur.toLowerCase().equals("violet")) {
                        this.couleur = Color.VIOLET;
                      }
                      if (colorJoueur.toLowerCase().equals("rouge")) {
                        this.couleur = Color.ROUGE;

                      }


                      if (!(colorJoueur.toLowerCase().equals("rouge") || colorJoueur.toLowerCase().equals("violet") || colorJoueur.toLowerCase().equals("jaune") || colorJoueur.toLowerCase().equals("bleu"))) {
                          //si la reponse pour la couleur est differente des choix donné alors renvoie une erreur
                          System.out.println(Color.ROUGE+"\nCouleur non isOk car non reconnues! Veuillez réessayer !"+Color.RESET);//message d'erreur
                        
                        } else {
                            symbcolor = true;//si la couleur est isOk alors on passe a la variable suivante
                            }
                  }

              }
            }
    }
}


   /* 
         // choisir  ton pseudo
        System.out.println("Quel est votre nom ?"); // on demande à l'utilisateur de rentrer son nom
        String nom = scann.nextLine(); // on récupère le nom entré par l'utilisateur

       
         // choisir  ta couleur
        System.out.println("Quel symbol souhaitez vous ?"); // on demande à l'utilisateur de rentrer son symbole
        String symbols = scann.nextLine(); // on récupère le symbole entré par l'utilisateur

       
         // choisir  ta couleur
       System.out.println("Quel couleur veux-tu ?"); // on demande à l'utilisateur de rentrer sa couleur
       System.out.println("Voici la liste des couleurs disponibles :"); 
       
        System.out.println( Color.JAUNE + "Jaune "+ Color.BLEU + "    Bleu"+ Color.VIOLET + "    Violet"+ Color.ROUGE + "    Rouge"+ Color.VERT + "    Vert "+ Color.RESET);
       
        System.out.println(" ");
        System.out.println("?"); // on demande à l'utilisateur de rentrer sa couleur
        String couleur = scann.nextLine(); // on récupère la couleur entrée par l'utilisateur

      
        Joueur joueur = new Joueur(nom, symbols, couleur);// on crée un joueur avec les données entrées par l'utilisateur 

        System.out.println(" ta custo est fini ! tu ressembleras à ca :"); // on affiche les caractéristiques du joueur

        System.out.println("Nom : " + joueur.getNom()); // on affiche le nom du joueur
        System.out.println("Symbole : " + joueur.getSymb()); // on affiche le symbole du joueur
        System.out.println("Couleur : " + joueur.getCouleur()); // on affiche la couleur du joueur

        State_Game.setGameState(State_Game.PLAYING);
        return this;
 
    }*/

