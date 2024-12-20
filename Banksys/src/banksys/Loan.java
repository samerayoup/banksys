package banksys;

public interface Loan {
    double getInterestRate();
    double getLoanAmount();
    void applyForLoan(double amount);
}
