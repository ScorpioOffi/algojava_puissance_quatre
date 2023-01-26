package game.classes;

public class Jeu {
    /*
     plateau
     */
    final int NB_COLONNES = 7;
    final int NB_LIGNES = 6;
    Case[][] plateau; // Case[2][3] = 2ème colonne, 3ème ligne


    /*
    Joueurs
     */
    private Joueur joueur1;
    private Joueur joueur2;


    public Joueur getJoueur1() {
        return joueur1;
    }
    public Joueur getJoueur2() {
        return joueur2;
    }
    

    // Tour
    private int tour = 0;

    public Jeu(Joueur joueur1, Joueur joueur2){
        plateau = new Case[NB_COLONNES][NB_LIGNES];
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        InitialiserPlateau();
    }

    public Jeu(){
        plateau = new Case[NB_COLONNES][NB_LIGNES];
        InitialiserPlateau();
    }

    public int getTour() {
        return tour;
    }

    public void InitialiserPlateau(){
        for (int colonne = 0; colonne <=6; colonne++){
            for (int ligne=1; ligne<=6; ligne++){
                char c =  (char)(colonne + 65);
                plateau[colonne][ligne-1] = new Case(this, String.valueOf(c), String.valueOf(ligne));
            }
        }

        for (int colonne = 0; colonne <=6; colonne++){
            for (int ligne=0; ligne<=5; ligne++){
                plateau[colonne][ligne].setVoisins();
            }
        }


    }

    /**
     * Retourne la plateau du jeu.
     * @return Case[Colonne][Ligne]
     */
    public Case[][] getPlateau(){
        return plateau;
    }

    /**
     * @param colonne L'id de la colonne de 0 à 6.
     * @param ligne L'id de la ligne de 0 à 5.
     * @return la case concernée.
     */
    public Case getCase(int colonne, int ligne){
        return plateau[colonne][ligne];
    }

    /**
     * @param colonne Charactère réel de A à G (de gauche à droite)
     * @param ligne Ligne réelle de 1 à 6 (de bas en haut)
     * @return la case concernée.
     */
    public Case getCase(char colonne, int ligne){
        return plateau[colonne-65][ligne-1];
    }

    /**
     * Détermine la première case disponble sur une colonne.
     * @param nColonne Colonne sur laquelle vérifier.
     * @return Première case disponible, ou null si aucune dispo.
     */
    public Case caseDispo(char nColonne){ // Alléger ?
        boolean libre = false;
        int nLigne = 1;
        Case caseLibre = null;
        while (!libre && nLigne<=6){
            if(this.getCase(nColonne, nLigne).getPion() == null){
                caseLibre = this.getCase(nColonne, nLigne);
                libre = true;
            }
            else nLigne++;
        }
        return caseLibre;
    }

    public Joueur tourJoueur(){
        tour++;
        if (tour%2 != 0){
            return joueur1;
        }else{
            return joueur2;
        } 
    }

    /**
     * Clos le trour en vérifiant si un joueur a gagné.
     * @param caseJouee Case jouée lors du tour.
     * @return True si victoire, false sinon.
     */
    public boolean finTour(Case caseJouee){ // Reprendre la case jouée dans la procédure ?
        return caseJouee.compteAllignements() == 3;
    }


    /**
     * Retourne la case à partir d'un identifiant.
     * @param Id Identifiant (A1 .. G6)
     * @return Case
     */
    public Case getCase(String Id){
        return plateau[Id.charAt(0)-65][Integer.parseInt(Id.substring(1))-1];
    }


}