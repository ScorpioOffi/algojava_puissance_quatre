import java.util.Scanner;

import model.IA;
import model.Jeu;
import model.Joueur;
import model.Menus;
import model.State_Game;

public class Main {

    private static Scanner _scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        State_Game.setGameState(State_Game.WAITING);
        Jeu.Game();

        while(true) {
            Menus.afficher_menu_choice();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":
                    // Création du joueurs (nom, symbol, couleur)
                    Joueur.creerJoueur();
                    break;
                case "2":
                    // Choisir 1 contre l'IA
                    Joueur.creerJoueur();
                    Menus.select_level_IA();
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
}