package banksys;

public class LoanFactory {
    public static Loan createLoan(String type) {
        if (type.equalsIgnoreCase("personal")) {
            return new PersonalLoan();
        } else if (type.equalsIgnoreCase("home")) {
            return new HomeLoan();
        }
        return null;
    }
}
