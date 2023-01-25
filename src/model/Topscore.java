package model;

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
    
    // ---------------------------------------------------------------- 1 contre 1

    public static ArrayList<Joueur> getTop10() throws IOException, ParseException {
        ArrayList<Joueur> list = new ArrayList<>();
        try (BufferedReader buf = new BufferedReader(new FileReader("GestionnaireContacts/src/contacts.csv"))) {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                Joueur j = Joueur.creerJoueur();
                j.setNom(tab[0]);
                j.setSymb(ligne);(tab[1]);
                j.setCouleur(tab[2]);
                list.add(j);
                ligne = buf.readLine();
            }
        }
        return list;
    }

    public static void add_winner() {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("algojava_puissance_quatre/src/game.csv", true)));
        try {
            pw.println(this.toString());
        } finally {
            pw.close();
        }

        /*try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("contacts.csv", true)))) {
            pw.println(this.toString());
        }*/
    }

        // ---------------------------------------------------------------- IA

    public static void getTop10_IA() {

    }

    public static ArrayList<Joueur> lister() throws IOException, ParseException {
        ArrayList<Joueur> list = new ArrayList<>();
        try (BufferedReader buf = new BufferedReader(new FileReader("GestionnaireContacts/src/contacts.csv"))) {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                Joueurc c = new Joueur();
                c.setNom(tab[0]);
                c.setPrenom(tab[1]);
                c.setMail(tab[2]);
                c.setTelephone(tab[3]);
                c.setDateNaissance(tab[4]);
                list.add(c);
                ligne = buf.readLine();
            }
        }
        return list;
    }

    public static void add_winner_IA() {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("algojava_puissance_quatre/src/game_IA.csv", true)));
        try {
            pw.println(this.toString());
        } finally {
            pw.close();
        }

        /*try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("contacts.csv", true)))) {
            pw.println(this.toString());
        }*/
    }

    // ---------------------------------------------------------------- Builder

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(Joueur.nom);
        build.append(SEPARATEUR);
        build.append(Joueur.symbol);
        build.append(SEPARATEUR);
        build.append(Joueur.couleur);
        return build.toString();
    }
}
