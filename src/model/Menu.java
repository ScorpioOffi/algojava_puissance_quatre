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
                    //Joueur.creerJoueur();
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