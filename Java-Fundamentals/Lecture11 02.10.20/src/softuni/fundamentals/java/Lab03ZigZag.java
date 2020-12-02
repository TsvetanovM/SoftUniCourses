package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab03ZigZag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i%2==0){
                array1[i] = scan.nextInt();
                array2[i] = scan.nextInt();
            }
            else {
                array2[i] = scan.nextInt();
                array1[i] = scan.nextInt();
            }
        }
        for (int number : array1){
            System.out.print(number + " ");
        }
        System.out.println(" ");
        for (int number : array2){
            System.out.print(number + " ");
        }
    }
}
