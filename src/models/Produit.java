package models;

public class Produit {
    private int id;
    private String reference;
    private String designation;
    private String unite;
    private Client fournisseur;
    private FamilleProduit familleProduit;
    private int stock;
    private int stockminimal;
    private double prixunitaire;
    private double tva;

    public Produit(int id, String reference, String designation,
                   String unite, Client fournisseur, FamilleProduit familleProduit,
                   int stock,
                   int stockminimal, double prixunitaire, double tva) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.unite = unite;
        this.fournisseur = fournisseur;
        this.familleProduit = familleProduit;
        this.stock = stock;
        this.stockminimal = stockminimal;
        this.prixunitaire = prixunitaire;
        this.tva = tva;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Client getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Client fournisseur) {
        this.fournisseur = fournisseur;
    }

    public FamilleProduit getFamilleProduit() {
        return familleProduit;
    }

    public void setFamilleProduit(FamilleProduit familleProduit) {
        this.familleProduit = familleProduit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockminimal() {
        return stockminimal;
    }

    public void setStockminimal(int stockminimal) {
        this.stockminimal = stockminimal;
    }

    public double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "reference='" + reference + '\'' +
                ", designation='" + designation + '\'' +
                ", unite='" + unite + '\'' +
                ", fournisseur=" + fournisseur +
                ", familleProduit=" + familleProduit +
                ", stock=" + stock +
                ", stockminimal=" + stockminimal +
                ", prixunitaire=" + prixunitaire +
                ", tva=" + tva +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;
        return this.reference.equals(((Produit) o).getReference());
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + reference.hashCode();

        return result;
    }
}
