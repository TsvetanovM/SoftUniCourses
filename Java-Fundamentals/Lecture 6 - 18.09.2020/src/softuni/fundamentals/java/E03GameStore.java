package softuni.fundamentals.java;

import java.util.Scanner;

public class E03GameStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double startingBalance = Double.parseDouble(scan.nextLine());
        double currentBalance = startingBalance;
        String input = scan.nextLine();
        double price = 0;
        boolean isOutOfMoney = false;
        while (!input.equals("Game Time")){
            boolean isBought = true;
            switch (input){
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price=39.99;
                    break;
                case "CS: OG":
                    price=15.99;
                    break;
                case "Zplinter Zell":
                    price=19.99;
                    break;
                case "Honored 2":
                    price=59.99;
                    break;
                case "RoverWatch":
                    price=29.99;
                    break;
                default:
                    System.out.println("Not Found");
                    isBought = false;
                    break;
            }
            currentBalance-=price;
            if (currentBalance<0){
                System.out.println("Too Expensive");
                currentBalance+=price;
            }
            else if(currentBalance>=0 && isBought) {
                System.out.printf("Bought %s%n", input);
            }
            if (currentBalance==0){
                System.out.println("Out of money!");
                isOutOfMoney = true;
                break;
            }
            input = scan.nextLine();
        }
        if (!isOutOfMoney){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", startingBalance-currentBalance, currentBalance);
        }
    }
}
