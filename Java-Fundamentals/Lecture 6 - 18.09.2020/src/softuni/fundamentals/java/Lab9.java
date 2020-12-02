package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double saberPrice = Double.parseDouble(scan.nextLine());
        double robePrice = Double.parseDouble(scan.nextLine());
        double beltPrice = Double.parseDouble(scan.nextLine());
        double totalPrice = 0;

        double totalSabers = Math.ceil(students*1.1);
        int totalBelts = students - students/6;
        totalPrice = saberPrice * totalSabers + robePrice*students + beltPrice*totalBelts;

        if (money<totalPrice){
            System.out.printf("Ivan Cho will need %.2flv more.", totalPrice-money);
        }
        else {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        }
    }
}
