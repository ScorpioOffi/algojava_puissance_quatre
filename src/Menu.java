import java.util.ArrayList;

public class Menu {

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

    public static void afficher_menu_secondaire() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("----- PUISSANCE 4 - MENU Secondaire ----");
        menus.add("1- Choisir le nom");
        menus.add("2- Sélectionner le symbole");
        menus.add("3- Sélectionner la couleur");
        menus.add("4- Lancer la partie");
        menus.add("m- retour");
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
