package model;

import java.util.Scanner;

public class Joueur {

    private String nom;
    private String symbol;
    private String couleur;

    // ------------------------ GET

public class Joueur { // on commence par créer une classe joueur
    
    private static Scanner _scan = new Scanner(System.in);
    
    //on declare les variables de la classe joueur
    private String nom; // une variable nom de type String qui va nous permettre de stocker le nom du joueur
    private String symbol; // le meme principe pour la variable symbols qui va nous permettre de stocker le symbole du joueur
    private String couleur; // et la variable couleur qui va nous permettre de stocker la couleur du joueur
   
   

    // ON CRÉER LES METHODES DE LA CLASSE JOUEUR
    private String nom;
    private String symbol;
    private String couleur;

    // ------------------------ GET

    public String getNom() { // et pour la variable nom
        return nom;
    }

    public String getSymb() { // on crée une méthode getSymb qui va nous permettre de récupérer la valeur de la variable symbols
        return symbol;
    }

    public String getCouleur() { // on fait la même pour la variable couleur
        return couleur;
    }

    // ------------------------ SET

    public void setNom(String nom) { // définir la variable nom
        this.nom = nom;
    }

    public void setSymb(String symbol) { // on crée une méthode setSymb qui va nous permettre de définir la valeur de la variable symbols
        this.symbol = symbol;
    }

    public void setCouleur(String couleur) { // on fait la même pour la variable couleur
        this.couleur = couleur;
    }

    // --------------------------------------------------------------------------------------------------------------------

    public Joueur(String nom, String symbols, String couleur) { // on crée une méthode constructeur qui va nous permettre de créer un joueur
        this.nom = nom; // on initialise la variable nom
        this.symbol = symbols; // on initialise la variable symbols
        this.couleur = couleur;// on initialise la variable couleur
    }

    public void creerJoueur() { // on crée une méthode customisationJoueur qui va nous permettre de personnaliser le joueur
        
        boolean isOk = false; // on crée une variable isOk de type boolean qui va nous permettre de savoir si l'utilisateur a bien rentré les données demandées
    
        //Scanner scann = new Scanner(System.in); // on crée un scanner qui va nous permettre de récupérer les données entrées par l'utilisateur
    
    public static Joueur creerJoueur() { // on crée une méthode customisationJoueur qui va nous permettre de personnaliser le joueur
 
        Scanner scann = new Scanner(System.in); // on crée un scanner qui va nous permettre de récupérer les données entrées par l'utilisateur
        
            // choisir  ton pseudo
        System.out.println("Quel est votre nom ?"); // on demande à l'utilisateur de rentrer son nom
        String nom = scann.nextLine(); // on récupère le nom entré par l'utilisateur

    
         // choisir ton symbole
        System.out.println("Quel symbole souhaitez vous ?"); // on demande à l'utilisateur de rentrer son symbole
        String symbols = scann.nextLine(); // on récupère le symbole entré par l'utilisateur
       
      

        // choisir  ta couleur 
        System.out.println("Voici la liste des couleurs disponibles :"); 
        System.out.println( Color.JAUNE + "*----Jaune----*"+ Color.RESET);
        System.out.println( Color.BLEU + "*----Bleu----*"+ Color.RESET); 
        System.out.println( Color.VIOLET + "*----Violet----*"+ Color.RESET); 
        System.out.println( Color.ROUGE + "*----Rouge----*"+ Color.RESET); 
  
        System.out.println(" ");
        System.out.println("Quelle couleur souhaitez vous ?"); // on demande à l'utilisateur de rentrer sa couleur
        String couleur = scann.nextLine(); // on récupère la couleur entrée par l'utilisateur
        if(couleur=="jaune"){
            System.out.println(Color.JAUNE+"Votre couleur");
        }
        if(couleur=="bleu"){
            System.out.println(Color.BLEU+"Votre couleur");
        }
        if(couleur=="violet"){
            System.out.println(Color.VIOLET+"Votre couleur");
        }
        if(couleur=="rouge"){
            System.out.println(Color.ROUGE+"Votre couleur");
        }


                            String colorJoueur =
                            color1.nextLine();// on récupère la couleur entrée par l'utilisateur
                        

                        //changement de la couleur de l'objet celon la reponse donné
                        if (colorJoueur.toLowerCase().equals("bleu")) {
                            this.couleur = Color.BLEU;
                        } else if (colorJoueur.toLowerCase().equals("jaune")) {
                            this.couleur = Color.JAUNE;
                        } else if (colorJoueur.toLowerCase().equals("violet")) {
                            this.couleur = Color.VIOLET;
                        } else if (colorJoueur.toLowerCase().equals("rouge")) {
                            this.couleur = Color.ROUGE;
                        }

                        if (!(colorJoueur.toLowerCase().equals("rouge") || colorJoueur.toLowerCase().equals("violet") || colorJoueur.toLowerCase().equals("jaune") || colorJoueur.toLowerCase().equals("bleu"))) {
                            //si la reponse pour la couleur est differente des choix donné alors renvoie une erreur
                            System.out.println(Color.ROUGE+"\nCouleur non isOk car non reconnues! Veuillez réessayer !"+Color.RESET);//message d'erreur
                            
                        } else {
                            symbcolor = true;//si la couleur est isOk alors on passe a la variable suivante
                        }
                    }

        State_Game.setGameState(State_Game.PLAYING);
        return joueur;
    }
}