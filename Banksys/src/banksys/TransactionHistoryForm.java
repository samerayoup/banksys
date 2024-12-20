package banksys;



import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionHistoryForm extends JFrame {
    private JTextArea historyTextArea;

    public TransactionHistoryForm() {
        setTitle("Transaction History");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
        loadTransactionHistory();
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel historyLabel = new JLabel("Transaction History:");
        historyLabel.setBounds(10, 20, 150, 25);
        panel.add(historyLabel);

        historyTextArea = new JTextArea(10, 30);
        historyTextArea.setBounds(10, 50, 360, 200);
        historyTextArea.setEditable(false);
        panel.add(historyTextArea);
    }

    private void loadTransactionHistory() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT t.transaction_type, t.amount, t.date " +
                         "FROM Transactions t " +
                         "JOIN Accounts a ON t.account_id = a.account_id " +
                         "WHERE a.username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "admin123"); // Use the logged-in username
            ResultSet resultSet = statement.executeQuery();
            StringBuilder history = new StringBuilder();
            while (resultSet.next()) {
                String transactionType = resultSet.getString("transaction_type");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                history.append(transactionType).append(": $").append(amount).append(" on ").append(date).append("\n");
            }
            historyTextArea.setText(history.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}