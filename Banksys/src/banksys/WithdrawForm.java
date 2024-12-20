package banksys;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawForm extends JFrame {
    private JTextField withdrawAmountField;

    public WithdrawForm() {
        setTitle("Withdraw");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(10, 20, 80, 25);
        panel.add(amountLabel);

        withdrawAmountField = new JTextField(20);
        withdrawAmountField.setBounds(100, 20, 165, 25);
        panel.add(withdrawAmountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(10, 80, 255, 25);
        panel.add(withdrawButton);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(withdrawAmountField.getText());
                boolean success = withdrawAmount("admin123", amount); // Use the logged-in username
                if (success) {
                    JOptionPane.showMessageDialog(null, "Withdrew: $" + amount);
                } else {
                    JOptionPane.showMessageDialog(null, "Withdrawal failed");
                }
            }
        });
    }

    private boolean withdrawAmount(String username, double amount) {
        System.out.println("Starting withdrawal process for user: " + username + " with amount: " + amount); // Debug statement
        try (Connection connection = DatabaseConnection.getConnection()) {
            // First, check if the balance is sufficient
            String checkBalanceSql = "SELECT balance FROM Accounts WHERE username = ?";
            PreparedStatement checkBalanceStatement = connection.prepareStatement(checkBalanceSql);
            checkBalanceStatement.setString(1, username);
            ResultSet resultSet = checkBalanceStatement.executeQuery();

            if (resultSet.next()) {
                double currentBalance = resultSet.getDouble("balance");
                if (amount <= currentBalance) {
                    String sql = "UPDATE Accounts SET balance = balance - ? WHERE username = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setDouble(1, amount);
                    statement.setString(2, username);
                    int rowsUpdated = statement.executeUpdate();

                    System.out.println("Rows updated: " + rowsUpdated); // Debugging statement
                    if (rowsUpdated > 0) {
                        // Log the transaction in the Transactions table
                        String logTransactionSql = "INSERT INTO Transactions (account_id, transaction_type, amount) " +
                           "VALUES ((SELECT account_id FROM Accounts WHERE username = ? LIMIT 1), 'withdraw', ?)";

                        PreparedStatement logStatement = connection.prepareStatement(logTransactionSql);
                        logStatement.setString(1, username);
                        logStatement.setDouble(2, amount);
                        logStatement.executeUpdate();

                        System.out.println("Transaction logged successfully."); // Debugging statement
                        return true;
                    }
                } else {
                    System.out.println("Insufficient balance for withdrawal."); // Debugging statement
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Withdrawal process failed."); // Debugging statement
        return false;
    }
}
