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
import models.BonFournisseur;
import models.Client;
import models.FactureFournisseurBL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FactureFournisseurBLService implements Services<FactureFournisseurBL> {
    protected String tablename = TableNames.facturefournisseurbl;
    protected String bon_tablename = TableNames.facturebl_bon;
    Connection cn = Connect.getConnexion();
    Statement st = null;

    @Override
    public boolean add(FactureFournisseurBL E) {
        String sql = "insert into " + tablename + " (code, fournisseur, modepayment) VALUES ( " +
                "'" + E.getCode() + "'," +
                "'" + E.getFournisseur().getCode() + "'," +
                "'" + E.getModepayment() + "')";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            CodeService.updatecode();
            FactureBl_BonService fbs = new FactureBl_BonService(bon_tablename);
            fbs.addbons(E.getCode(), E.getBonsreceptions());

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(FactureFournisseurBL E) {
        return false;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }

    @Override
    public FactureFournisseurBL get(String key) {
        String sql = "select * from " + tablename + " where code='" + key + "'";
        try {
            FactureBl_BonService fbs = new FactureBl_BonService(bon_tablename);

            FournisseurService fournisseurService = new FournisseurService();
            ClientService cs = new ClientService();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ArrayList<BonFournisseur> listbons = fbs.getbons(rs.getString("code"));
                Client fournisseur;
                if (tablename.equals(TableNames.facturefournisseurbl)) {
                    fournisseur = fournisseurService.get(rs.getString("fournisseur"));
                } else {
                    fournisseur = cs.get(rs.getString("fournisseur"));
                }
                return new FactureFournisseurBL(rs.getInt("id"),
                        rs.getString("code"),
                        fournisseur,
                        rs.getDate("date"),
                        rs.getString("modepayment"),
                        listbons);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<FactureFournisseurBL> getAll() {
        String sql = "select * from " + tablename;
        ArrayList<FactureFournisseurBL> list = new ArrayList<>();
        try {
            FactureBl_BonService fbs = new FactureBl_BonService(bon_tablename);

            FournisseurService fournisseurService = new FournisseurService();
            ClientService cs = new ClientService();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ArrayList<BonFournisseur> listbons = fbs.getbons(rs.getString("code"));

                Client fournisseur;
                if (tablename.equals(TableNames.facturefournisseurbl)) {
                    fournisseur = fournisseurService.get(rs.getString("fournisseur"));
                } else {
                    fournisseur = cs.get(rs.getString("fournisseur"));
                }

                FactureFournisseurBL facture = new FactureFournisseurBL(rs.getInt("id"),
                        rs.getString("code"),
                        fournisseur,
                        rs.getDate("date"),
                        rs.getString("modepayment"),
                        listbons);
                list.add(facture);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<FactureFournisseurBL> getByName(String name) {
        return null;
    }
}
