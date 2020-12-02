package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] numbersAsStrings = input.split(" ");
        int[] numbers = new int[numbersAsStrings.length];
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
            if (numbers[i]%2!=0){
                sumOdd+=numbers[i];
            }
            else {
                sumEven+=numbers[i];
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
