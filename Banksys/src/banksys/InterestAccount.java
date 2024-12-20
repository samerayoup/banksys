package banksys;

public class InterestAccount extends SavingsAccount {
    private double interestRate;

    public InterestAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
}
