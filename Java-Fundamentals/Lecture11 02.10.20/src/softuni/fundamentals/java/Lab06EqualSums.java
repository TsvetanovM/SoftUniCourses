package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab06EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] array = input.split(" ");
        int[] arr = new int[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        boolean print = false;
        for (int i = 0; i < arr.length; i++) {
            int sumRight = 0;
            int sumLeft = 0;
            if (i==arr.length-1){
                sumRight+= 0;
            }
            else {
                for (int j = i+1; j < arr.length; j++) {
                sumRight += arr[j];
                }
            }
            if (i==0){
                sumLeft+=0;
            }
            else {
                for (int j = i-1; j >= 0; j--) {
                    sumLeft+=arr[j];
                }
            }
            if (sumRight==sumLeft){
                System.out.println(i);
                print = true;
            }
        }
        if (!print){
            System.out.println("no");
        }
    }
}
