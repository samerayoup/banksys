package banksys;

public class PersonalLoan implements Loan {
    private double loanAmount;
        private double interestRate = 5.0; // Default
        private int loanTerm;

    public PersonalLoan(double loanAmount, int loanTerm) {
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
    }

    @Override
    public String toString() {
        return "PersonalLoan{" + "loanAmount=" + loanAmount + ", interestRate=" + interestRate + ", loanTerm=" + loanTerm + '}';
    }
    
    
        
        
    PersonalLoan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void applyForLoan(double amount) {
        this.loanAmount = amount;
    } 
    
    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public double getLoanAmount() {
        return loanAmount;
    }

   
    
   
}
