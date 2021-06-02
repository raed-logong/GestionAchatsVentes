package ControlleSaisie;

import database.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Saisie {
    static Connection cn = Connect.getConnexion();
    static Statement st = null;

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            @SuppressWarnings("unused")
            long d = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean checkRib(String rib) {
        boolean p = true;
        if (rib.trim().length() != 20)
            return false;
        String ch = rib.trim();
        for (int i = 0; i < ch.length(); i++) {
            if (Character.isDigit(ch.charAt(i)) == false)
                return false;
        }

        return p;
    }

    public static boolean checkraison(String ch) {//Checks if a string has only letters
        boolean p = false;
        if (ch == null)
            return false;

        for (int i = 0; i < ch.length(); i++) {
            if (Character.isLetter(ch.charAt(i)) == false && ch.charAt(i) != ' ') {
                return false;

            }
        }
        for (int i = 0; i < ch.length(); i++) {
            if (ch.codePointAt(i) != ' ') {
                return true;
            }
        }


        return p;
    }

    /**
     * check if String has only number and letter
     */
    public static boolean checkstring3(String ch) {//checks if String has only numbers and letters;
        boolean p = false;
        if (ch == null)
            return false;
        for (int i = 0; i < ch.length(); i++) {
            if (Character.isLetterOrDigit(ch.charAt(i)) == false) {
                return false;
            }
        }
        for (int i = 0; i < ch.length(); i++) {
            if (ch.codePointAt(i) != ' ') {
                return true;
            }
        }

        return p;
    }

    public static boolean checkmatricule(String matricule) {
        boolean p = true;
        int count = 0;
        for (int i = 0; i < matricule.length(); i++) {
            if (matricule.charAt(i) == '/') {
                count++;
            }
        }
        if (count != 2) {
            return false;
        }
        ArrayList<String> ch = new ArrayList<>() {{
            add(null);
            add(null);
            add(null);
        }};
        String[] ch1 = matricule.split("/");
        for (int i = 0; i < ch1.length; i++) {
            ch.set(i, ch1[i]);
        }
        for (int i = 0; i < ch.size(); i++) {
            if (ch.get(i) == null) {
                return false;
            }
            if (ch.get(i).trim() == null) {
                return false;
            }
            if (checkstring3(ch.get(i)) == false) {
                return false;
            }
        }
        return p;
    }

    public static boolean emailisValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean isRibUnique(String rib) {
        String sql = "select * from bankaccounts_client where RIB='" + rib + "'";
        String sql1 = "select * from bankaccounts_fournisseur where RIB='" + rib + "'";
        try {
            st = cn.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            if (rs1.next() == true) {
                return false;
            }
            ResultSet rs2 = st.executeQuery(sql);
            if (rs2.next() == true) {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public static boolean isrefunique(String ref) {
        String sql = "select * from produit where reference='" + ref + "'";
        try {
            st = cn.createStatement();
            ResultSet rs1 = st.executeQuery(sql);
            if (rs1.next() == true) {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }
}
