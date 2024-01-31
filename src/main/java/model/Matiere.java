package model;

public class Matiere {
    private final String code;
    private final String nom;
    private final int quantite;
    private final String unite;
    private final double achat;
    private final double vente;

    public Matiere(String code, String nom, int quantite, String unite, double achat, double vente) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
        this.achat = achat;
        this.vente = vente;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getUnite() {
        return unite;
    }

    public double getAchat() {
        return achat;
    }

    public double getVente() {
        return vente;
    }

    @Override
    public String toString(){
        return this.code + ", " + this.nom + ", " + this.quantite + this.unite + ", " + this.achat + ", " + this.vente;
    }
}

