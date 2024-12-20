/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banksys;

/**
 *
 * @author Samer
 */
public  class PersonalLoanBuilder {
        private double loanAmount;
        private double interestRate = 5.0; // Default
        private int loanTerm;

        public PersonalLoanBuilder setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
            return this;
        }

        public PersonalLoanBuilder setInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public PersonalLoanBuilder setLoanTerm(int loanTerm) {
            this.loanTerm = loanTerm;
            return this;
        }

        public PersonalLoan build() {
            return new PersonalLoan(loanAmount,loanTerm);
        }
    }
