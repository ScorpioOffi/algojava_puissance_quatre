package model;

import java.util.Scanner;

public class Joueur {

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
    
        //personnalisation des couleurs   
        
        isOk = false;
        while(!isOk){ // si la couleur n'est pas isOk

        Scanner scanncolor = new Scanner(System.in);// on crée un scanner qui va nous permettre de récupérer les données entrées par l'utilisateur

            if(scanncolor.hasNextInt()) { 
                int choixcouleurjoueur = scanncolor.nextInt();
                { 

                    boolean symbcolor= false;// on crée une variable isOk de type boolean qui va nous permettre de savoir si l'utilisateur a bien rentré les données demandées
                    while (!symbcolor) { //tant que la couleur n'est pas isOk
                        Scanner color1 = new Scanner(System.in);
                        
                        System.out.println("\nQuelle couleur souhaitez vous utiliser ?\nVous pouvez choisir parmis les couleurs suivantes : [" + Color.BLEU + "Bleu" + Color.RESET + ", " + Color.JAUNE + "Jaune" + Color.RESET + ", " + Color.VIOLET + "Violet" + Color.BLEU + " et " + Color.ROUGE + "Rouge" + Color.RESET + "]");

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

                }
            }
        }
    }
}