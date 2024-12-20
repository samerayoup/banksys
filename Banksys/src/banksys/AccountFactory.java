package banksys;

public class AccountFactory {
   public static Account createAccount(String type) {
    if (type.equalsIgnoreCase("savings")) {
        return new SavingsAccount();
    } else if (type.equalsIgnoreCase("checking")) {
        return new CheckingAccount();
    } else {
        throw new IllegalArgumentException("Unsupported account type: " + type);
    }
}
}


