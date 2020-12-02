package com.company;

import java.util.Scanner;

public class Exer8Hard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String FuelType = scan.nextLine();
        double LitersFuel = Double.parseDouble(scan.nextLine());
        FuelType = FuelType.toLowerCase();

        switch (FuelType) {
            case "diesel":
            case "gasoline":

            case "gas":
                if (LitersFuel >= 25) {
                    System.out.printf("You have enough %s.", FuelType);
                } else {
                    System.out.printf("Fill your tank with %s!", FuelType);
                }
                break;
            default:
                System.out.println("Invalid fuel!");
                break;
        }
    }
}
