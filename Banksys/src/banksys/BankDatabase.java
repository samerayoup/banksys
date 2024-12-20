package banksys;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDatabase {
    private static BankDatabase instance;

    private BankDatabase() {}

    public static synchronized BankDatabase getInstance() {
        if (instance == null) {
            instance = new BankDatabase();
        }
        return instance;
    }

    public void addUser(User user) {
        if (!userExists(user.getUsername())) {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.executeUpdate();

                // Also create an account for the new user
                String accountSql = "INSERT INTO Accounts (username, account_type, balance) VALUES (?, 'savings', 0.00)";
                PreparedStatement accountStatement = connection.prepareStatement(accountSql);
                accountStatement.setString(1, user.getUsername());
                accountStatement.executeUpdate();
                
                System.out.println("User and account inserted successfully."); // Debugging statement
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("User already exists."); // Debugging statement
        }
    }

    public boolean userExists(String username) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUser(String username) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                return new User(username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
