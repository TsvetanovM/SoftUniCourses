package softuni.fundamentals.java;

import java.util.Scanner;

public class MidExamAugust01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double totalPrice = 0;
        while (!input.contains("e")) {
            double currentPrice = Double.parseDouble(input);
            if (currentPrice<=0) {
                System.out.println("Invalid price!");
            }
            else {
                totalPrice += currentPrice;
            }
            input = scan.nextLine();
        }
        if (totalPrice==0){
            System.out.println("Invalid order!");
        }
        else {
            double taxes = 0.2*totalPrice;
            double finalPrice = totalPrice+taxes;
            if (input.equals("special")){
                finalPrice*=0.9;
            }
            System.out.printf("Congratulations you've just bought a new computer!%nPrice without taxes: %.2f$%nTaxes: %.2f$%n-----------%nTotal price: %.2f$"
                    , totalPrice, taxes, finalPrice);
        }
    }
}
