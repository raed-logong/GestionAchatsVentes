package controller;

import database.Connect;
import models.Address;
import models.BankAccount;
import models.Entreprise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EntrepriseService {
    Connection cn = Connect.getConnexion();
    Statement st = null;

    public void addaccounts(ArrayList<BankAccount> accountslist) {
        try {
            st = cn.createStatement();
            for (int i = 0; i < accountslist.size(); i++) {
                BankAccount a = accountslist.get(i);
                st.executeUpdate("insert into bankaccounts_entreprise ( RIB, bankname, agence) values ('" +
                        a.getRIB() + "','" +
                        a.getBankname() + "','" +
                        a.getAgence() + "')");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean add(Entreprise E) {
        String sql = "Insert Into entreprise (matricule, raison, type,fax, numfix, numportable,etat, description) VALUES ('" + E.getMatricule() + "','" +
                E.getRaison() + "','" +
                E.getType() + "','" +
                E.getFax() + "','" +
                E.getNumFix() + "','" +
                E.getNumPortable() + "'," +
                E.getEtat() + ",'" +
                E.getDescription() + "')";

        try {
            st = cn.createStatement();
            if (E.getAddress() == null) {
                return false;
            }
            if (E.getBankAccounts().size() == 0) {
                return false;
            }
            Address A = E.getAddress();
            this.st.executeUpdate(sql);
            addaccounts(E.getBankAccounts());
            this.st.executeUpdate("insert into addresses_entreprise (loc,libelle,ville, codePostal, gouvernourat, pays, numeroRue) " +
                    "VALUES('X','" +
                    A.getLibelle() + "','" +
                    A.getVille() + "','" +
                    A.getCodePostal() + "','" +
                    A.getGouvernourat() + "','" +
                    A.getPays() + "','" +
                    A.getNumeroRue() + "') ");
            if (E.getEmail() != null) {
                st = cn.createStatement();
                st.executeUpdate("update entreprise set email='" + E.getEmail() + "' WHERE matricule= '" + E.getMatricule() + "'");
            }
            if (E.getSiteWeb() != null) {
                st = cn.createStatement();
                st.executeUpdate("update entreprise set siteweb='" + E.getSiteWeb() + "' WHERE matricule= '" + E.getMatricule() + "'");
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public Boolean edit(Entreprise E) {
        String sql = "update entreprise set " +
                "matricule='" + E.getMatricule() + "'," +
                "raison= '" + E.getRaison() + "'," +
                "type='" + E.getType() + "'," +
                "numfix='" + E.getNumFix() + "'," +
                "numportable='" + E.getNumPortable() + "'," +
                "email='" + E.getEmail() + "'," +
                "siteweb='" + E.getSiteWeb() + "'," +
                "fax='" + E.getFax() + "'," +
                "etat=" + E.getEtat() + " ," +
                "description='" + E.getDescription() + "' " +
                "WHERE loc= '1'";
        try {
            st = cn.createStatement();
            if (E.getAddress() == null) {
                return false;
            }
            if (E.getBankAccounts().size() == 0) {
                return false;
            }
            Address A = E.getAddress();
            st.executeUpdate("update addresses_entreprise set " +
                    "ville='" + A.getVille() + "'," +
                    "codePostal='" + A.getCodePostal() + "'," +
                    "gouvernourat='" + A.getGouvernourat() + "'," +
                    "pays='" + A.getPays() + "'," +
                    "numeroRue='" + A.getNumeroRue() + "'," +
                    "libelle='" + A.getLibelle() + "' where loc='1'");
            st.executeUpdate("delete from bankaccounts_entreprise");
            addaccounts(E.getBankAccounts());

            st.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    public Address getaddress() {
        String sql = "select * from addresses_entreprise";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return new Address(rs.getString("numeroRue"),
                        rs.getString("libelle"),
                        rs.getString("ville"),
                        rs.getString("codepostal"),
                        rs.getString("gouvernourat"),
                        rs.getString("pays"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<BankAccount> getaccounts() {
        ArrayList<BankAccount> list = new ArrayList<>();
        String sql = "SELECT * from bankaccounts_entreprise";
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

    public Entreprise get() {
        String sql = "select * from entreprise";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Address address = getaddress();
            ArrayList<BankAccount> accounts = getaccounts();
            rs.next();
            Entreprise E = new Entreprise(rs.getString("matricule"),
                    rs.getString("raison"),
                    rs.getString("type"),
                    accounts, address,
                    rs.getString("fax"),
                    rs.getString("numfix"),
                    rs.getString("numportable"),
                    rs.getBoolean("etat"),
                    rs.getString("description"));
            E.setEmail(rs.getString("email"));
            E.setSiteWeb(rs.getString("siteweb"));
            return E;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
