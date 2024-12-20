package banksys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountTypeForm extends JFrame {
    public AccountTypeForm() {
        setTitle("Account and Loan Types");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel accountLabel = new JLabel("Account Type:");
        accountLabel.setBounds(10, 20, 100, 25);
        panel.add(accountLabel);

        String[] accountTypes = {"Savings", "Checking"};
        JComboBox<String> accountComboBox = new JComboBox<>(accountTypes);
        accountComboBox.setBounds(120, 20, 165, 25);
        panel.add(accountComboBox);

        JLabel loanLabel = new JLabel("Loan Type:");
        loanLabel.setBounds(10, 60, 100, 25);
        panel.add(loanLabel);

        String[] loanTypes = {"Personal", "Home"};
        JComboBox<String> loanComboBox = new JComboBox<>(loanTypes);
        loanComboBox.setBounds(120, 60, 165, 25);
        panel.add(loanComboBox);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(10, 100, 150, 25);
        panel.add(createAccountButton);

        JButton applyLoanButton = new JButton("Apply for Loan");
        applyLoanButton.setBounds(10, 140, 150, 25);
        panel.add(applyLoanButton);

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAccountType = (String) accountComboBox.getSelectedItem();
                Account account = AccountFactory.createAccount(selectedAccountType.toLowerCase());
                // Add logic to handle the created account
                JOptionPane.showMessageDialog(null, selectedAccountType + " account created.");
            }
        });

        applyLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLoanType = (String) loanComboBox.getSelectedItem();
                Loan loan = LoanFactory.createLoan(selectedLoanType.toLowerCase());
                // Add logic to handle the loan application
                JOptionPane.showMessageDialog(null, selectedLoanType + " loan application submitted.");
            }
        });
    }
}