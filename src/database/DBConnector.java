package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/lab3_db?serverTimezone=UTC"
            + "&useUnicode=yes&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASSWORD = "123456";
    private Connection connection;
    private static DBConnector instance;

    private DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(CLASSNAME);
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Database connected");
    }

    public static DBConnector getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new DBConnector();
        } else if (instance.connection.isClosed()) {
            instance = new DBConnector();
        }
        return instance;
    }
}
