package model;

import java.util.Scanner;

public class Joueur {

    private static String nom;
    private static String symbole;
    private static String couleur;

    public Joueur(String nom, String symbole, String couleur) {
        setNom();
        setSymbole(symbole);
        setCouleur(couleur);

    }

    public String getNom() {
        return nom;
    }

    public static String setNom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez votre nom");
        nom = input.nextLine();
        
        return nom;
    }

    public static String getSymbole() {
       
        return symbole;
    }

    public static String setSymbole(String symbole) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choisissez un symbole");
        symbole = input.nextLine();

        
        return symbole;
    }

    public String getCouleur() {
        return couleur;
    }
    

    public static String setCouleur(String couleur) {
        return couleur;
    }


    public static Joueur creerJoueur(){
        Joueur joueur = new Joueur(nom, symbole, couleur);
        return joueur;

    }
}    