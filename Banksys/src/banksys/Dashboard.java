package banksys;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JButton accountBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transactionHistoryButton;
    private JButton accountLoanTypesButton;
    private JButton accountDetailsButton; // New button for account details

    public Dashboard() {
        setTitle("Bank System Dashboard");
        setSize(400, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        accountBalanceButton = new JButton("Account Balance");
        accountBalanceButton.setBounds(10, 20, 150, 25);
        panel.add(accountBalanceButton);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(10, 50, 150, 25);
        panel.add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(10, 80, 150, 25);
        panel.add(withdrawButton);

        transactionHistoryButton = new JButton("Transaction History");
        transactionHistoryButton.setBounds(10, 110, 150, 25);
        panel.add(transactionHistoryButton);

        accountLoanTypesButton = new JButton("Account & Loan Types");
        accountLoanTypesButton.setBounds(10, 140, 150, 25);
        panel.add(accountLoanTypesButton);

        accountDetailsButton = new JButton("Account Details"); // New button
        accountDetailsButton.setBounds(10, 170, 150, 25);
        panel.add(accountDetailsButton);

        // Add action listeners for each button
        accountBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountBalanceForm accountBalanceForm = new AccountBalanceForm();
                accountBalanceForm.setVisible(true);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositForm depositForm = new DepositForm();
                depositForm.setVisible(true);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawForm withdrawForm = new WithdrawForm();
                withdrawForm.setVisible(true);
            }
        });

        transactionHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionHistoryForm transactionHistoryForm = new TransactionHistoryForm();
                transactionHistoryForm.setVisible(true);
            }
        });

        accountLoanTypesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountTypeForm accountTypeForm = new AccountTypeForm();
                accountTypeForm.setVisible(true);
            }
        });

        accountDetailsButton.addActionListener(new ActionListener() { // New action listener
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDetailsForm accountDetailsForm = new AccountDetailsForm();
                accountDetailsForm.setVisible(true);
            }
        });
    }
}
