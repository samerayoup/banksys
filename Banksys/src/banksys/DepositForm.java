package banksys;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepositForm extends JFrame {
    private JTextField depositAmountField;

    public DepositForm() {
        setTitle("Deposit");
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

        depositAmountField = new JTextField(20);
        depositAmountField.setBounds(100, 20, 165, 25);
        panel.add(depositAmountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(10, 80, 255, 25);
        panel.add(depositButton);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(depositAmountField.getText());
                boolean success = depositAmount("admin123", amount); // Use the logged-in username
                if (success) {
                    JOptionPane.showMessageDialog(null, "Deposited: $" + amount);
                } else {
                    JOptionPane.showMessageDialog(null, "Deposit failed");
                }
            }
        });
    }

    private boolean depositAmount(String username, double amount) {
        System.out.println("Starting deposit process for user: " + username + " with amount: " + amount); // Debug statement
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE Accounts SET balance = balance + ? WHERE username = ?";
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
            } else {
                System.out.println("No rows were updated, possibly due to incorrect username."); // Debugging statement
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Deposit process failed."); // Debugging statement
        return false;
    }
}
