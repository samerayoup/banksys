package banksys;
public class HomeLoan implements Loan {
    private double loanAmount;
    private double interestRate = 3.5; // Default interest rate
    private int loanTerm; // مدة القرض بالسنوات

   

    public HomeLoan(double loanAmount,double interestRate,int loanTerm) {
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
    }

    HomeLoan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public double getLoanAmount() {
        return loanAmount;
    }

    @Override
    public void applyForLoan(double amount) {
        this.loanAmount = amount;
    }

    @Override
    public String toString() {
        return "HomeLoan{" +
               "loanAmount=" + loanAmount +
               ", interestRate=" + interestRate +
               ", loanTerm=" + loanTerm +
               '}';
    }
}