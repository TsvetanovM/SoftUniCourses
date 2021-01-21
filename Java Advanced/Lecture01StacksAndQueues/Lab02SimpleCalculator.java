package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lab02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            if (i%2==0) {
             numbers.add(Integer.parseInt(input[i]));
            } else {
                operators.add(input[i]);
            }
        }

        int result = 0;
        result += numbers.pop();

        while (!operators.isEmpty()) {
            String currentOperator = operators.pop();
            if (currentOperator.equals("+")) {
                result += numbers.pop();
            } else {
                result -= numbers.pop();
            }
        }

        System.out.println(result);
    }
}
