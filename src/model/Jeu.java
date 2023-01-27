package model;

public class Jeu {
    int colonne = 7;
    int ligne = 6;
    Position[][] grille;
    private Joueur joueur1;
    private Joueur joueur2;


    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }
    
    private int tour = 0;

    public Jeu(Joueur joueur1, Joueur joueur2){
        grille = new Position[colonne][ligne];
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        InitialiserGrille();
    }

    public Jeu() {
        grille = new Position[colonne][ligne];
        InitialiserGrille();
    }

    public int getTour() {
        return tour;
    }

    public void InitialiserGrille() {
        for (int colonne = 0; colonne <=6; colonne++){
            for (int ligne=1; ligne<=6; ligne++){
                char c =  (char)(colonne + 65);
                grille[colonne][ligne-1] = new Position(this, String.valueOf(c), String.valueOf(ligne));
            }
        }

        for (int colonne = 0; colonne <=6; colonne++){
            for (int ligne=0; ligne<=5; ligne++){
                grille[colonne][ligne].setVoisins();
            }
        }

    }

    public Position[][] getGrille() {
        return grille;
    }

    public Position getCase(int colonne, int ligne) {
        return grille[colonne][ligne];
    }

    public Position getCase(char colonne, int ligne) {
        return grille[colonne-65][ligne-1];
    }

    public Position case_vide(char nColonne) { // Alléger ?
        boolean libre = false;
        int nLigne = 1;
        Position caseLibre = null;
        while (!libre && nLigne<=6){
            if(this.getCase(nColonne, nLigne).getPion() == null){
                caseLibre = this.getCase(nColonne, nLigne);
                libre = true;
            }
            else nLigne++;
        }
        return caseLibre;
    }

    public Joueur tourJoueur() {
        tour++;
        if (tour%2 != 0){
            return joueur1;
        }else{
            return joueur2;
        } 
    }

    public boolean finTour(Position caseJouee) { // Reprendre la case jouée dans la procédure ?
        return caseJouee.compteAllignements() == 3;
    }

    public Position getCase(String Id) {
        return grille[Id.charAt(0)-65][Integer.parseInt(Id.substring(1))-1];
    }


}