package model;

public class Pion {

    protected Joueur joueur;
    protected String symbole;
    protected String couleur;
    protected Position Case;


    public Position getCase(){
        return Case;
    }

    public void setCase(Position Case) {
        this.Case = Case;
    }


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
}