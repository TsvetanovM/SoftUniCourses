package marto.util.classes;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> checkIfDivisible = e -> e % n != 0;

        Consumer<Integer> printNum = e -> System.out.print( e + " ");

        numbers.stream()
                .filter(checkIfDivisible)
                .forEach(printNum);
    }
}
