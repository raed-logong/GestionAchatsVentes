package controller;

public class BonClientService extends BonFournisseurService {
    public BonClientService() {
        this.tablename = TableNames.bonclient;
        this.produit_tablename = TableNames.bonclient_produit;
        this.stock = 0;
    }
}
