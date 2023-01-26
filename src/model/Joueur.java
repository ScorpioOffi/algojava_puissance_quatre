package model;

import java.util.Scanner;

public class Joueur {

    private String nom;
    private String symbole;
    private String couleur;

    public Joueur(String nom, String symbole, String couleur) {
        this.nom = nom;
        this.symbole = symbole;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public static String setNom(String nom) {
        return nom;
    }

    public String getSymbole() {
        return symbole;
    }

    public static String setSymbole(String symbole) {
        return symbole;
    }

    public String getCouleur() {
        return couleur;
    }
    

    public static String setCouleur(String couleur) {
        return couleur;
    }





    public static void nom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez votre nom");
        String choix = input.nextLine();
        Joueur.setNom(choix);

    }


    public static void symbole() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nQuel symbole souhaitez vous utiliser ?\n "+Color.JAUNE +"X" + Color.RESET +Color.VIOLET + "O" + Color.RESET + "]");
        if (input.equals("X") || input.equals("O")) { // si la valeur entrée par l'utilisateur est égale à
             
        // X ou O
        String choix = input.nextLine();
       Joueur.setSymbole(choix);

        } else {
            System.out.println("Entrez un symbole valide");
        }
       
        


    }

    public static void couleur() {
        Scanner input = new Scanner(System.in);
        System.out.println(
            "\nQuelle couleur souhaitez vous utiliser ?\nVous pouvez choisir parmis les couleurs suivantes : ["
                    + Color.BLEU + "Bleu" + Color.RESET + ", " + Color.JAUNE + "Jaune" + Color.RESET + ", "
                    + Color.VIOLET + "Violet" + Color.BLEU + " et " + Color.ROUGE + "Rouge" + Color.RESET
                    + "]");

        String choix = input.nextLine();
        switch (choix) {
            case "1 ":
                System.out.println("Vous avez choisi la couleur bleu "+ Color.BLEU);
                setCouleur(choix);
                break;
            case "2":
                System.out.println("Vous avez choisi la couleur jaune"+ Color.JAUNE);
                break;
            case "3":
                System.out.println("Vous avez choisi la couleur rouge"+ Color.ROUGE);
                break;
            case "4":
                System.out.println("Vous avez choisi la couleur violet"+ Color.VIOLET);
                break;
            default:
                System.out.println(Color.ROUGE+"Entrez une couleur valide"+Color.RESET);
                break;
        }
        Joueur.setCouleur(choix);


    
    }

}