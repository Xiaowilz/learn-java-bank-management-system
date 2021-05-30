package dev.dao;

import dev.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginDaoImplementation implements LoginDao {
    static Connection connection = DatabaseConnection.getConnection();
    private Map<String, String> loggedInUser = new HashMap<>();

    @Override
    public boolean login(String username, String password) {
        boolean isLoggeinInUser = false;
        String query = "SELECT * FROM users where username=? AND password=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                do {
                    loggedInUser.put("username", resultSet.getString("username"));
                    loggedInUser.put("email", resultSet.getString("email"));
                    loggedInUser.put("phone", resultSet.getString("phone"));
                } while (resultSet.next());

                System.out.println(loggedInUser);
                isLoggeinInUser = true;
            }else {
                System.out.println("Username or password is wrong!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isLoggeinInUser;
    }
}
