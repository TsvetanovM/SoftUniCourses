package com.company;

import java.util.Scanner;

public class Exer2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int a - broi tochki, if a <= 100 - 5 bonus pts; if a >100, 20% bonus pts; if a > 1000, 10% bonus pts;
        // dop bonus tochki: if a is even - 1 bonus pt; if a ends in 5, 2 pts;

        double a = Double.parseDouble(scan.nextLine());

        if (a<=100) {
            int bonus = 5;
            if (a%2==0) {
                bonus = 6;
            }
            if (a%5==0) {
                if (a%2!=0){
                    bonus = 7;
                }
            }
                a = a+bonus;
                System.out.printf("%d%n%.1f",bonus , a);
            }
            else {
                if (a>1000) {
                   double bonus = a / 10;
                   if (a%2==0) {
                       bonus = bonus +1;
                   }
                   if (a%5==0){
                       if (a%2!=0){
                           bonus = bonus+2;
                       }
                   }
                   a = a+bonus;
                    System.out.printf("%.1f%n%.1f",bonus,a);
                }
                else {
                    double bonus = a / 5;
                    if (a%2==0){
                        bonus = bonus+1;
                    }
                    if (a%5==0){
                        if (a%2!=0){
                            bonus = bonus+2;
                        }
                    }
                    a = a+bonus;
                    System.out.printf("%.1f%n%.1f",bonus, a);
                }

            }
        }
    }

