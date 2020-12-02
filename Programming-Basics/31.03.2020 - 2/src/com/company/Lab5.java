package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        // "The architect {името на архитекта} will need {необходими часове} hours to complete {брой на проектите} project/s."
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int number = Integer.parseInt(scan.nextLine());
        int hours = number * 3;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, hours, number);

    }
}
