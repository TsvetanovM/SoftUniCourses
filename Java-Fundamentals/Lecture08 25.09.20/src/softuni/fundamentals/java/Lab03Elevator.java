package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab03Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        double courses = (double) n/p;
        int finals = (int) Math.ceil(courses);
        System.out.println(finals);
    }
}
