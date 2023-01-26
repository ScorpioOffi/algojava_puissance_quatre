package game.classes;

public class Pion {

    protected Joueur joueur;
    protected String symbole;
    protected String couleur;
    protected Case laCase;


    public Case getLaCase(){
        return laCase;
    }

    public void setLaCase(Case laCase) {
        this.laCase = laCase;
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
