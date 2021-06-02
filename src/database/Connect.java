package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {

    static Connection cn;
    String url = "jdbc:mysql://localhost/miniprojetjava";
    String login = "root";
    String password = "";

    private Connect() {
        // TODO Auto-generated constructor stub

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
            Statement st = cn.createStatement();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnexion() {
        if (cn == null) {
            new Connect();
        }
        return cn;
    }
}
