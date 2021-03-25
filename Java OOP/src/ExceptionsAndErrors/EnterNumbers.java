package ExceptionsAndErrors;

import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            printNumbers(scanner.nextInt(), scanner.nextInt());
        } catch (Exception e) {
            System.out.println("Invalid number range. Please enter data again!");
        }
    }

    private static void printNumbers(int start, int end) {
        if (start < 1 || end > 100 || start >= end) {
            throw new IllegalStateException();
        }
        for (int i = start; i < end; i++) {
            System.out.println(i);
        }
    }
}
