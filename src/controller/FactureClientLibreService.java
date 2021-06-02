/*
 * Created By Raed Attia
 * Github : https://github.com/raed-logong
 */

/*
 * Created By Raed Attia
 * Github : https://github.com/raed-logong
 */

/*
 * Created By Raed Attia
 */

package controller;

public class FactureClientLibreService extends FactureFournisseurLibreService {
    public FactureClientLibreService() {
        this.tablename = TableNames.factureclientlibre;
        this.produit_tablename = TableNames.factureclient_produit;
        this.stock = 0;
    }
}
