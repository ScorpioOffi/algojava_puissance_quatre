package model;

public class Pion {

    protected Joueur joueur;
    protected String symbole;
    protected String couleur;

    /**
     * Prend en paramètre un joueur et crée un pion
     * @param joueur
     */
    public Pion(Joueur joueur){
        this.joueur = joueur;
        symbole = joueur.getSymbole();
        couleur = joueur.getCouleur();
    }

    /**
     * Renvoie le symbole du joueur
     * @return
     */
    public String getSymbole() {
        return symbole;
    }

    /**
     * Renvoie la couleur  du joueur
     * @return
     */
    public String getCouleur() {
        return couleur;
    }
    
    /**
     * Retourne le joueur
     * @param joueur
     */
    public void setPion(Joueur joueur) {
        this.joueur = joueur;
    }
        
    
    
}

