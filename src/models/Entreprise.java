package models;

import java.util.ArrayList;

public class Entreprise extends Entity {
    private String description;

    public Entreprise(String matricule, String raison, String type, ArrayList<BankAccount> bankAccounts, Address address, String fax, String numFix, String numPortable, Boolean etat, String description) {
        super(matricule, raison, type, bankAccounts, address, fax, numFix, numPortable, etat);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }


}
