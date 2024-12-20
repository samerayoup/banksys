/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banksys;

/**
 *
 * @author Samer
 */
public class BankAdapter implements ModernBankSystem {
    private LegacyBankSystem legacySystem;

    public BankAdapter(LegacyBankSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        legacySystem.executeTransaction(accountNumber, amount, "Deposit");
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        legacySystem.executeTransaction(accountNumber, amount, "Withdraw");
    }

    @Override
    public void transfer(String fromAccount, String toAccount, double amount) {
        System.out.println("Adapter: Splitting transfer into withdraw and deposit operations.");
        legacySystem.executeTransaction(fromAccount, -amount, "Withdraw");
        legacySystem.executeTransaction(toAccount, amount, "Deposit");
    }
}