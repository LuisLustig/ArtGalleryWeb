package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

/**
 * Created by Пользователь on 13.04.2018.
 */
public class Config {
    private static String url = "jdbc:postgresql://localhost/Gallery";
    private static String login = "Root";
    private static String password = "root";
    private static Connection connection;

    public static void createConnection() {
        try {
            forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()  {
        try {
            if(connection == null||connection.isClosed())
                createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if(!connection.isClosed())
            connection.close();
    }

}
