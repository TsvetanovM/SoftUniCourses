package softuni.advanced.java;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lab02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> finalList = new ArrayDeque<>();

        for (int i = 0; i < commands[0]; i++) {
            finalList.push(numbers[i]);
        }

        for (int i = 0; i < commands[1]; i++) {
            finalList.pop();
        }

        if (finalList.contains(commands[2])) {
            System.out.println("true");
        } else if (finalList.size()==0) {
            System.out.println("0");
        } else {
            int smallestElement = Integer.MAX_VALUE;
            while (finalList.size()>0) {
                if (finalList.peek()<smallestElement) {
                    smallestElement = finalList.peek();
                }
                finalList.pop();
            }
            System.out.println(smallestElement);
        }
    }
}
