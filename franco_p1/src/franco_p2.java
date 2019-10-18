public class franco_p2 {
    public static void main(String[] args) {
        final int NUM_MONTHS = 12;
        int i = 0;
        double currBalance1;
        double currBalance2;
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setBalance(2000.00);


        saver1.modifyInterestRate(.04);


        for (i = 0; i < NUM_MONTHS; ++i) {
            saver1.calculateMonthlyInterest();
        }
        System.out.print("Saver 1, ");
        saver1.printBalance();
        currBalance1 = saver1.getSavingsBalance();

        saver2.setBalance(3000.00);
        saver2.modifyInterestRate(.04);
        for (i = 0; i < NUM_MONTHS; ++i) {
            saver2.calculateMonthlyInterest();
        }
        System.out.print("Saver 2, ");
        saver2.printBalance();
        currBalance2 = saver2.getSavingsBalance();

        saver1.setBalance(currBalance1);
        saver1.modifyInterestRate(.05);

        saver1.calculateMonthlyInterest();
        System.out.print("Saver 1, ");
        saver1.printBalance();

        saver2.setBalance(currBalance2);
        saver2.modifyInterestRate(.05);
        saver2.calculateMonthlyInterest();
        System.out.print("Saver 2, ");

        saver2.printBalance();
    }
}
