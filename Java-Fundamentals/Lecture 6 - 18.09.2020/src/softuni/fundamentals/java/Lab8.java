package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i<=n; i++){
            for (int y = 1; y<=i; y++){
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }
}
