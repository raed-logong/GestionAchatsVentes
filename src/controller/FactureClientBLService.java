package controller;

public class FactureClientBLService extends FactureFournisseurBLService {

    public FactureClientBLService() {
        this.tablename = TableNames.factureclientbl;
        this.bon_tablename = TableNames.factureclientbl_bon;
    }
}
