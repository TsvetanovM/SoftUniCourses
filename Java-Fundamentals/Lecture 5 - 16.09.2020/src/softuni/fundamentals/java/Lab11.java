package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());
        if (multiplier<10){
            for(int i = multiplier; i<11; i++){
                System.out.println(n+" X "+i+" = "+n*i);
            }
        }
        else {
            System.out.println(n+" X "+multiplier+" = "+n*multiplier);
        }
    }
}
