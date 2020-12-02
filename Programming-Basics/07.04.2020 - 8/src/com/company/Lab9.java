package com.company;

import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String city = scan.nextLine();
        double sales = Double.parseDouble(scan.nextLine());
        double comission = 0;

        if (0 <= sales && sales <= 500) {
            switch (city) {
                case "Sofia":
                    comission = 0.05 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                case "Varna":
                    comission = 0.045 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                case "Plovdiv":
                    comission = 0.055 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (500 < sales && sales <= 1000) {
            switch (city) {
                case "Sofia":
                    comission = 0.07 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                case "Varna":
                    comission = 0.075 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                case "Plovdiv":
                    comission = 0.08 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (1000 < sales && sales <= 10000) {
            switch (city) {
                case "Sofia":
                    comission = 0.08 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                case "Varna":
                    comission = 0.1 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                case "Plovdiv":
                    comission = 0.12 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (10000 < sales) {
            switch (city) {
                case "Sofia":
                    comission = 0.12 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                case "Varna":
                    comission = 0.13 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                case "Plovdiv":
                    comission = 0.145 * sales;
                    System.out.printf("%.2f", comission);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("error");
        }
    }
}
