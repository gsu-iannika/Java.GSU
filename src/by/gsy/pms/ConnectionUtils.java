package by.gsy.pms;

import java.sql.*;

public class ConnectionUtils {
    // JDBC URL, username and password of MySQL server
    private static String user = "root";
    private static String password = "0712";
    private static String url = "jdbc:mysql://localhost:3306/souvenirs?autoReconnect=true&useSSL=false";

    // JDBC variables for opening and managing connection
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    public Connection get_connection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // handle an exception
            System.err.println("EXEPTION: " + e);
        }
        return connection;
    }


}
