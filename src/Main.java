import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Color;
import model.Grille;
import model.IA;
import model.Joueur;
import model.Pion;

public class Main {
    private static Scanner _scan = new Scanner(System.in);
    /**
     * Étapes du jeu avec les sous menus
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        while(true) {
            afficher_menu_choice();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":
                Grille grille  = new Grille();
                Joueur joueur = Joueur.creerJoueur();
                grille.ajouterPion(joueur.getSymbole(), 0);
                grille.afficherGrille();
                
                    
                    break;
                case "2":
                    // Choisir 1 contre l'IA
                    select_level_IA();
                    String choix2= _scan.nextLine();
                    switch(choix2) {
                        case "1":
                            // Choisir le nom
                            //IA.level_1();
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

    

    /**
     * Affichage du menu principal
     */
    public static void afficher_menu_choice() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add(Color.BLEU + "----- " + Color.CYAN + "PUISSANCE 4 - MENU PRINCIPAL" + Color.BLEU + " ----" + Color.RESET);
        menus.add(Color.BLEU + "[" + Color.CYAN + "1" + Color.BLEU + "] Jouer 1 contre 1" + Color.RESET);
        menus.add(Color.BLEU + "[" + Color.CYAN + "2" + Color.BLEU + "] Jouer contre l'IA" + Color.RESET);
        menus.add(Color.BLEU + "[" + Color.ROUGE + "Q" + Color.BLEU + "] Quitter" + Color.RESET);
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    /**
     * Sélection de l'IA
     */
    public static void select_level_IA() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add(Color.BLEU + "----- " + Color.CYAN + "PUISSANCE 4 - IA Difficulty" + Color.BLEU + " ----" + Color.RESET);
        menus.add(Color.BLEU + "[" + Color.CYAN + "1" + Color.BLEU + "] Niveau 1" + Color.RESET);
        menus.add(Color.BLEU + "[" + Color.CYAN + "2" + Color.BLEU + "] Niveau 2" + Color.RESET);
        menus.add(Color.BLEU + "[" + Color.CYAN + "3" + Color.BLEU + "] Niveau 3" + Color.RESET);
        menus.add(Color.BLEU + "[" + Color.CYAN + "4" + Color.BLEU + "] Niveau 4" + Color.RESET);
        menus.add(Color.BLEU + "[" + Color.ROUGE + "R" + Color.BLEU + "] retour" + Color.RESET);
        for (String menu : menus) {
            System.out.println(menu);
        }
    }
}