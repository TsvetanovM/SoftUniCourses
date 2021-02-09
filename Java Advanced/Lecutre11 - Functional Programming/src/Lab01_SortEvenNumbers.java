import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(e -> e%2 == 0)
                .toArray();

        System.out.println(formatArray(array));

        Arrays.sort(array);

        System.out.println(formatArray(array));
    }

    private static String formatArray(int[] array) {
        return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }
}
