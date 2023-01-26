package model;

import java.util.ArrayList;

public class Menus {
    public static void afficher_menu_choice() {
        
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("----- PUISSANCE 4 - MENU PRINCIPAL ----");
        menus.add("[1] Jouer 1 contre 1");
        menus.add("[2] Jouer contre l'IA");
        menus.add("[Q] Quitter");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void select_level_IA() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("----- PUISSANCE 4 - IA Difficulty ----");
        menus.add("[1] Niveau 1");
        menus.add("[2] Niveau 2");
        menus.add("[3] Niveau 3");
        menus.add("[4] Niveau 4");
        menus.add("[R] retour");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }
}