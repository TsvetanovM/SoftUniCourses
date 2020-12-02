package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab07MaxSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] array = input.split(" ");
        int equalCounter = 0;
        int longestSequence = 0;
        int startingIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i].equals(array[i+1])){
                    equalCounter++;
            }
            else {
                equalCounter = 0;
            }
                if (equalCounter > longestSequence) {
                    longestSequence = equalCounter;
                    if (i==array.length-2){
                        lastIndex = i+1;
                        startingIndex = i-equalCounter+1;
                    }
                    else {
                        lastIndex = i+1;
                        startingIndex = lastIndex-equalCounter;
                    }
            }
        }
        for (int i = startingIndex; i <= lastIndex; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
