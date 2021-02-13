import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> bookKeeper = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            completeTransaction(bookKeeper, tokens);
            input = scanner.nextLine();
        }
    }

    private static void completeTransaction(Map<Integer, BankAccount> bookKeeper, String[] tokens) {
        String command = tokens[0];
        switch (command) {
            case "Create":
                BankAccount current = new BankAccount();
                bookKeeper.put(current.getId(), current);
                System.out.printf("Account ID%d created%n", current.getId());
                break;
            case "Deposit":
                int id = Integer.parseInt(tokens[1]);
                if (invalidAccount(bookKeeper, id)) break;
                double amount = Double.parseDouble(tokens[2]);
                bookKeeper.get(id).deposit(amount);
                System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                break;
            case "SetInterest":
                double interest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(interest);
                break;
            case "GetInterest":
                id = Integer.parseInt(tokens[1]);
                if (invalidAccount(bookKeeper, id)) break;
                int years = Integer.parseInt(tokens[2]);
                System.out.printf("%.2f%n", bookKeeper.get(id).getInterest(years));
                break;
        }
    }

    private static boolean invalidAccount(Map<Integer, BankAccount> bookKeeper, int id) {
        if (!bookKeeper.containsKey(id)) {
            System.out.println("Account does not exist");
            return true;
        }
        return false;
    }
}
