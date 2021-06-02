package controller;

import database.Connect;
import models.FamilleProduit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FamilleProduitService implements Services<FamilleProduit> {
    static Connection cn = Connect.getConnexion();
    static Statement st = null;

    @Override
    public boolean add(FamilleProduit E) {
        String sql = "insert into familleproduit (code, designation) values (" +
                E.getCode() + ",'" + E.getDesignation() + "')";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean edit(FamilleProduit E) {
        String sql = "update familleproduit set " +
                "designation='" + E.getDesignation() + "' where code=" + E.getCode();
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
        return false;
    }

    @Override
    public FamilleProduit get(String key) {
        return null;
    }

    @Override
    public ArrayList<FamilleProduit> getAll() {
        return null;
    }

    @Override
    public ArrayList<FamilleProduit> getByName(String name) {
        return null;
    }

    public ArrayList<FamilleProduit> getall() {
        String sql = "select * from " + TableNames.familleproduit;
        ArrayList<FamilleProduit> list = new ArrayList<>();
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new FamilleProduit(rs.getInt("code"),
                        rs.getString("designation")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public FamilleProduit getbycode(int code) {
        String sql = "SELECT  * from " + TableNames.familleproduit + " where code=" + code;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return new FamilleProduit(rs.getInt("code"), rs.getString("designation"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public FamilleProduit getByUniqueName(String name) {
        String sql = "SELECT  * from " + TableNames.familleproduit + " where designation='" + name + "'";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return new FamilleProduit(rs.getInt("code"), rs.getString("designation"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
