package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = scanner.nextInt();

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (decimalNumber==0) {
            System.out.println(0);
        } else {

        while (decimalNumber>0) {
            binaryNumber.push(decimalNumber%2);
            decimalNumber = decimalNumber/2;
        }

        while (!binaryNumber.isEmpty()) {
            System.out.print(binaryNumber.pop());
        }
        }
    }
}
