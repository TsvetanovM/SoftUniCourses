package com.company;

import java.util.Scanner;

public class Lecture13Lab5 {
    double sum;
    String input;
    Scanner scan = new Scanner(System.in);

    public void IncreaseSum() {
        input = scan.nextLine();
        while (!input.equals("NoMoreMoney")){
            double currentSum = Double.parseDouble(input);
            if (currentSum<0){
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", currentSum);
            sum+=currentSum;
            input = scan.nextLine();
        }
        System.out.printf("Total: %.2f", sum);
    }

    public static void main(String[] args) {
        Lecture13Lab5 sum = new Lecture13Lab5();
        sum.IncreaseSum();
    }
}
