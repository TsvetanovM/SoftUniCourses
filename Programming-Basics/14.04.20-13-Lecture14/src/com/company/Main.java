package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String book = scan.nextLine();
        String input = scan.nextLine();
        int counter = 0;
        boolean isFound;

        while (!input.equals(book)){
            if (input.equals("No More Books")){
                break;
            }
            counter++;
            input = scan.nextLine();
        }
        if (input.equals(book)){
            System.out.println("You checked " + counter + " books and found it.");
        }
        else {
            System.out.println("The book you search is not here!");
            System.out.println("You checked " + counter + " books.");
        }
    }
}
