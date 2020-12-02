package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02SwapIndexArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }
        for (int i = 0; i < numbers.length/2; i++) {
            int swapIndex = numbers.length-1-i;
            int oldNumbersI = numbers[i];
            numbers[i] = numbers[swapIndex];
            numbers[swapIndex] = oldNumbersI;
        }
        for (int number : numbers) {
            System.out.println(number + " ");
        }
    }
}
