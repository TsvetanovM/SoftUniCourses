package com.company;

import java.util.Scanner;

public class Exer4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        •	Такси. Начална такса: 0.70 лв. Дневна тарифа: 0.79 лв. / км. Нощна тарифа: 0.90 лв. / км.
//•	Автобус. Дневна / нощна тарифа: 0.09 лв. / км. Може да се използва за разстояния минимум 20 км.
//•	Влак. Дневна / нощна тарифа: 0.06 лв. / км. Може да се използва за разстояния минимум 100 км.

        int n = Integer.parseInt(scan.nextLine());
        String daypart = scan.nextLine();

        if (n<20){
            if (daypart.equals("day")){
                double price = 0.79*n+ 0.7;
                System.out.printf("%.2f", price);
            }
            else {
               double price = 0.9*n + 0.7;
                System.out.printf("%.2f", price);
            }
        }
        else if (n<100){
            double price = 0.09*n;
            System.out.printf("%.2f", price);
        }
        else{
            double price = 0.06*n;
            System.out.printf("%.2f", price);
        }
    }
}
