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

/*
 * Created By Raed Attia
 */

package controller;

import database.Connect;
import models.Produit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BonFournisseur_ProduitServices {
    protected String tablename;
    Connection cn = Connect.getConnexion();
    Statement st = null;


    public BonFournisseur_ProduitServices(String tablename) {
        this.tablename = tablename;
    }

    public boolean add(String bon_id, Produit P, int quantite) {

        String sql = "insert into " + tablename + " (product_id, bon_code,quantite) VALUES (" +
                P.getId() + "," +
                "'" + bon_id + "'," +
                quantite + ")";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void addproducts(HashMap<Produit, Integer> list, String bon_id) {
        list.forEach((key, value) -> add(bon_id, key, value));
    }

    public boolean delete(String bon_id) {
        String sql = "delete from " + tablename + " where bon_code='" + bon_id + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public HashMap<Produit, Integer> getproducts(String key) {
        HashMap<Produit, Integer> hashMap = new HashMap<>();
        String sql = "select * from " + tablename + " where bon_code='" + key + "'";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ProduitService ps = new ProduitService();
            while (rs.next()) {
                hashMap.put(ps.getByid(rs.getInt("product_id")), rs.getInt("quantite"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hashMap;
    }

}

