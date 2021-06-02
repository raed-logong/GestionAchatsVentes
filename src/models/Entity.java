package models;


import java.util.ArrayList;

public abstract class Entity {
    private String matricule;
    private String raison;
    private String type;
    private ArrayList<BankAccount> bankAccounts;
    private Address address;
    private String fax;
    private String numFix;
    private String numPortable;
    private String email = null;
    private String siteWeb = null;
    private Boolean etat;

    public Entity(String matricule, String raison, String type,
                  ArrayList<BankAccount> bankAccounts, Address address,
                  String fax, String numFix,
                  String numPortable, String email,
                  String siteWeb, Boolean etat) {
        this.matricule = matricule;
        this.raison = raison;
        this.type = type;
        this.bankAccounts = bankAccounts;
        this.address = address;
        this.fax = fax;
        this.numFix = numFix;
        this.numPortable = numPortable;
        this.email = email;
        this.siteWeb = siteWeb;
        this.etat = etat;
    }

    public Entity(String matricule, String raison, String type,
                  ArrayList<BankAccount> bankAccounts,
                  Address address,
                  String fax, String numPortable,
                  String numFix, Boolean etat) {
        this.matricule = matricule;
        this.raison = raison;
        this.type = type;
        this.bankAccounts = bankAccounts;
        this.address = address;
        this.fax = fax;
        this.numFix = numFix;
        this.numPortable = numPortable;
        this.etat = etat;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNumFix() {
        return numFix;
    }

    public void setNumFix(String numFix) {
        this.numFix = numFix;
    }

    public String getNumPortable() {
        return numPortable;
    }

    public void setNumPortable(String numPortable) {
        this.numPortable = numPortable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "matricule='" + matricule + '\'' +
                ", raison='" + raison + '\'' +
                ", type='" + type + '\'' +
                ", bankAccounts=" + bankAccounts +
                ", address=" + address +
                ", fax='" + fax + '\'' +
                ", numFix='" + numFix + '\'' +
                ", numPortable='" + numPortable + '\'' +
                ", email='" + email + '\'' +
                ", siteWeb='" + siteWeb + '\'' +
                ", etat=" + etat +
                '}';
    }

}
