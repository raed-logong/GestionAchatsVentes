package models;

public class Address {
    private String numeroRue;
    private String libelle;
    private String ville;
    private String codePostal;
    private String gouvernourat;
    private String pays;

    public Address(String numeroRue, String libelle, String ville, String codePostal, String gouvernourat, String pays) {
        this.numeroRue = numeroRue;
        this.libelle = libelle;
        this.ville = ville;
        this.codePostal = codePostal;
        this.gouvernourat = gouvernourat;
        this.pays = pays;
    }

    public Address() {

    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getGouvernourat() {
        return gouvernourat;
    }

    public void setGouvernourat(String gouvernourat) {
        this.gouvernourat = gouvernourat;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Address{" +
                "numeroRue='" + numeroRue + '\'' +
                ", libelle='" + libelle + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", gouvernourat='" + gouvernourat + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
