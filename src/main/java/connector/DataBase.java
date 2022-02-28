package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static Connection CONNECTION;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_app_bd", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect(){
        return CONNECTION;
    }
}
