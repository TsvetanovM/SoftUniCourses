package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        String city = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());
        double price = 0;


            if (product.equals("coffee")) {
                switch (city) {
                    case "Sofia":
                        price = quantity * 0.50;
                        break;
                    case "Plovdiv":
                        price = quantity * 0.40;
                        break;
                    case "Varna":
                        price = quantity * 0.45;
                        break;
                }
            }
            else if (product.equals("water")) {
                switch (city) {
                    case "Sofia":
                        price = quantity * 0.80;
                        break;
                    case "Plovdiv":
                    case "Varna":
                        price = quantity * 0.70;
                        break;
                }
            }
            else if (product.equals("beer")) {
                switch (city) {
                    case "Sofia":
                        price = quantity * 1.20;
                        break;
                    case "Plovdiv":
                        price = quantity * 1.15;
                        break;
                    case "Varna":
                        price = quantity * 1.10;
                        break;
                }
            }
            else if (product.equals("sweets")) {
                switch (city) {
                    case "Sofia":
                        price = quantity * 1.45;
                        break;
                    case "Plovdiv":
                        price = quantity * 1.30;
                        break;
                    case "Varna":
                        price = quantity * 1.35;
                        break;
                }
            }
            else if (product.equals("peanuts")) {
                switch (city) {
                    case "Sofia":
                        price = quantity * 1.60;
                        break;
                    case "Plovdiv":
                        price = quantity * 1.50;
                        break;
                    case "Varna":
                        price = quantity * 1.55;
                        break;
                }
            }
                System.out.println(price);
    }
}
