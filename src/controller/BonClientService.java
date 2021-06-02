/*
 * Created By Raed Attia
 * Github : https://github.com/raed-logong
 */

/*
 * Created By Raed Attia
 * Github : https://github.com/raed-logong
 */


package controller;

public class BonClientService extends BonFournisseurService {
    public BonClientService() {
        this.tablename = TableNames.bonclient;
        this.produit_tablename = TableNames.bonclient_produit;
        this.stock = 0;
    }
}
