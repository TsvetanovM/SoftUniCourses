package ExceptionsAndErrors.Lab;

import java.util.IllegalFormatException;
import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int num = scanner.nextInt();
            System.out.println(Math.sqrt(num));
        } catch (Exception e) {
            System.out.println("Invalid number");
        } finally {
            System.out.println("Good bye");
        }
    }
}
