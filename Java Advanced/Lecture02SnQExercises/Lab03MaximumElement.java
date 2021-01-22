package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> sequence = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command) {
                case "1":
                    sequence.push(Integer.parseInt(input[1]));
                    break;
                case "2":
                    sequence.pop();
                    break;
                case "3":
                    int maxElement = Integer.MIN_VALUE;
                    for (Integer number : sequence) {
                        if (number>maxElement) {
                            maxElement = number;
                        }
                    }
                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
