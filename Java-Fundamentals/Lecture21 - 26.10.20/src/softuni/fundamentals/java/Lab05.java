package softuni.fundamentals.java;

import java.util.Arrays;
import java.util.Scanner;

public class Lab05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
        }
        System.out.println(result);
    }
}
