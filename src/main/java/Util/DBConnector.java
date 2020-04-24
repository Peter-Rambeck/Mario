package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
//
    private Connection connection;
    private static DBConnector instance;

    private DBConnector() {
        try {
            String baseurl = "jdbc:mysql://localhost:3306/";
            String db = "Mario";
            String timeZ = "serverTimezone=Europe/Copenhagen&allowPublicKeyRetrieval=true";
            String totalUrl = baseurl+db+"?"+timeZ;
            String user = "root";
            String password = "Data2020";
            connection = DriverManager.getConnection(totalUrl,user,password);
        } catch (SQLException id) {
            System.out.println("Wrong " + id.getMessage());
        }
    }
    public static DBConnector getInstance() {
        if (instance == null ) {
            instance = new DBConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}