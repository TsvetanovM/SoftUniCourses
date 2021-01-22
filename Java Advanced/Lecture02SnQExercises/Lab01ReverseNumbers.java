package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lab01ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i : input) {
            numbers.push(i);
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
