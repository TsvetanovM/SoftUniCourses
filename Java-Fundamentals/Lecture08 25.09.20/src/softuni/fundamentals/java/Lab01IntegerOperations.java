package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab01IntegerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();
        int n4 = scan.nextInt();
        long result = (n1+n2)/n3*n4;
        System.out.println(result);
    }
}
