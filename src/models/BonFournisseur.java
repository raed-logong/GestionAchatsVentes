package models;

import java.sql.Date;
import java.util.HashMap;

public class BonFournisseur {
    private int id;
    private String code;
    private Client fournisseur;
    private Date datedebon;
    private Date datedereception;
    private Address address;
    private String information;
    private HashMap<Produit, Integer> listeproduit = new HashMap<>();
    private double prixhorstva = 0;
    private double tvatotal = 0;
    private double prixtotal = 0;

    public BonFournisseur(int id, String code, Client fournisseur, Date datedebon, Date datedereception, Address address, String information, HashMap<Produit, Integer> listeproduit) {
        this.id = id;
        this.code = code;
        this.fournisseur = fournisseur;
        this.datedebon = datedebon;
        this.datedereception = datedereception;
        this.address = address;
        this.information = information;
        this.listeproduit = listeproduit;
        listeproduit.forEach((produit, value) -> {
            this.prixhorstva += produit.getPrixunitaire() * value;
            tvatotal += ((produit.getTva() * produit.getPrixunitaire()) / 100) * value;
        });
        this.prixtotal = prixhorstva + tvatotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Client fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Date getDatedebon() {
        return datedebon;
    }

    public void setDatedebon(Date datedebon) {
        this.datedebon = datedebon;
    }

    public Date getDatedereception() {
        return datedereception;
    }

    public void setDatedereception(Date datedereception) {
        this.datedereception = datedereception;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public HashMap<Produit, Integer> getListeproduit() {
        return listeproduit;
    }

    public void setListeproduit(HashMap<Produit, Integer> listeproduit) {
        this.listeproduit = listeproduit;
    }

    public double getPrixhorstva() {
        return prixhorstva;
    }

    public void setPrixhorstva(double prixhorstva) {
        this.prixhorstva = prixhorstva;
    }

    public double getTvatotal() {
        return tvatotal;
    }

    public void setTvatotal(double tvatotal) {
        this.tvatotal = tvatotal;
    }

    public double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(double prixtotal) {
        this.prixtotal = prixtotal;
    }
}
