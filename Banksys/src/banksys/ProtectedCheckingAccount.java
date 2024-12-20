package banksys;

public class ProtectedCheckingAccount extends CheckingAccount {
    private double overdraftLimit;

    public ProtectedCheckingAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }
}
