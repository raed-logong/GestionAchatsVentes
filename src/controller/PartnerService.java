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
import models.BankAccount;
import models.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class PartnerService implements Services<Client> {
    protected String tablename = "";
    Connection cn = Connect.getConnexion();
    Statement st = null;


    @Override
    public boolean add(Client E) {
        String sql = "Insert Into " + tablename + "(code, matricule, raison, type, fax, numportable, numfix,email,siteweb, etat) values (" +
                "'" + E.getCode() + "'," +
                "'" + E.getMatricule() + "'," +
                "'" + E.getRaison() + "'," +
                "'" + E.getType() + "'," +
                "'" + E.getFax() + "'," +
                "'" + E.getNumPortable() + "'," +
                "'" + E.getNumFix() + "'," +
                "'" + E.getEmail() + "'," +
                "'" + E.getSiteWeb() + "'," +
                E.getEtat() +
                ")";
        try {
            st = cn.createStatement();

            if (E.getAddress() == null) {
                return false;
            }
            if (E.getBankAccounts().size() == 0) {
                return false;
            }
            st.executeUpdate(sql);
            AddressService addressService = new AddressService(tablename);
            addressService.add(E.getAddress(), E.getCode());
            BankAccountService bankAccountService = new BankAccountService(tablename);
            bankAccountService.addaccounts(E.getBankAccounts(), E.getCode());
            CodeService.updatecode();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Client E) {
        String sql = "update " + tablename + " set " +
                "matricule='" + E.getMatricule() + "'," +
                "raison='" + E.getRaison() + "'," +
                "type='" + E.getType() + "'," +
                "fax='" + E.getFax() + "'," +
                "numportable='" + E.getNumPortable() + "'," +
                "numfix='" + E.getNumFix() + "'," +
                "email='" + E.getEmail() + "'," +
                "etat=" + E.getEtat() + "," +
                "siteweb='" + E.getSiteWeb() + "'" +
                "where code='" + E.getCode() + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            AddressService as = new AddressService(tablename);
            as.edit(E.getAddress(), E.getCode());
            BankAccountService bs = new BankAccountService(tablename);
            //bs.modifieraccounts(E.getBankAccounts(),E.getCode());
            st.executeUpdate("Delete from bankaccounts_" + tablename + " where " +
                    "code='" + E.getCode() + "'");
            bs.addaccounts(E.getBankAccounts(), E.getCode());

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(String key) {
        String sql = "delete from " + tablename + " where code='" + key + "'";
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
    public Client get(String key) {
        String sql = "select * from " + tablename + " where code='" + key + "'";

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            BankAccountService bankAccountService = new BankAccountService(tablename);
            ArrayList<BankAccount> accounts = bankAccountService.getAll(key);
            AddressService as = new AddressService(tablename);
            Address address = as.getaddress(key);
            rs.next();
            Client client = new Client(rs.getString("matricule"),
                    rs.getString("raison"),
                    rs.getString("type"),
                    accounts, address,
                    rs.getString("fax"),
                    rs.getString("numfix"),
                    rs.getString("numportable"),
                    rs.getBoolean("etat"),
                    rs.getString("code"));
            client.setEmail(rs.getString("email"));
            client.setSiteWeb(rs.getString("siteweb"));
            return client;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Client> getAll() {
        String sql = "select * from " + tablename;
        ArrayList<Client> list = new ArrayList<>();
        BankAccountService bankAccountService = new BankAccountService(tablename);
        AddressService as = new AddressService(tablename);
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ArrayList<BankAccount> accounts = bankAccountService.getAll(rs.getString("code"));
                Address address = as.getaddress(rs.getString("code"));
                Client c = new Client(rs.getString("matricule"),
                        rs.getString("raison"),
                        rs.getString("type"),
                        accounts, address,
                        rs.getString("fax"),
                        rs.getString("numfix"),
                        rs.getString("numportable"),
                        rs.getBoolean("etat"),
                        rs.getString("code"));
                c.setEmail(rs.getString("email"));
                c.setSiteWeb(rs.getString("siteweb"));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Client> getByName(String name) {
        String sql = "select * from " + tablename + " where raison='" + name + "'";
        ArrayList<Client> list = new ArrayList<>();
        BankAccountService bankAccountService = new BankAccountService(tablename);
        AddressService as = new AddressService(tablename);
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ArrayList<BankAccount> accounts = bankAccountService.getAll(rs.getString("code"));
                Address address = as.getaddress(rs.getString("code"));
                Client c = new Client(rs.getString("matricule"),
                        rs.getString("raison"),
                        rs.getString("type"),
                        accounts, address,
                        rs.getString("fax"),
                        rs.getString("numfix"),
                        rs.getString("numportable"),
                        rs.getBoolean("etat"),
                        rs.getString("code"));
                c.setEmail(rs.getString("email"));
                c.setSiteWeb(rs.getString("siteweb"));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
