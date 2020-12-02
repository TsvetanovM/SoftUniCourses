package com.company;

import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fruit = scan.nextLine();
        String day = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());
        double price = 0;
        boolean isError = false;

        if (fruit.equals("banana")){
            switch (day){
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity*2.50;
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity *2.70;
                    break;
                default:
                    isError = true;
                    break;
            }
        }
        else if (fruit.equals("apple")){
            switch (day){
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity*1.20;
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity *1.25;
                    break;
                default:
                    isError = true;
                    break;
            }
        }
        else if (fruit.equals("orange")){
            switch (day){
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity*0.85;
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity *0.90;
                    break;
                default:
                    isError = true;
                    break;
            }
        }
        else if (fruit.equals("grapefruit")){
            switch (day){
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity*1.45;
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity *1.60;
                    break;
                default:
                    isError = true;
                    break;
            }
        }
        else if (fruit.equals("kiwi")){
            switch (day){
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity*2.70;
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity *3;
                    break;
                default:
                    isError = true;
                    break;
            }
        }
        else if (fruit.equals("pineapple")){
            switch (day){
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity*5.50;
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity *5.60;
                    break;
                default:
                    isError = true;
                    break;
            }
        }
        else if (fruit.equals("grapes")){
            switch (day){
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity*3.85;
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity *4.20;
                    break;
                default:
                    isError = true;
                    break;
            }
        }
        else{
            isError = true;
        }
        if (isError){
            System.out.println("error");
        }
        else {
            System.out.printf("%.2f", price);
        }
    }
}
