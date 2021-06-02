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

import database.Connect;
import models.Address;
import models.BonFournisseur;
import models.Client;
import models.Produit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class BonFournisseurService implements Services<BonFournisseur> {
    protected String tablename = TableNames.bonfournisseur;
    protected String produit_tablename = TableNames.bonfournisseur_produit;
    protected int stock = 1;
    Connection cn = Connect.getConnexion();
    Statement st = null;
    ProduitService ps = new ProduitService();

    @Override
    public boolean add(BonFournisseur E) {
        String sql = "INSERT INTO " + tablename + "(code, fournisseur,datedereception, information) values (" +
                "'" + E.getCode() + "'," +
                "'" + E.getFournisseur().getCode() + "'," +
                "'" + E.getDatedereception() + "'," +
                "'" + E.getInformation() + "')";
        try {
            BonFournisseur_ProduitServices bfps = new BonFournisseur_ProduitServices(produit_tablename);
            st = cn.createStatement();
            st.executeUpdate(sql);
            bfps.addproducts(E.getListeproduit(), E.getCode());
            if (stock == 1) {
                E.getListeproduit().forEach((produit, value) -> {
                    ps.updatestock(produit.getReference(), value);
                });
            } else {
                E.getListeproduit().forEach((produit, value) -> {
                    ps.updatestock(produit.getReference(), -value);
                });
            }
            CodeService.updatecode();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean edit(BonFournisseur E) {

        return false;
    }

    @Override
    public boolean delete(String key) {

        return false;
    }

    @Override
    public BonFournisseur get(String key) {
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
                return new BonFournisseur(rs.getInt("id"),
                        rs.getString("code"), fournisseur,
                        rs.getDate("datedebon"),
                        rs.getDate("datedereception"),
                        new Address(), rs.getString("information"), map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<BonFournisseur> getAll() {
        ArrayList<BonFournisseur> list = new ArrayList<>();
        BonFournisseur_ProduitServices bfps = new BonFournisseur_ProduitServices(produit_tablename);
        FournisseurService fs = new FournisseurService();
        ClientService cs = new ClientService();
        String sql1 = "select * from " + tablename;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            while (rs.next()) {
                HashMap<Produit, Integer> map = bfps.getproducts(rs.getString("code"));
                Client fournisseur;
                if (stock == 1) {
                    fournisseur = fs.get(rs.getString("fournisseur"));
                } else {
                    fournisseur = cs.get(rs.getString("fournisseur"));
                }
                BonFournisseur bon = new BonFournisseur(rs.getInt("id"),
                        rs.getString("code"), fournisseur,
                        rs.getDate("datedebon"), rs.getDate("datedereception"), new Address(),
                        rs.getString("information"), map);
                list.add(bon);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<BonFournisseur> getByFournisseur(String key) {
        ArrayList<BonFournisseur> list = new ArrayList<>();
        BonFournisseur_ProduitServices bfps = new BonFournisseur_ProduitServices(produit_tablename);
        FournisseurService fs = new FournisseurService();
        ClientService cs = new ClientService();
        String sql1 = "select * from " + tablename + " where fournisseur='" + key + "'";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            while (rs.next()) {
                HashMap<Produit, Integer> map = bfps.getproducts(rs.getString("code"));
                Client fournisseur;
                if (stock == 1) {
                    fournisseur = fs.get(rs.getString("fournisseur"));
                } else {
                    fournisseur = cs.get(rs.getString("fournisseur"));
                }
                BonFournisseur bon = new BonFournisseur(rs.getInt("id"),
                        rs.getString("code"), fournisseur,
                        rs.getDate("datedebon"), rs.getDate("datedereception"), new Address(),
                        rs.getString("information"), map);
                list.add(bon);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BonFournisseur> getByName(String name) {
        return null;
    }

}
