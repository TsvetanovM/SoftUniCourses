import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Ex06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());

        Predicate<String> isValidName = e -> e.length() <= length;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(isValidName)
                .forEach(System.out::println);
    }
}
