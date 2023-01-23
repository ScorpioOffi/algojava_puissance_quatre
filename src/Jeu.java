import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {

    private static Scanner _scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while(true) {
            afficher_menu_choice();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":
                    // Choisir 1 contre 1
                    afficher_menu_secondaire();
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
                            System.out.println("Entrez une commande valide");
                            break;
                    }
                    break;
                case "2":
                    // Choisir 1 contre l'IA
                    afficher_menu_secondaire();
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
}
