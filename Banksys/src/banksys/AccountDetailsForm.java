package banksys;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDetailsForm extends JFrame {
    private JTextArea accountDetailsTextArea;
    private JScrollPane scrollPane;

    public AccountDetailsForm() {
        setTitle("Account Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
        loadAccountDetails();
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel detailsLabel = new JLabel("Account Details:");
        detailsLabel.setBounds(10, 10, 200, 25);
        panel.add(detailsLabel);

        accountDetailsTextArea = new JTextArea();
        accountDetailsTextArea.setEditable(false);

        scrollPane = new JScrollPane(accountDetailsTextArea);
        scrollPane.setBounds(10, 40, 560, 300);
        panel.add(scrollPane);
    }

    private void loadAccountDetails() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT a.account_id, a.username, a.account_type, a.balance, " +
                         "l.loan_type, l.loan_amount, l.interest_rate " +
                         "FROM Accounts a LEFT JOIN Loans l ON a.username = l.username";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            StringBuilder details = new StringBuilder();
            while (resultSet.next()) {
                int accountId = resultSet.getInt("account_id");
                String username = resultSet.getString("username");
                String accountType = resultSet.getString("account_type");
                double balance = resultSet.getDouble("balance");
                                details.append("Account ID: ").append(accountId)
                        .append(", Username: ").append(username)
                        .append(", Account Type: ").append(accountType)
                        .append(", Balance: $").append(balance);
                
               
            }
            accountDetailsTextArea.setText(details.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
