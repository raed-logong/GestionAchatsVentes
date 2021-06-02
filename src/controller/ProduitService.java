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
import models.Client;
import models.FamilleProduit;
import models.Produit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProduitService implements Services<Produit> {
    Connection cn = Connect.getConnexion();
    Statement st = null;

    @Override
    public boolean add(Produit E) {
        String sql = "insert into " + TableNames.produit + " (reference, designation, " +
                "unite, fournisseur, familleproduit, " +
                "stock, stockminimal, " +
                "prixunitaire, tva) values (" +
                "'" + E.getReference() + "'," +
                "'" + E.getDesignation() + "'," +
                "'" + E.getUnite() + "'," +
                "'" + E.getFournisseur().getCode() + "'," +
                "" + E.getFamilleProduit().getCode() + "," +
                E.getStock() + "," +
                E.getStockminimal() + "," +
                E.getPrixunitaire() + "," +
                E.getTva() + ")";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean edit(Produit E) {
        String sql = "update " + TableNames.produit + " set " +
                "reference='" + E.getReference() + "'," +
                "designation='" + E.getDesignation() + "'," +
                "unite='" + E.getUnite() + "'," +
                "fournisseur='" + E.getFournisseur().getCode() + "'," +
                "familleproduit=" + E.getFamilleProduit().getCode() + " ," +
                "stock=" + E.getStock() + "," +
                "stockminimal=" + E.getStockminimal() + "," +
                "prixunitaire=" + E.getPrixunitaire() + "," +
                "tva=" + E.getTva() + " where id=" + E.getId() + "";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String key) {
        String sql = "delete from " + TableNames.produit + " where reference='" + key + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Produit get(String key) {
        String sql = "Select * from " + TableNames.produit + " where reference ='" + key + "'";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            FournisseurService fs = new FournisseurService();
            Client fournisseur = fs.get(rs.getString("fournisseur"));
            FamilleProduitService fps = new FamilleProduitService();
            FamilleProduit familleProduit = fps.getbycode(rs.getInt("familleproduit"));
            return new Produit(rs.getInt("id"), rs.getString("reference"),
                    rs.getString("designation"),
                    rs.getString("unite"),
                    fournisseur, familleProduit,
                    rs.getInt("stock"),
                    rs.getInt("stockminimal"),
                    rs.getDouble("prixunitaire"),
                    rs.getDouble("tva"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Produit> getAll() {
        String sql = "select * from " + TableNames.produit;
        ArrayList<Produit> list = new ArrayList<>();
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FournisseurService fs = new FournisseurService();

            FamilleProduitService fps = new FamilleProduitService();

            while (rs.next()) {
                Client fournisseur = fs.get(rs.getString("fournisseur"));
                FamilleProduit familleProduit = fps.getbycode(rs.getInt("familleproduit"));
                list.add(new Produit(rs.getInt("id"), rs.getString("reference"),
                        rs.getString("designation"),
                        rs.getString("unite"),
                        fournisseur, familleProduit,
                        rs.getInt("stock"),
                        rs.getInt("stockminimal"),
                        rs.getDouble("prixunitaire"),
                        rs.getDouble("tva")));
            }

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public boolean updatestock(String reference, int qte) {
        String sql = "update " + TableNames.produit + " set " +
                "stock= stock +" + qte + " where reference='" + reference + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public ArrayList<Produit> getbyfamille(int famille) {
        String sql = "select * from " + TableNames.produit + " where familleproduit=" + famille;
        ArrayList<Produit> list = new ArrayList<>();
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FournisseurService fs = new FournisseurService();

            FamilleProduitService fps = new FamilleProduitService();

            while (rs.next()) {
                Client fournisseur = fs.get(rs.getString("fournisseur"));
                FamilleProduit familleProduit = fps.getbycode(rs.getInt("familleproduit"));
                list.add(new Produit(rs.getInt("id"), rs.getString("reference"),
                        rs.getString("designation"),
                        rs.getString("unite"),
                        fournisseur, familleProduit,
                        rs.getInt("stock"),
                        rs.getInt("stockminimal"),
                        rs.getDouble("prixunitaire"),
                        rs.getDouble("tva")));
            }

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Produit> getByName(String name) {
        return null;
    }

    public Produit getByid(int key) {
        String sql = "Select * from " + TableNames.produit + " where id =" + key;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            FournisseurService fs = new FournisseurService();
            Client fournisseur = fs.get(rs.getString("fournisseur"));
            FamilleProduitService fps = new FamilleProduitService();
            FamilleProduit familleProduit = fps.getbycode(rs.getInt("familleproduit"));
            return new Produit(rs.getInt("id"), rs.getString("reference"),
                    rs.getString("designation"),
                    rs.getString("unite"),
                    fournisseur, familleProduit,
                    rs.getInt("stock"),
                    rs.getInt("stockminimal"),
                    rs.getDouble("prixunitaire"),
                    rs.getDouble("tva"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Produit> getbyfournisseur(String fournisseur) {
        String sql = "select * from " + TableNames.produit + " where fournisseur='" + fournisseur + "'";
        ArrayList<Produit> list = new ArrayList<>();
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FournisseurService fs = new FournisseurService();

            FamilleProduitService fps = new FamilleProduitService();

            while (rs.next()) {
                Client fournisseur1 = fs.get(rs.getString("fournisseur"));
                FamilleProduit familleProduit = fps.getbycode(rs.getInt("familleproduit"));
                list.add(new Produit(rs.getInt("id"), rs.getString("reference"),
                        rs.getString("designation"),
                        rs.getString("unite"),
                        fournisseur1, familleProduit,
                        rs.getInt("stock"),
                        rs.getInt("stockminimal"),
                        rs.getDouble("prixunitaire"),
                        rs.getDouble("tva")));
            }

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
