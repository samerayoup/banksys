package banksys;

public class CheckingAccount implements Account, Prototype {
    private double balance;

    public CheckingAccount(double balance) {
        this.balance = balance;
    }


    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    public CheckingAccount() {
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
        return new CheckingAccount(this.balance);
    }

    @Override
    public String toString() {
        return "CheckingAccount [balance=" + balance + "]";
    }

   

   
}