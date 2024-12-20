package banksys;


import javax.swing.SwingUtilities;

public class BankSystem {
    
    public static void main(String[] args) {
        BankDatabase db = BankDatabase.getInstance();
        
        // Check if admin user already exists before adding
        if (!db.userExists("admin123")) {
            User admin = new User("admin123", "Password");
            db.addUser(admin);
        }

        // Start with the login form
        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        });
        
        // إنشاء قرض HomeLoan باستخدام Builder
       /* HomeLoan homeLoan = new HomeLoanBuilder()
            .setLoanAmount(300000)
            .setLoanTerm(15)
            .build();

        // إنشاء قرض PersonalLoan باستخدام Builder
        PersonalLoan personalLoan = new PersonalLoanBuilder()
            .setLoanAmount(10000)
            .setLoanTerm(2)
            .build();

        // طباعة القروض
        System.out.println(homeLoan);
        System.out.println(personalLoan);
        
        System.out.println();
        
        // إنشاء حساب CheckingAccount
        CheckingAccount checking = new CheckingAccount(500);
        System.out.println("Original Checking: " + checking);

        // إنشاء نسخة Clone
        CheckingAccount clonedChecking = (CheckingAccount) checking.clone();
        System.out.println("Cloned Checking: " + clonedChecking);

        // تعديل النسخة
        clonedChecking.deposit(100);
        System.out.println("Modified Cloned Checking: " + clonedChecking);
        System.out.println("Original Checking After Modification: " + checking);

        // نفس الفكرة مع SavingsAccount
        SavingsAccount savings = new SavingsAccount(800);
        System.out.println("\nOriginal Savings: " + savings);

        SavingsAccount clonedSavings = (SavingsAccount) savings.clone();
        System.out.println("Cloned Savings: " + clonedSavings);

        clonedSavings.withdraw(200);
        System.out.println("Modified Cloned Savings: " + clonedSavings);
        System.out.println("Original Savings After Modification: " + savings);
       System.out.println("Test Adapter");
      System.out.println();
        LegacyBankSystem legacySystem = new LegacyBankSystem();
        ModernBankSystem modernSystem = new BankAdapter(legacySystem);

        // استخدام الواجهة الحديثة للتفاعل مع النظام القديم
        modernSystem.deposit("123456", 1000);
        modernSystem.withdraw("123456", 500);
        modernSystem.transfer("123456", "654321", 200);
        System.out.println("Test Factory");
      System.out.println();
      
      // 1. إنشاء حساب CheckingAccount باستخدام Factory
        Account checking = AccountFactory.createAccount("checking");
        if (checking instanceof CheckingAccount) {
            System.out.println("CheckingAccount created successfully!");
        } else {
            System.out.println("Error: Failed to create CheckingAccount.");
        }

        // 2. تنفيذ عمليات على CheckingAccount
        checking.deposit(1000);
        checking.withdraw(500);
        System.out.println("CheckingAccount Balance: " + checking.getBalance());

        // 3. إنشاء حساب SavingsAccount باستخدام Factory
        Account savings = AccountFactory.createAccount("savings");
        if (savings instanceof SavingsAccount) {
            System.out.println("SavingsAccount created successfully!");
        } else {
            System.out.println("Error: Failed to create SavingsAccount.");
        }

        // 4. تنفيذ عمليات على SavingsAccount
        savings.deposit(2000);
        savings.withdraw(800);
        System.out.println("SavingsAccount Balance: " + savings.getBalance());

        // 5. اختبار نوع غير مدعوم
        Account invalidAccount = AccountFactory.createAccount("fixed");
        if (invalidAccount == null) {
            System.out.println("Error: Unsupported account type.");*/
        }
    }

       
    

    
    
        
        
    

    

