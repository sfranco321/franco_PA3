public class SavingsAccount {

    private static double savingsBalance;
    private static double annualInterestRate;

    public static void calculateMonthlyInterest() {
        double monthlyInterest;
        monthlyInterest = ((savingsBalance * annualInterestRate) / 12);
        savingsBalance += monthlyInterest;
    }

    public static double getSavingsBalance() {
        return savingsBalance;
    }

    public static void modifyInterestRate (double newInterestRate){
        annualInterestRate = newInterestRate;
    }
    public static void setBalance(double userBalance) {
        savingsBalance = userBalance;

    }
    public static void printBalance() {
        System.out.printf("Your Balance is $%.2f\n", savingsBalance);
    }

}
