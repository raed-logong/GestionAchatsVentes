package controller;

import ControlleSaisie.Saisie;
import database.Connect;
import models.BankAccount;

import java.sql.*;
import java.util.ArrayList;

public class BankAccountService {
    private final String tablename;
    Connection cn = Connect.getConnexion();
    Statement st = null;

    public BankAccountService(String tablename) {
        this.tablename = tablename;
    }

    public boolean add(BankAccount E, String code) {
        String sql = "insert into bankaccounts_" + tablename + " (RIB, bankname, agence, code) VALUES ('" +
                E.getRIB() + "','" +
                E.getBankname() + "','" +
                E.getAgence() + "','" +
                code + "')";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLIntegrityConstraintViolationException exception) {
            exception.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void addaccounts(ArrayList<BankAccount> list, String key) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i), key);
        }

    }

    public boolean edit(BankAccount E, String code) {
        String sql = "update bankaccounts_" + tablename + " set " +
                "RIB='" + E.getRIB() + "'," +
                "bankname='" + E.getBankname() + "'," +
                "agence='" + E.getAgence() + "'" +
                "where code='" + code + "' and RIB='" + E.getRIB() + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean modifieraccounts(ArrayList<BankAccount> list, String code) {
        try {
            for (int i = 0; i < list.size(); i++) {
                if (Saisie.isRibUnique(list.get(i).getRIB())) {
                    add(list.get(i), code);
                } else {
                    edit(list.get(i), code);
                }
            }
            return true;
        } catch (Exception E) {
            E.printStackTrace();
        }


        return false;
    }


    public boolean delete(String key) {
        String sql = "delete from bankaccounts_" + tablename + " where RIB='" + key + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public BankAccount get(String key) {
        return null;
    }


    public ArrayList<BankAccount> getAll(String code) {
        ArrayList<BankAccount> list = new ArrayList<>();
        String sql = "SELECT * from bankaccounts_" + tablename + " where code='" + code + "'";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String rib = rs.getString("RIB");
                String agence = rs.getString("agence");
                String bankname = rs.getString("bankname");
                list.add(new BankAccount(rib, bankname, agence));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


}
