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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CodeService {
    static Connection cn = Connect.getConnexion();
    static Statement st = null;

    public static void updatecode() {
        String sql = "update codevalue set " +
                "code=code+1";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String getCode(String model) {
        String sql = "select * from codevalue";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return (model + rs.getInt("code"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
