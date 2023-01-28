package model;

public class Pion {


    protected Joueur joueur;
    protected String symbole;
    protected String couleur;


    /**
     * prend en paramètre un joueur et crée un pion
     * @param joueur
     */
    public Pion(Joueur joueur){
        this.joueur = joueur;
        symbole = joueur.getSymbole();
        couleur = joueur.getCouleur();
    }

    /**
     * renvoie le symbole du joueur
     * @return
     */
    public String getSymbole() {
        return symbole;
    }

    /**
     * renvoie la couleur  du joueur
     * @return
     */
    public String getCouleur() {
        return couleur;
    }
    /**
     * retourne le joueur
     * @param joueur
     */
    public void setPion(Joueur joueur) {
        this.joueur = joueur;
        }
        
    
    
}

