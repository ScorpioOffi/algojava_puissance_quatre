/*package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

public class Topscore {

    private static final String SEPARATEUR = " - ";
    
    // ---------------------------------------------------------------- 1 contre 1 - Création listes et ordre

    public static ArrayList<Joueur> creerListe() {
        ArrayList<Joueur> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("algojava_puissance_quatre/src/game.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                Joueur j = new Joueur(line, line, line);
                Joueur joueur = new Joueur(line, null, null);
                joueur.setNom(data[0]);
                j.setNom(line);
                j.setSymb(line);
                j.setCouleur(line);
                j.setScore(Integer.valueOf(data[1]));
                list.add(j);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // ---------------------------------------------------------------- IA - Création listes et ordre

    public static ArrayList<Joueur> creerListe_IA() {
        ArrayList<Joueur> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("algojava_puissance_quatre/src/game_ia.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                Joueur j = new Joueur(line, line, line);
                Joueur joueur = new Joueur(line, null, null);
                joueur.setNom(data[0]);
                j.setNom(line);
                j.setSymb(line);
                j.setCouleur(line);
                j.setScore(Integer.valueOf(data[1]));
                list.add(j);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // ---------------------------------------------------------------- Lister, Affichage et Enregistrement

    public static ArrayList<Joueur> listeOrdre() {
        ArrayList<Joueur> list = creerListe();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getScore() > list.get(j).getScore()) {
                    Joueur temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("\nTop 10 des meilleurs scores :");
        return list;
    }

    public static ArrayList<Joueur> listeOrdre_IA() {
        ArrayList<Joueur> list = creerListe();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getScore() > list.get(j).getScore()) {
                    Joueur temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("\nTop 10 des meilleurs scores :");
        return list;
    }

    private static void afficherListe() {
        ArrayList<Joueur> list = listeOrdre();
        if (list.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println((i+1) + " - " + list.get(i).getNom() + " : " + list.get(i).getSymb() + " / " + list.get(i).getCouleur());
            }
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + " - " + list.get(i).getNom() + " : " + list.get(i).getSymb() + " / " + list.get(i).getCouleur());
            }
        }
    }
}*/
