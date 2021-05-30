package dev.dao;

import dev.model.BankBranch;
import dev.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankBranchDaoImplementation implements BankBranchDao{
    static Connection connection = DatabaseConnection.getConnection();
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

    @Override
    public List<BankBranch> getBankBranches() {
        List<BankBranch> bankBranches = new ArrayList<>();
        try {
            String sql = "SELECT * FROM bank_branches WHERE deleted_at IS NULL";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BankBranch bankBranch = new BankBranch();
                bankBranch.setId(resultSet.getInt("id"));
                bankBranch.setName(resultSet.getString("name"));
                bankBranch.setLocation(resultSet.getString("location"));
                bankBranch.setDescription(resultSet.getString("description"));
                bankBranches.add(bankBranch);
            }
            for (BankBranch bankBranch: bankBranches) {
                System.out.println(bankBranch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bankBranches;
    }

    @Override
    public boolean addBankBranch(BankBranch bankBranch) {
        boolean result = false;

        try {
            String sql = "INSERT INTO bank_branches (name, location, description, created_at, updated_at)" +
                    " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bankBranch.getName());
            preparedStatement.setString(2, bankBranch.getLocation());
            preparedStatement.setString(3, bankBranch.getDescription());
            preparedStatement.setTimestamp(4, this.timestamp);
            preparedStatement.setTimestamp(5, this.timestamp);
            result = (preparedStatement.executeUpdate() == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public BankBranch getBankBranch(int id) {
        BankBranch bankBranch = new BankBranch();
        try {
            String sql = "SELECT * FROM bank_branches WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bankBranch.setId(resultSet.getInt("id"));
                bankBranch.setName(resultSet.getString("name"));
                bankBranch.setLocation(resultSet.getString("location"));
                bankBranch.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bankBranch;
    }

    @Override
    public boolean updateBankBranch(int id, BankBranch bankBranch) {
        boolean updated = false;
        try {
            String sql = "UPDATE bank_branches " +
                    "SET name=?, location=?, description=?, updated_at=?" +
                    "WHERE id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bankBranch.getName());
            preparedStatement.setString(2, bankBranch.getLocation());
            preparedStatement.setString(3, bankBranch.getLocation());
            preparedStatement.setTimestamp(4, this.timestamp);
            preparedStatement.setInt(5, id);
            updated = (preparedStatement.executeUpdate() == 1);

        } catch (SQLException e){
            e.printStackTrace();
        }

        return updated;
    }

    @Override
    public boolean deleteBankBranch(int id) {
        boolean result = false;

        try {
            String sql = "UPDATE bank_branches SET deleted_at = ? " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, this.timestamp);
            preparedStatement.setInt(2, id);
            result = (preparedStatement.executeUpdate() == 1);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
