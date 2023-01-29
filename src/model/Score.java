package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Score {
    
    private int score;
    private Joueur joueur;

    // ------------------------------------------------ 1 contre 1

    /**
     * Récupérer le score du joueur
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Ajouter un score au joueur
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Récupérer le joueur
     * @return
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Désigner le joueur
     * @param joueur
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    /**
     * Création de la liste du classement
     * @return
     */
    public static ArrayList<Score> creerListe() {
        ArrayList<Score> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("algojava_puissance_quatre/src/game.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split("; ");
                Score score = new Score();
                Joueur joueur = new Joueur(line, null, null);
                joueur.setNom();
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

    /**
     * Classement dans l'ordre des meilleurs scores
     * @return
     */
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

    /**
     * Supprimer la liste du classement 
     * @return
     */
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

    /**
     * Afficher le classement dans l'ordre
     */
    private static void afficherListe() {
        ArrayList<Score> list = Score.listeOrdre();
        if (list.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println((i+1) + " - " + list.get(i).getJoueur().getNom() + " : " + list.get(i).getScore());
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + " - " + list.get(i).getJoueur().getNom() + " : " + list.get(i).getScore());
            }
        }
    }

    // ------------------------------------------------ 1 contre IA

    /**
     * Récupérer le score du joueur contre l'IA
     * @return
     */
    public int getScore_IA() {
        return score;
    }

    /**
     * Ajouter un score au joueur contre l'IA
     * @param score
     */
    public void setScore_IA(int score) {
        this.score = score;
    }

    /**
     * Récupérer le joueur contre l'IA
     * @return
     */
    public Joueur getJoueur_IA() {
        return joueur;
    }

    /**
     * Désigner le joueur contre l'IA
     * @param joueur
     */
    public void setJoueur_IA(Joueur joueur) {
        this.joueur = joueur;
    }

    /**
     * Création de la liste du classement contre l'IA
     * @return
     */
    public static ArrayList<Score> creerListe_IA() {
        ArrayList<Score> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("algojava_puissance_quatre/src/game_ia.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split("; ");
                Score score = new Score();
                Joueur joueur = new Joueur(line, null, null);
                Joueur.setNom();
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

    /**
     * Classement dans l'ordre des meilleurs scores contre l'IA
     * @return
     */
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

    /**
     * Supprimer la liste du classement contre l'IA
     * @return
     */
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

    /**
     * Afficher le classement contre l'IA dans l'ordre
     */
    private static void afficherListe_IA() {
        ArrayList<Score> list = Score.listeOrdre();
        if (list.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println((i+1) + " - " + list.get(i).getJoueur().getNom() + " : " + list.get(i).getScore());
            }
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + " - " + list.get(i).getJoueur().getNom() + " : " + list.get(i).getScore());
            }
        }
    }
 
    // -------------------------------------------------------------


}