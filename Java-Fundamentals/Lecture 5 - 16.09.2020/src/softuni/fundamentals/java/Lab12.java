package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        while (n%2!=0){
            System.out.println("Please write an even number.");
            n = Integer.parseInt(scan.nextLine());
        }
        n = Math.abs(n);
        System.out.println("The number is: "+n);
    }
}
