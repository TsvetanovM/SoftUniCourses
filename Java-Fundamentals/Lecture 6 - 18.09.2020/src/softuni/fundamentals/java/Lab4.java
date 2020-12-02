package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int e = scan.nextInt();
        int sum = 0;
        for (int i = n; i<=e; i++){
            System.out.print(i+" ");
            sum+=i;
        }
        System.out.println("");
        System.out.println("Sum: " + sum);
    }
}
