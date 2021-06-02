package models;

import java.util.ArrayList;

public class Fournisseur extends Entity {
    private String code;
    // private ArrayList<Produit> p;

    public Fournisseur(String matricule, String raison, String type,
                       ArrayList<BankAccount> bankAccounts, Address address
            , String fax, String numFix, String numPortable,
                       Boolean etat, String code) {
        super(matricule, raison, type, bankAccounts, address, fax, numFix, numPortable, etat);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
