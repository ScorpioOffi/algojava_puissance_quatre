package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Score {
    
    private int score;
    private Joueur joueur;

    public Score() {
    }

    // ------------------------------------------------ 1 contre 1

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public static ArrayList<Score> creerListe() {
        ArrayList<Score> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("algojava_puissance_quatre/src/game.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split("; ");
                Score score = new Score();
                Joueur joueur = new Joueur(line, null, null);
                joueur.setNom(data[0]);
                score.setJoueur(joueur);
                score.setScore(Integer.valueOf(data[1]));
                list.add(score);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static ArrayList<Score> listeOrdre() {
        ArrayList<Score> list = creerListe();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getScore() > list.get(j).getScore()) {
                    Score temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static ArrayList<Score> supprListe() {
        ArrayList<Score> list = creerListe();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getScore() > list.get(j).getScore()) {
                    Score temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    // ------------------------------------------------ 1 contre IA

    public int getScore_IA() {
        return score;
    }

    public void setScore_IA(int score) {
        this.score = score;
    }

    public Joueur getJoueur_IA() {
        return joueur;
    }

    public void setJoueur_IA(Joueur joueur) {
        this.joueur = joueur;
    }

    public static ArrayList<Score> creerListe_IA() {
        ArrayList<Score> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("algojava_puissance_quatre/src/game_ia.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split("; ");
                Score score = new Score();
                Joueur joueur = new Joueur(line, null, null);
                joueur.setNom(data[0]);
                score.setJoueur(joueur);
                score.setScore(Integer.valueOf(data[1]));
                list.add(score);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static ArrayList<Score> listeOrdre_IA() {
        ArrayList<Score> list = creerListe();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getScore() > list.get(j).getScore()) {
                    Score temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static ArrayList<Score> supprListe_IA() {
        ArrayList<Score> list = creerListe();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getScore() > list.get(j).getScore()) {
                    Score temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
 
    // -------------------------------------------------------------


}