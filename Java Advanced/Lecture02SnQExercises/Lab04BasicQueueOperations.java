package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] instructions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < instructions[0]; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < instructions[1]; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(instructions[2])){
            System.out.println("true");
        } else {
            int minElement = Integer.MAX_VALUE;
            for (Integer integer : queue) {
                if (integer<minElement) {
                    minElement = integer;
                }
            }
            System.out.println(minElement);
        }
    }
}
