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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressService {
    private final String tablename;
    Connection cn = Connect.getConnexion();
    Statement st = null;

    public AddressService(String tablename) {
        this.tablename = tablename;
    }

    public boolean add(Address E, String key) {
        String sql = "insert into addresses_" + tablename + " (code, numeroRue, libelle, ville, codePostal, gouvernourat, pays) VALUES ('" +
                key + "','" +
                E.getNumeroRue() + "','" +
                E.getLibelle() + "','" +
                E.getVille() + "','" +
                E.getCodePostal() + "','" +
                E.getGouvernourat() + "','" +
                E.getPays() + "')";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public Address getaddress(String key) {
        String sql = "select * from addresses_" + tablename + " where code='" + key + "'";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return new Address(rs.getString("numeroRue"),
                    rs.getString("libelle"),
                    rs.getString("ville"),
                    rs.getString("codepostal"),
                    rs.getString("gouvernourat"),
                    rs.getString("pays"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean edit(Address E, String key) {
        String sql = "update addresses_" + tablename + " set " +
                "numeroRue='" + E.getNumeroRue() + "'," +
                "libelle='" + E.getLibelle() + "'," +
                "ville='" + E.getVille() + "'," +
                "codePostal='" + E.getCodePostal() + "'," +
                "gouvernourat='" + E.getGouvernourat() + "'," +
                "pays='" + E.getPays() + "' where " +
                "code='" + key + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
