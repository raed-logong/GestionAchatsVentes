package models;

import java.util.ArrayList;

public class Client extends Entity {
    private String code;
    //private ArrayList<Produit> p;

    public Client(String matricule, String raison, String type,
                  ArrayList<BankAccount> bankAccounts, Address address
            , String fax, String numFix, String numPortable,
                  Boolean etat, String code) {
        super(matricule, raison, type, bankAccounts, address, fax, numFix, numPortable, etat);
        this.code = code;
    }

    public Client(String matricule, String raison, String type,
                  ArrayList<BankAccount> bankAccounts,
                  Address address, String fax,
                  String numFix, String numPortable, String email,
                  String siteWeb, Boolean etat, String code) {
        super(matricule, raison, type, bankAccounts, address, fax, numFix, numPortable, email, siteWeb, etat);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getRaison();
    }
}
