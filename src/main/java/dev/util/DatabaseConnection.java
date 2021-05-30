package dev.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        String url;
        String username;
        String password;

        if(connection == null) {
            try (InputStream inputStream = new FileInputStream("configuration.properties")) {
                Properties properties = new Properties();
                properties.load(inputStream);

                url = (String) properties.get("database.url");
                username = (String) properties.get("database.username");
                password = (String) properties.get("database.password");

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
