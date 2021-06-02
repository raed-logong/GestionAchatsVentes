package models;

import java.sql.Date;
import java.util.HashMap;

public class FactureFournisseurLibre extends BonFournisseur {
    private String modepayment;


    public FactureFournisseurLibre(int id, String code, Client fournisseur, Date datedebon, Date datedereception, Address address, String information, HashMap<Produit, Integer> listeproduit, String modepayment) {
        super(id, code, fournisseur, datedebon, datedereception, address, information, listeproduit);
        this.modepayment = modepayment;
    }

    public String getModepayment() {
        return modepayment;
    }

    public void setModepayment(String modepayment) {
        this.modepayment = modepayment;
    }
}
