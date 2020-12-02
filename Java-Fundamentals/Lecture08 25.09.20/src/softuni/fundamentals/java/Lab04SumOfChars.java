package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab04SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            sum += input.charAt(0);
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
