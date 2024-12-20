/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banksys;

/**
 *
 * @author Samer
 */
public class LegacyBankSystem {
    public void executeTransaction(String accountNumber, double amount, String transactionType) {
        if (transactionType.equalsIgnoreCase("Deposit")) {
            System.out.println("Legacy: Depositing " + amount + " into account " + accountNumber);
        } else if (transactionType.equalsIgnoreCase("Withdraw")) {
            System.out.println("Legacy: Withdrawing " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Legacy: Unsupported transaction type: " + transactionType);
        }
    }
}
