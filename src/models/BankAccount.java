package models;

public class BankAccount {
    private String bankname;
    private String agence;
    private String RIB;

    public BankAccount(String RIB, String bankname, String agence) {
        this.bankname = bankname;
        this.agence = agence;
        this.RIB = RIB;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public String getRIB() {
        return RIB;
    }

    public void setRIB(String RIB) {
        this.RIB = RIB;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankname='" + bankname + '\'' +
                ", agence='" + agence + '\'' +
                ", RIB='" + RIB + '\'' +
                '}';
    }
}
