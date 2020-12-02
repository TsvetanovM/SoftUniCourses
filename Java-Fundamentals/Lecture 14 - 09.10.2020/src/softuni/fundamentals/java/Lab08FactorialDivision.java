package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab08FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double result = factorialOf(Integer.parseInt(scan.nextLine()))/factorialOf(Integer.parseInt(scan.nextLine()));
        System.out.printf("%.2f", result);
    }

    static double factorialOf(int n) {
        double result = n;
        if (n==0 || n==1){
            result = 1;
            return result;
        }
        for (int i = n - 1; i > 0; i--) {
                result *= i;
        }
        return result;
    }
}
