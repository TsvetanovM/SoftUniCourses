package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab03ArraySplit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] numbersAsStrings = input.split(" ");
        int[] numbers = new int[numbersAsStrings.length];
        int sum = 0;
        for (int i = 0; i<numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }
}
//        Using the Split function:
//
//        String arrayToBe = scan.nextLine();
//        String[] numbersAsStrings = arrayToBe.split(" ");
//        int[] arr = new int[numbersAsStrings.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(numbersAsStrings[i]);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }


