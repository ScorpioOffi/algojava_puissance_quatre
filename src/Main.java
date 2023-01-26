import model.*;

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
        choixMode();
        jeu = new Jeu(joueur1, joueur2);
        joueur1.setJeu(jeu);
        joueur2.setJeu(jeu);
        boolean victoire;
        affichergrille();
        do {
            victoire = tour();
            affichergrille();
        }while (!victoire);

        if(joueur2.getCoups() != 21){ 
            if(joueur1.getCoups() == joueur2.getCoups()){ 
                Victoire(joueur2);
                joueur2.enregistrer();
            }else{
                Victoire(joueur1);
                joueur1.enregistrer();
            } 
        }

    }

    public static void choixMode() throws FileNotFoundException, IOException, ParseException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("----- PUISSANCE 4 - MENU PRINCIPAL ----");
        System.out.println("1- Jouer 1 contre 1");
        System.out.println("2- Jouer contre l'IA");
        System.out.println("4-Lister le top 10");
        System.out.println("q- Quitter");
        int choix;
        do {
            if(scanner.hasNextInt()){
                choix = scanner.nextInt();
                if (choix == 2){
                    select_level_IA();
                }
                if (choix == 4){
                    Joueur.lister();
                    break;
                }
            }else{
                scanner.nextLine();
                choix = 0;
            }
        }while (choix != 1 && choix != 3 && choix != 4);

        joueur1 = creerJoueur(1, "","", choix !=3);
        joueur2 = creerJoueur(2, "", "", choix == 1);
        
    }

    public static void Victoire(Joueur gagnant){
        System.out.println(gagnant.getNom() + " a gagné en " + gagnant.getCoups2() + " coups !");
    }


    public static Joueur creerJoueur(int idJoueur, String symbole, String couleur, boolean humain){

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
            case "1":
                 couleur = "\u001B[31m";

            case "2":
                 couleur = "\u001B[33m";
            case "3":
                 couleur = "\u001B[34m";
            case "4":
                 couleur = "\u001B[35m";
            case "5":
                couleur = "\u001B[35m";
        }
        return new Joueur(symbole, nom, couleur);
    }

    public static void affichergrille(){

        Case[][] grille = jeu.getGrille();
        String legrille = "                            \n"; // A renommer
        //String colonne = "";
        for (int lgn = 6; lgn >= 1; lgn--){
            String ligne = String.valueOf(" ") + " ";
            for (int colonne = 0; colonne <=6; colonne++){
                Case laCase = grille[colonne][lgn-1];
                String affiche;
                if(laCase.getPion() == null){
                    affiche = ".";
                }else{
                    affiche = laCase.getPion().getCouleur() + laCase.getPion().getSymbole() + "\u001B[0m";
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
    public static void select_level_IA() {
        System.out.println("\n");
        System.out.println("----- PUISSANCE 4 - IA Difficulty ----");
        System.out.println("1- Niveau 1");
        System.out.println("2- Niveau 2");
        System.out.println("3- Niveau 2");
        System.out.println("4- Niveau 4");
        System.out.println("r- Retour");
    }
}
