import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<Integer> dividers = getIntegerList(scanner);

        IntPredicate divisibleBy = n -> {
            for (Integer divider : dividers) {
                if (n%divider != 0) {
                    return false;
                }
            }
            return true;
        };

        IntConsumer basicPrint = e -> System.out.print(e + " ");

        IntStream.range(1 , N + 1)
                .filter(divisibleBy)
                .forEach(basicPrint);
    }

    private static List<Integer> getIntegerList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
