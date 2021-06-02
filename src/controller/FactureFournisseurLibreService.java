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

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class FactureFournisseurLibreService extends BonFournisseurService {
    public FactureFournisseurLibreService() {
        this.tablename = TableNames.facturefournisseurlibre;
        this.produit_tablename = TableNames.facturefournisseur_produit;
        this.stock = 1;
    }

    public boolean setmodepayment(String code, String modepayement) {
        String sql = "update " + tablename + " set " +
                "modepayment=" + "'" + modepayement + "'" +
                " where code='" + code + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public boolean add(BonFournisseur E, String modepayement) {
        try {
            super.add(E);
            setmodepayment(E.getCode(), modepayement);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<FactureFournisseurLibre> gettout() {
        ArrayList<FactureFournisseurLibre> list = new ArrayList<>();
        BonFournisseur_ProduitServices bfps = new BonFournisseur_ProduitServices(produit_tablename);
        FournisseurService fs = new FournisseurService();
        ClientService cs = new ClientService();
        String sql1 = "select * from " + tablename;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            while (rs.next()) {
                Client fournisseur;
                if (stock == 1) {
                    fournisseur = fs.get(rs.getString("fournisseur"));
                } else {
                    fournisseur = cs.get(rs.getString("fournisseur"));
                }
                HashMap<Produit, Integer> map = bfps.getproducts(rs.getString("code"));
                FactureFournisseurLibre facture = new FactureFournisseurLibre(rs.getInt("id"),
                        rs.getString("code"), fournisseur,
                        rs.getDate("datedebon"), rs.getDate("datedereception"), new Address(),
                        rs.getString("information"), map, rs.getString("modepayment"));
                list.add(facture);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public FactureFournisseurLibre getone(String key) {
        FournisseurService fs = new FournisseurService();
        ClientService cs = new ClientService();
        String sql = "select * from " + tablename + " where code='" + key + "'";
        BonFournisseur_ProduitServices bfps = new BonFournisseur_ProduitServices(produit_tablename);
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Client fournisseur;
                if (stock == 1) {
                    fournisseur = fs.get(rs.getString("fournisseur"));
                } else {
                    fournisseur = cs.get(rs.getString("fournisseur"));
                }
                HashMap<Produit, Integer> map = bfps.getproducts(rs.getString("code"));
                return new FactureFournisseurLibre(rs.getInt("id"),
                        rs.getString("code"), fournisseur,
                        rs.getDate("datedebon"),
                        rs.getDate("datedereception"),
                        new Address(), rs.getString("information"), map,
                        rs.getString("modepayment"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
