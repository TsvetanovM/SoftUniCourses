import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Lab06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String condition = scanner.nextLine();

        IntStream.range(bounds[0], bounds[1] + 1)
                .filter(checkCondition(condition))
                .forEach(e -> System.out.print(e + " "));
    }

    private static IntPredicate checkCondition(String condition) {
        switch (condition) {
            case "even":
                return n -> n % 2 == 0;
            case "odd":
                return n -> n % 2 == 1;
            default:
                throw new IllegalStateException("Condition has to be either even or odd");
        }
    }
}
