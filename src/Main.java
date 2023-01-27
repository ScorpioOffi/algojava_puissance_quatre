import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Jeu jeu;
    public static Joueur player_1;
    public static Joueur player_2;

    public static void main(String[] args) throws IOException, ParseException{
        choixMode();
        jeu = new Jeu(player_1, player_2);
        player_1.setJeu(jeu);
        player_2.setJeu(jeu);
        boolean victoire;
        affichergrille();
        do {
            victoire = tour();
            affichergrille();
        }while (!victoire);

        if(player_2.getCoups() != 21){ 
            if(player_1.getCoups() == player_2.getCoups()){ 
                Victoire(player_2);
                player_2.enregistrer();
            }else{
                Victoire(player_1);
                player_1.enregistrer();
            } 
        }

    }

    public static void choixMode() throws FileNotFoundException, IOException, ParseException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println(Color.BLEU + "----- " + Color.CYAN + "PUISSANCE 4 - MENU PRINCIPAL" + Color.BLEU + " ----" + Color.RESET);
        System.out.println(Color.CYAN + "1 " + Color.BLEU + "| Jouer 1 contre 1" + Color.RESET);
        System.out.println(Color.CYAN + "2 " + Color.BLEU + "| Jouer contre l'IA" + Color.RESET);
        System.out.println(Color.CYAN + "4 " + Color.BLEU + "| Lister le top 10" + Color.RESET);
        System.out.println(Color.CYAN + "Q " + Color.BLEU + "| Quitter" + Color.RESET);
        int choice;
        do {
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                if (choice == 2){
                    select_level_IA();
                }
                if (choice == 4){
                    Joueur.lister();
                    break;
                }
            }else{
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 1 && choice != 3 && choice != 4);

        player_1 = creerJoueur(1, "","", choice !=3);
        player_2 = creerJoueur(2, "", "", choice == 1);
        
    }

    public static void Victoire(Joueur gagnant){
        System.out.println(Color.CYAN + gagnant.getNom() + Color.VERT + " a gagné en " + Color.CYAN + gagnant.getCoups2() + Color.VERT + " coups !");
    }


    public static Joueur creerJoueur(int idJoueur, String symbole, String couleur, boolean humain){

        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format(Color.BLEU + "Nom joueur " + Color.CYAN +"%d" + Color.BLEU + " :" + Color.RESET, idJoueur));
        String nom = scanner.nextLine();

        Scanner scan = new Scanner(System.in);
        System.out.println(String.format(Color.BLEU + "Symbole joueur " + Color.CYAN + "%d" + Color.BLEU +" :" + Color.RESET, idJoueur));
        symbole = scan.nextLine().substring(0,1);

        Scanner scan_ = new Scanner(System.in);
        System.out.println(String.format(Color.BLEU + "Couleur joueur " + Color.CYAN + "%d" + Color.BLEU +  " :" + Color.RESET, idJoueur));
        System.out.println(String.format(Color.JAUNE + "[ Jaune ]" + Color.RESET));
        System.out.println(String.format(Color.ROUGE + "[ Rouge ]" + Color.RESET));
        System.out.println(String.format(Color.BLEU + "[ Bleu ]" + Color.RESET));
        System.out.println(String.format(Color.VIOLET + "[ Violet ]" + Color.RESET));
        System.out.println(String.format(Color.RESET + "[ Blanc ]"));
        couleur = scan_.nextLine();
        switch(couleur){
            case "1":
                couleur = Color.JAUNE;
            case "2":
                 couleur = Color.ROUGE;
            case "3":
                 couleur = Color.BLEU;
            case "4":
                 couleur = Color.VIOLET;
            case "5":
                couleur = Color.RESET;
        }
        return new Joueur(symbole, nom, couleur);
    }

    public static void affichergrille() {

        Position[][] grille = jeu.getGrille();
        String legrille = "                            \n"; // A renommer
        //String colonne = "";
        for (int lgn = 6; lgn >= 1; lgn--){
            String ligne = String.valueOf(" ") + " ";
            for (int colonne = 0; colonne <=6; colonne++){
                Position laCase = grille[colonne][lgn-1];
                String affiche;
                if(laCase.getPion() == null){
                    affiche = ".";
                } else {
                    affiche = laCase.getPion().getCouleur() + laCase.getPion().getSymbole() + Color.RESET;
                } 
                ligne += " " + affiche + " ";
            }
            legrille += ligne + "\n";
        }
        System.out.println(legrille);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean tour() {
        Scanner scanner = new Scanner(System.in);
        Joueur joueur = jeu.tourJoueur();

        boolean valide;
        do {
            char choixColonne;
            do {
                System.out.println(String.format(Color.BLEU + "Coup n°" + Color.CYAN + "%d" + Color.BLEU + " de " + Color.CYAN + "%s" + Color.BLEU + " :", joueur.getCoups(), joueur.getNom()));
                choixColonne = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
            }while (choixColonne <'A' || choixColonne > 'G');
            valide = joueur.placePion(choixColonne);
        } while (!valide);

        return jeu.finTour(joueur.lastCoup());
    }

    public static void pause(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Color.BLEU + "Faites 'Entrer' pour le prochain coup");
        String nom = scanner.nextLine();
    }

    public static void select_level_IA() {
        System.out.println("\n");
        System.out.println(Color.BLEU + "----- " + Color.CYAN + " PUISSANCE 4 - IA Difficulty " + Color.BLEU + " ----" + Color.RESET);
        System.out.println(Color.CYAN + "1 " + Color.BLEU + " | Niveau 1" + Color.RESET);
        System.out.println(Color.CYAN + "2 " + Color.BLEU + " | Niveau 2" + Color.RESET);
        System.out.println(Color.CYAN + "3 " + Color.BLEU + " | Niveau 2" + Color.RESET);
        System.out.println(Color.CYAN + "4 " + Color.BLEU + " | Niveau 4" + Color.RESET);
        System.out.println(Color.CYAN + "R " + Color.BLEU + "| Retour" + Color.RESET);
    }
}
