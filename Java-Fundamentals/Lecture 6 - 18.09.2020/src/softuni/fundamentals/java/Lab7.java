package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double totalSum = 0;
        while (!input.equals("Start")){
            double coinValue = Double.parseDouble(input);
            if (coinValue==0.1 || coinValue==0.2 || coinValue == 0.5 || coinValue == 1 || coinValue == 2) {
                totalSum += coinValue;
            }
            else {
                System.out.printf("Cannot accept %.2f%n", coinValue);
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();
        double price = 0;
        while (!input.equals("End")){
            boolean purchased = true;
            switch (input){
                case "Nuts":
                    price=2;
                    break;
                case "Water":
                    price=0.7;
                    break;
                case "Crisps":
                    price=1.5;
                    break;
                case "Soda":
                    price=0.8;
                    break;
                case "Coke":
                    price=1;
                    break;
                default:
                    System.out.println("Invalid product");
                    purchased = false;
                    break;
            }
            totalSum-=price;
            if (totalSum<0){
                System.out.println("Sorry, not enough money");
                totalSum+=price;
            }
            else if(purchased) {
                System.out.println("Purchased "+ input);
            }
            input = scan.nextLine();
        }
        System.out.printf("Change: %.2f", totalSum);
    }
}
