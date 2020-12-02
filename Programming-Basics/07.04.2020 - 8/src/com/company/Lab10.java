package com.company;

import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //	"room for one person" – 18.00 лв. за нощувка
        //	"apartment" – 25.00 лв. за нощувка
        //	"president apartment" – 35.00 лв. за нощувка
        int days = Integer.parseInt(scan.nextLine());
        String room = scan.nextLine();
        String grade = scan.nextLine();
        double price = 18 * (days-1);

        if (days<10){
            switch (room){
                case "apartment":
                  price = 25*(days-1)*0.7;
                  break;
                case "president apartment":
                    price = 35*(days-1)*0.9;
                    break;
            }
        }
        else if (days <= 15){
            switch (room){
                case "apartment":
                    price = 25*(days-1)*0.65;
                    break;
                case "president apartment":
                    price = 35*(days-1)*0.85;
                    break;
            }
        }
        else {
            switch (room){
                case "apartment":
                    price = 25*(days-1)*0.5;
                    break;
                case "president apartment":
                    price = 35*(days-1)*0.8;
                    break;
            }
        }
        switch (grade){
            case "positive":
                price = price * 1.25;
                break;
            case "negative":
                price = price *0.9;
                break;
        }
        System.out.printf("%.2f", price);
    }
}
