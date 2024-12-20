package banksys;

public class SavingsAccount implements Account, Prototype {
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    public SavingsAccount() {
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public Prototype clone() {
        return new SavingsAccount(this.balance);
    }

    @Override
    public String toString() {
        return "SavingsAccount [balance=" + balance + "]";
    }

    
}