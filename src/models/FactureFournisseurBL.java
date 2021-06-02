package models;

import java.sql.Date;
import java.util.ArrayList;

public class FactureFournisseurBL extends Facture {
    Client fournisseur;
    ArrayList<BonFournisseur> bonsreceptions;
    String modepayment;
    double totalhorstva = 0;
    double tva = 0;
    double total = 0;

    public FactureFournisseurBL(int id, String code, Client fournisseur, Date date, String modepayement, ArrayList<BonFournisseur> bonsreceptions) {
        super(id, code, date);
        this.fournisseur = fournisseur;
        this.modepayment = modepayement;
        this.bonsreceptions = bonsreceptions;
        for (int i = 0; i < bonsreceptions.size(); i++) {
            totalhorstva += bonsreceptions.get(i).getPrixhorstva();
            tva += bonsreceptions.get(i).getTvatotal();
        }
        total = totalhorstva + tva;
    }

    public ArrayList<BonFournisseur> getBonsreceptions() {
        return bonsreceptions;
    }

    public void setBonsreceptions(ArrayList<BonFournisseur> bonsreceptions) {
        this.bonsreceptions = bonsreceptions;
    }

    public Client getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Client fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getModepayment() {
        return modepayment;
    }

    public void setModepayment(String modepayment) {
        this.modepayment = modepayment;
    }

    public double getTotalhorstva() {
        return totalhorstva;
    }

    public void setTotalhorstva(double totalhorstva) {
        this.totalhorstva = totalhorstva;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
