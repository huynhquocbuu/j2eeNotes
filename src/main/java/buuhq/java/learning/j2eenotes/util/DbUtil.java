package buuhq.java.learning.j2eenotes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3307/crm_app";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASSWORD = "Khdt@199";

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
            System.out.println("Connect to mysql SUCCESS!!!");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("mysql jdbc driver not found");
        } catch (SQLException e) {
            System.out.println("Connect to mysql FAIL!!!");
            e.printStackTrace();
        }
        return null;
    }
}
