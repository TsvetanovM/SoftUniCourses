package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n ; i++) {
                int sum = 0;
                int b = i%10;
                sum +=b;
                int c = i/10;
                sum +=c;
                if (sum == 5 || sum ==7 || sum == 11){
                    System.out.printf("%d -> True%n", i);
                }
                else {
                    System.out.printf("%d -> False%n", i);
                }
        }
    }
}
