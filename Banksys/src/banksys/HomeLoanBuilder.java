package banksys;
public class HomeLoanBuilder {
      private double loanAmount;
    private double interestRate = 3.5; // Default interest rate
    private int loanTerm; 

      
      

        public HomeLoanBuilder setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
            return this;
        }

        public HomeLoanBuilder setInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public HomeLoanBuilder setLoanTerm(int loanTerm) {
            this.loanTerm = loanTerm;
            return this;
        }

        public HomeLoan build() {
            return new HomeLoan(loanAmount,interestRate,loanTerm);
        }
    }