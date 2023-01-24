package model;

import java.util.Scanner;


public class Joueur { // on commence par créer une classe joueur
    
    
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

    public Joueur(String nom, String symbols, String couleur) { // on crée une méthode constructeur qui va nous permettre de créer un joueur
        this.nom = nom; // on initialise la variable nom
        this.symbol = symbols; // on initialise la variable symbols
        this.couleur = couleur; // on initialise la variable couleur
    }
    
    public static Joueur creerJoueur() { // on crée une méthode customisationJoueur qui va nous permettre de personnaliser le joueur
 
        Scanner scann = new Scanner(System.in); // on crée un scanner qui va nous permettre de récupérer les données entrées par l'utilisateur
        
        System.out.println("Quel est votre nom ?"); // on demande à l'utilisateur de rentrer son nom
        String nom = scann.nextLine(); // on récupère le nom entré par l'utilisateur

        // choisir  ton pseudo
        System.out.println("Quel symbol souhaitez vous ?"); // on demande à l'utilisateur de rentrer son symbole
        String symbols = scann.nextLine(); // on récupère le symbole entré par l'utilisateur

        // choisir  ton sym
        System.out.println("Quel couleur veux-tu ?"); // on demande à l'utilisateur de rentrer sa couleur
        System.out.println("Voici la liste des couleurs disponibles :"); 
        System.out.println( Color.JAUNE + "\n *----Jaune----* \n"+ Color.RESET);
        System.out.println( Color.BLEU + "\n *----Bleu----* \n"+ Color.RESET); 
        System.out.println( Color.VIOLET + "\n *----Violet----* \n"+ Color.RESET); 
        System.out.println( Color.ROUGE + "\n *----Rouge----* \n"+ Color.RESET); 
        System.out.println( Color.VERT + "\n *----Vert----* \n"+ Color.RESET); 
        System.out.println(" ");
        System.out.println("Quel couleur souhaitez vous ?"); // on demande à l'utilisateur de rentrer sa couleur
        String couleur = scann.nextLine(); // on récupère la couleur entrée par l'utilisateur

       // choisir  ta couleurss
        Joueur joueur = new Joueur(nom, symbols, couleur);// on crée un joueur avec les données entrées par l'utilisateur 

        System.out.println(" ta custo est fini ! tu ressembleras à ca :"); // on affiche les caractéristiques du joueur

        System.out.println("Nom : " + joueur.getNom()); // on affiche le nom du joueur
        System.out.println("Symbole : " + joueur.getSymb()); // on affiche le symbole du joueur
        System.out.println("Couleur : " + joueur.getCouleur()); // on affiche la couleur du joueur

        State_Game.setGameState(State_Game.PLAYING);
        return joueur;
    }
}