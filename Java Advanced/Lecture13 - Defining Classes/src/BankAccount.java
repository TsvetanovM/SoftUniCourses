public class BankAccount {
    private static double interestRate = 0.02;
    private static int idCounter = 1;
    private final int id;
    private double balance;

    public BankAccount() {
        this.id = idCounter++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public static double getInterestRate() {
        return BankAccount.interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }
}
