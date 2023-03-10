package model;

import java.util.Scanner;

public class Joueur {

    private static String nom;
    private static String symbole;
    private static String couleur;

    /**
     * Prend en paramètres un nom un symbole, et une couleur et permet de créer un joueur
     * @param nom
     * @param symbole
     * @param couleur
     */
    public Joueur(String nom, String symbole, String couleur) {
        setNom();
        setSymbole(symbole);
        setCouleur(couleur);

    }

    /**
     * Renvoie le nom du joueur
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet au joueur de rentrer son nom avant de jouer
     * @return
     */
    public static String setNom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez votre nom");
        nom = input.nextLine();
        
        return nom;
    }

    /**
     * Renvoie le symbole choisi par le joueur
     * @return
     */
    public static String getSymbole() {
       
        return symbole;
    }

    /**
     * Permet au  joueur de rentrer son symbole avant de jouer
     * @param symbole
     * @return
     */
    public static String setSymbole(String symbole) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choisissez un symbole");
        symbole = input.nextLine();

        
        return symbole;
    }

    /**
     * Renvoie la couleur du joueur
     * @return
     */
    public String getCouleur() {
        return couleur;
    }
    

    /**
     * Permet au joueur de choisir la couleur de son pion
     * @param couleur
     * @return
     */
    public static String setCouleur(String couleur) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choisissez une couleur");
        return couleur;
    }


    /**
     * Fonction qui crée un joueur
     * @return
     */
    public static Joueur creerJoueur(){
        Joueur joueur = new Joueur(nom, symbole, couleur);
        return joueur;

    }
}    