package game;
import game.classes.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Jeu jeu;
    public static Joueur joueur1;
    public static Joueur joueur2;

    public static void main(String[] args) throws IOException, ParseException{

        /*
        Initialisation
         */

        choixMode();
        jeu = new Jeu(joueur1, joueur2);
        joueur1.setJeu(jeu);
        joueur2.setJeu(jeu);

        /*
        Jeu
         */
        boolean victoire;
        afficherPlateau();
        do {
            victoire = tour();
            afficherPlateau();
        }while (!victoire);

        /*
        Résultat
         */
        if(joueur2.getCoups() != 21){ // pas match nul
            if(joueur1.getCoups() == joueur2.getCoups()){ // joueur2 gagne quand il a joué autant de coups que joueur1
                annonceVictoire(joueur2);
                joueur2.enregistrer();
            }else{
                annonceVictoire(joueur1);
                joueur1.enregistrer();
            } 
        }

    }

    public static void choixMode() throws FileNotFoundException, IOException, ParseException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("---------- MODE DE JEU -----------");
        System.out.println("| 1- Jouer à deux                |");
        System.out.println("| 2- Jouer face à l'ordi         |");
        System.out.println("----------------------------------");
        int choix;
        do {
            if(scanner.hasNextInt()){
                choix = scanner.nextInt();
                if (choix == 4){
                    Joueur.lister();
                    break;
                }
            }else{
                scanner.nextLine();
                choix = 0;
            }
        }while (choix != 1 && choix != 2 && choix != 3 && choix != 4);

        joueur1 = initJoueur(1, "","", choix !=3);
        joueur2 = initJoueur(2, "", "", choix == 1);
    }

    public static void annonceVictoire(Joueur gagnant){
        System.out.println(gagnant.getNom() + " a gagné en " + gagnant.getCoups2() + " coups !");
    }


    public static Joueur initJoueur(int idJoueur, String symbole, String couleur, boolean humain){

        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Nom joueur %d :", idJoueur));
        String nom = scanner.nextLine();

        Scanner scan = new Scanner(System.in);
        System.out.println(String.format("Symbole joueur %d :", idJoueur));
        symbole = scan.nextLine().substring(0,1);

        Scanner scan_ = new Scanner(System.in);
        System.out.println(String.format("Couleur joueur %d :", idJoueur));
        System.out.println(String.format("\u001B[31m1- Rouge"));
        System.out.println(String.format("\u001B[33m2- Jaune"));
        System.out.println(String.format("\u001B[34m3- Bleu"));
        System.out.println(String.format("\u001B[35m4- Violet"));
        System.out.println("\033[37m5- Blanc\033[37m");
        couleur = scan_.nextLine();
        switch(couleur){
            case "1" -> couleur = "\u001B[31m";
            case "2" -> couleur = "\u001B[33m";
            case "3" -> couleur = "\u001B[34m";
            case "4" -> couleur = "\u001B[35m";
            case "5" -> couleur = "\u001B[35m";
        }
        return new Joueur(symbole, nom, couleur);
    }

    public static void afficherPlateau(){

        Case[][] plateau = jeu.getPlateau();
        String lePlateau = "    A   B   C   D   E   F   G\n"; // A renommer
        //String colonne = "";
        for (int lgn = 6; lgn >= 1; lgn--){
            String ligne = String.valueOf(lgn) + " |";
            for (int colonne = 0; colonne <=6; colonne++){
                Case laCase = plateau[colonne][lgn-1];
                String affiche;
                if(laCase.getPion() == null){
                    affiche = " ";
                }else{
                    affiche = laCase.getPion().getCouleur() + laCase.getPion().getSymbole() + "\u001B[0m";
                } 
                ligne += " " + affiche + " |";
            }
            lePlateau += ligne + "\n";
        }
        System.out.println(lePlateau);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean tour(){
        Scanner scanner = new Scanner(System.in);
        Joueur joueur = jeu.tourJoueur();

        boolean valide;
        do {
            char choixColonne;
            do {
                System.out.println(String.format("Coup n°%d de %s :", joueur.getCoups(), joueur.getNom()));
                choixColonne = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
            }while (choixColonne <'A' || choixColonne > 'G');
            valide = joueur.placePion(choixColonne);
        }while (!valide);

        return jeu.finTour(joueur.lastCoup());
    }

    public static void pause(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tapez 'Entrer' pour le prochain coup");
        String nom = scanner.nextLine();
    }
}
