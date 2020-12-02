package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfGroup = Integer.parseInt(scan.nextLine());
        String groupType = scan.nextLine();
        String day = scan.nextLine();
        double price = 0;
        double totalPrice = 0;

        switch (groupType){
            case "Students":
                switch (day){
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.8;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                totalPrice = numberOfGroup*price;
                if (numberOfGroup>=30){
                    totalPrice *= 0.85;
                }
                break;
            case "Business":
                switch (day){
                case "Friday":
                    price = 10.9;
                    break;
                case "Saturday":
                    price = 15.6;
                    break;
                case "Sunday":
                    price = 16;
                    break;
            }
            totalPrice = numberOfGroup*price;
            if (numberOfGroup>=100){
                totalPrice -= 10*price;
            }
            break;
            case "Regular":
                switch (day){
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.5;
                        break;
                }
                totalPrice = numberOfGroup*price;
                if (numberOfGroup>=10 && numberOfGroup<=20){
                    totalPrice *= 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
