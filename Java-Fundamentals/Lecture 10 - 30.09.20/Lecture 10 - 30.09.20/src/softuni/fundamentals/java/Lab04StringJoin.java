package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab04StringJoin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] actualInput = input.split(" ");
        for (int i = 0; i < actualInput.length/2; i++) {
            int swapIndex = actualInput.length - i - 1;
            String previousIndex = actualInput[swapIndex];
            actualInput[swapIndex] = actualInput[i];
            actualInput[i] = previousIndex;
        }
      String print = String.join(" ", actualInput);
        System.out.print(print);
    }
}

//Using String Join example:

//    int[] numbers = new int[] {1, 3, 13, 23, 42};
//
//    String[] numbersAsStrings = new String[numbers.length];
//
//        for (int i = 0; i < numbersAsStrings.length; i++) {
//        numbersAsStrings[i] = String.valueOf(numbers[i]);
//        }
//
//        String print = String.join("-->", numbersAsStrings);
//        System.out.println(print);