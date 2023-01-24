package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static Scanner _scan = new Scanner(System.in);

    public static void afficher_menus() {
        
        while(true) {
            afficher_menu_choice();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":
                    // Création du joueurs (nom, symbol, couleur)
                    Joueur.creerJoueur();
                    break;
                case "2":
                    // Choisir 1 contre l'IA
                    select_level_IA();
                    String choix2= _scan.nextLine();
                    switch(choix2) {
                        case "1":
                            // Choisir le nom
                            IA.level_1();
                            break;
                        case "2":
                            // Sélection du symbole
                            IA.level_2();
                            break;
                        case "3":
                            // Sélection de la couleur
                            IA.level_3();
                            break;
                        case "4":
                            // choisir la difficulté de l'IA
                            IA.level_4();
                            break;
                        case "r":
                            break;
                        default:
                            // Si aucune commande n'est reconnue
                            System.out.println("Entrez une commande valide");
                            break;
                    }
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Entrez une commande valide");
                    break;
            }
        }
    }

    public static void afficher_menu_choice() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("----- PUISSANCE 4 - MENU PRINCIPAL ----");
        menus.add("1- Jouer 1 contre 1");
        menus.add("2- Jouer contre l'IA");
        menus.add("q- Quitter");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void select_level_IA() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("----- PUISSANCE 4 - IA Difficulty ----");
        menus.add("1- Niveau 1");
        menus.add("2- Niveau 2");
        menus.add("3- Niveau 3");
        menus.add("4- Niveau 4");
        menus.add("r- retour");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }
}
package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    

    public static String ANSI_GREEN = "\u001B[32m";
    public static String ANSI_VIOLET = "\u001B[35m";
    public static String ANSI_JAUNE = "\u001B[33m";
    private static Scanner _scan = new Scanner(System.in);

    public static void afficher_menus() {

        while(true) {
            afficher_menu_choice();
            String choix = _scan.nextLine();
            System.out.println( "TEST?"  + ANSI_GREEN + "VERT " + "\t" + ANSI_JAUNE + "VIOLET"); 
            switch (choix) {
                case "1":
                    // Choisir 1 contre 1
                    String choix2= _scan.nextLine();
                    switch(choix2) {
                        case "1":
                            // Choisir le nom
                            insertion_nom();
                            break;
                        case "2":
                            // Sélection du symbole
                            select_symbol();
                            break;
                        case "3":
                            // Sélection de la couleur
                            select_color();
                            break;
                        case "4":
                            // Lancer la parrtie
                            start();
                            break;
                        case "m":
                            break;
                        default:
                            // Si aucune commande n'est reconnue
                            System.out.println("Entrez une commande valide ");
                            break;
                    }
                    break;
                case "2":
                    // Choisir 1 contre l'IA
                    String choix3= _scan.nextLine();
                    switch(choix3) {
                        case "1":
                            // Choisir le nom
                            insertion_nom();
                            break;
                        case "2":
                            // Sélection du symbole
                            select_symbol();
                            break;
                        case "3":
                            // Sélection de la couleur
                            select_color();
                            break;
                        case "4":
                            // choisir la difficulté de l'IA
                            select_level_IA();
                            break;
                        case "m":
                            break;
                        default:
                            // Si aucune commande n'est reconnue
                            System.out.println("Entrez une commande valide");
                            break;
                    }
                    break;
                case "m":
                    return;
                default:
                    System.out.println("Entrez une commande valide");
                    break;
            }
        }
    }

    public static void afficher_menu_choice() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("----- PUISSANCE 4 - MENU PRINCIPAL ----");
        menus.add("1- Jouer 1 contre 1");
        menus.add("2- Jouer contre l'IA");
        menus.add("q- Quitter");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void insertion_nom() {

    }

    public static void select_symbol() {

    }

    public static void select_color() {

    }

    public static void select_level_IA() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("----- PUISSANCE 4 - IA Difficulty ----");
        menus.add("1- Niveau 1");
        menus.add("2- Niveau 2");
        menus.add("3- Niveau 3");
        menus.add("m- retour");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void start() {

    }
}