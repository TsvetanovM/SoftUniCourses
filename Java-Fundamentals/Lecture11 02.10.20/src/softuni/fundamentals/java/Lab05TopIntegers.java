package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab05TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] arrayAsString = input.split(" ");
        int[] arr = new int[arrayAsString.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrayAsString[i]);
        }
        for (int i = 0; i < arr.length; i++){
            boolean isBigger = true;
            for (int j = i+1; j <= arr.length; j++) {
                if (j>arr.length-1){
                    break;
                }
                if (arr[j]>=arr[i]){
                    isBigger = false;
                    break;
                }
            }
            if (isBigger){
                System.out.print(arr[i] + " ");
            }
        }
    }
}
