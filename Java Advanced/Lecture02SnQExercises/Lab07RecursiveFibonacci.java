package softuni.advanced.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab07RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> fibonacciSequence = new ArrayList();
        fibonacciSequence.add(1L);
        fibonacciSequence.add(1L);

        for (int i = 1; i < 49; i++) {
            fibonacciSequence.add(fibonacciSequence.get(i)+fibonacciSequence.get(i-1));
        }

        int N = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacciSequence.get(N));
    }
}
