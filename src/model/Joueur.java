package model;

import java.util.Scanner;

public class Joueur {// on commence par créer une classe joueur
    boolean symbcolor = false;

    // on declare les variables de la classe joueur
    private String nom; // une variable nom de type String qui va nous permettre de stocker le nom d               
    private String symbol; // le meme principe pour la variable symbols qui va nous permettre de stocker l                    
    private String couleur; // et la variable couleur qui va nous permettre de stocker la couleur du joueur

    // ON CRÉER LES METHODES DE LA CLASSE JOUEUR
    public String getNom() { // et pour la variable nom
        return nom;
    }

    public String getSymb() { 
        
        Joueur SymbJoueur = new Joueur();

        Scanner symbol = new Scanner(System.in);
        System.out.println("\nQuel symbole souhaitez vous utiliser ?\n ["
                + symbcolor + "X" + Color.RESET +  symbcolor + "O" + Color.RESET + "]");
        String symbJoueur = symbol.nextLine();// on récupère la valeur entrée par l'utilisateur
        if (symbJoueur.equals("X") || symbJoueur.equals("O")) { // si la valeur entrée par l'utilisateur est égale à X ou O
            symbol = 
           symbcolor = true;
        } else {
            System.out.println("Veuillez entrer un symbole valide");
        }// on crée une méthode getSymb qui va nous permettre de récupérer la valeur de
                              // la variable symbols

        return Symbjoueur;
    }

    public String getCouleur() { // on fait la même pour la variable couleur

        return couleur;
    }
   

    public static Joueur creerJoueur() { // on crée une méthode customisationJoueur qui va nous permettre de
                                       // personnaliser le joueur

        // boolean isOk = false; // on crée une variable isOk de type boolean qui va
        // nous permettre de savoir si l'utilisateur a bien rentré les données demandées
        // Scanner scann = new Scanner(System.in); // on crée un scanner qui va nous
        // permettre de récupérer les données entrées par l'utilisateur
        // personnalisation des couleurs

        // isOk = false;
        // while(!isOk){
        Joueur joueur = new Joueur();

        
        

        // on crée une variable isOk de type boolean qui va nous permettre de savoir si
        // l'utilisateur a bien rentré les données demandées
        while (!joueur.symbcolor) { // tant que la couleur n'est pas isOk
            Scanner Couleur = new Scanner(System.in);

            System.out.println(
                    "\nQuelle couleur souhaitez vous utiliser ?\nVous pouvez choisir parmis les couleurs suivantes : ["
                            + Color.BLEU + "Bleu" + Color.RESET + ", " + Color.JAUNE + "Jaune" + Color.RESET + ", "
                            + Color.VIOLET + "Violet" + Color.BLEU + " et " + Color.ROUGE + "Rouge" + Color.RESET
                            + "]");

            String colorJoueur = Couleur.nextLine();// on récupère la couleur entrée par l'utilisateur

            // changement de la couleur de l'objet celon la reponse donné
            if (colorJoueur.toLowerCase().equals("bleu")) {
                joueur.couleur = Color.BLEU;
            }
            if (colorJoueur.toLowerCase().equals("jaune")) {
                joueur.couleur = Color.JAUNE;
            }
            if (colorJoueur.toLowerCase().equals("violet")) {
                joueur.couleur = Color.VIOLET;
            }
            if (colorJoueur.toLowerCase().equals("rouge")) {
                joueur.couleur = Color.ROUGE;

            }

            if (!(colorJoueur.toLowerCase().equals("rouge") || colorJoueur.toLowerCase().equals("violet")
                    || colorJoueur.toLowerCase().equals("jaune") || colorJoueur.toLowerCase().equals("bleu"))) {
                // si la reponse pour la couleur est differente des choix donné alors renvoie
                // une erreur
                System.out.println(
                        Color.ROUGE + "\nCouleur non reconnues! Veuillez réessayer !" + Color.RESET);// message
                                                                                                                  // d'erreur

            } else {
                joueur.symbcolor = true;// si la couleur est isOk alors on passe a la variable suivante
            }
        }



       
         

        

        
        return joueur;
    }
}
