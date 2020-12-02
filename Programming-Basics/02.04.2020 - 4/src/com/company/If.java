package com.company;

import java.util.Scanner;

public class If {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double grade = Double.parseDouble(scan.nextLine());

        if (grade >= 5) {
            System.out.println("Excellent!");
        }
    }
}
//        String color = "red";
//        if (color.equals("red")) {
//            System.out.println("Tomato");
//        }
//        else {
//            System.out.println("Banana");
//            System.out.println("Bye");// Bye is in the Else brackets so it is only completed when we get a false result
//        }
////        System.out.println("Bye"); // Bye is out of the Else brackets so it is always completed.
//
//    }
//}
