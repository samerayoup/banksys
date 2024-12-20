package banksys;



import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountBalanceForm extends JFrame {
    private JLabel balanceAmount;

    public AccountBalanceForm() {
        setTitle("Account Balance");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
        loadBalance();
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel balanceLabel = new JLabel("Account Balance:");
        balanceLabel.setBounds(10, 20, 150, 25);
        panel.add(balanceLabel);

        balanceAmount = new JLabel("$0.00");
        balanceAmount.setBounds(160, 20, 100, 25);
        panel.add(balanceAmount);
    }

    private void loadBalance() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT balance FROM Accounts WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "admin123"); // Use the logged-in username
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                balanceAmount.setText("$" + balance);
                System.out.println("Current balance: $" + balance); // Debugging statement
            } else {
                System.out.println("No account found for username: admin123"); // Debugging statement
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
