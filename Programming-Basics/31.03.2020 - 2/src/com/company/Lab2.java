package com.company;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        //"You are <firstName> <lastName>, a <age>-years old person from <town>."
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner2 = new Scanner(System.in);
        //Scanner scanner3 = new Scanner(System.in);
        //Scanner scanner4 = new Scanner(System.in);

        String firstname = scanner.nextLine();
        String lastname = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String town = scanner.nextLine();

        System.out.printf("You are %s %s, a %d-years old person from %s.", firstname, lastname, age, town);
        //above is the fastest way to print that using the printf - printformat function.

        //System.out.print("You are " + firstname + " " + lastname + ", a " + age + "-years old person from " + town + ".");
        // above is the concatenate data way of doing it but it takes longer and has larger room for error.




    }
}
