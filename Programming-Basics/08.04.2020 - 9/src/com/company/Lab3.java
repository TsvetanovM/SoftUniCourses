package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int temp = Integer.parseInt(scan.nextLine());
        String timeOfDay = scan.nextLine();

        if (temp>=10 && temp<=18){
            switch (timeOfDay){
                case "Morning":
                    System.out.printf("It's %d degrees, get your Sweatshirt and Sneakers.", temp);
                    break;
                case "Afternoon":
                case "Evening":
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", temp);
                    break;
            }
        }
        else if (temp>18 && temp <=24){
            switch (timeOfDay){
                case "Morning":
                case "Evening":
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", temp);
                    break;
                case "Afternoon":
                    System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", temp);
                    break;
            }
        }
        else if (temp>=25){
            switch (timeOfDay){
                case "Morning":
                    System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", temp);
                    break;
                case "Afternoon":
                    System.out.printf("It's %d degrees, get your Swim Suit and Barefoot.", temp);
                    break;
                case "Evening":
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", temp);
                    break;
            }
        }
    }
}
