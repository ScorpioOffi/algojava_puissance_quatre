package model;

public class Pion {


    protected Joueur joueur;
    protected String symbole;
    protected String couleur;


    public Pion(Joueur joueur){
        this.joueur = joueur;
        symbole = joueur.getSymbole();
        couleur = joueur.getCouleur();
    }

    public String getSymbole() {
        return symbole;
    }

    public String getCouleur() {
        return couleur;
    }
    public void setPion(Joueur joueur) {
        this.joueur = joueur;
        }
        
    
    
}

