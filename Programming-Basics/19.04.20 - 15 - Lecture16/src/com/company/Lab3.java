package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int sumPrime = 0;
        int sumNonPrime = 0;

        while (!input.equals("stop")){
            int current = Integer.parseInt(input);
            boolean isPrime = true;
            if (current<0){
                System.out.println("Number is negative.");
            }
            else {
                for (int i = 2; i<current;i++){
                    if (current%i==0){
                       isPrime = false;
                    }
                }
                if (isPrime){
                    sumPrime+=current;
                }
                else {
                   sumNonPrime+=current;
                }
            }
            input = scan.nextLine();
        }
        System.out.println("Sum of all prime numbers is: "+ sumPrime);
        System.out.println("Sum of all non prime numbers is: "+ sumNonPrime);
    }
}
