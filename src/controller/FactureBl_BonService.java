package controller;

import database.Connect;
import models.BonFournisseur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FactureBl_BonService {
    protected String tablename;
    Connection cn = Connect.getConnexion();
    Statement st = null;

    public FactureBl_BonService(String tablename) {
        this.tablename = tablename;
    }

    public boolean add(String facture_code, String bon_code) {
        String sql = "insert into " + tablename + " (facture_code, bon_code) VALUES (" +
                "'" + facture_code + "'," +
                "'" + bon_code + "')";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public void addbons(String facture_code, ArrayList<BonFournisseur> list) {
        for (int i = 0; i < list.size(); i++) {
            add(facture_code, list.get(i).getCode());
        }


    }

    public ArrayList<BonFournisseur> getbons(String facture_code) {
        ArrayList<BonFournisseur> list = new ArrayList<>();
        BonFournisseurService bfs = new BonFournisseurService();
        BonClientService bcs = new BonClientService();
        String sql = "select * from " + tablename + " where facture_code='" + facture_code + "'";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                BonFournisseur bon;
                if (tablename.equals(TableNames.facturebl_bon)) {
                    bon = bfs.get(rs.getString("bon_code"));
                } else {
                    bon = bcs.get(rs.getString("bon_code"));
                }
                list.add(bon);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }
}
