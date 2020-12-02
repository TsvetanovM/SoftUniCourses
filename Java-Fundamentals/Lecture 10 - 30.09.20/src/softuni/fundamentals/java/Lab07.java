package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] stringArray = input.split(" ");
        int[] arr = new int[stringArray.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stringArray[i]);
        }

        while (arr.length-1>0){
            int[] condensed = new int[arr.length-1];
            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = arr[i] + arr[i + 1];
            }
            arr = condensed;
        }
        System.out.println(arr[0]);
    }
}
