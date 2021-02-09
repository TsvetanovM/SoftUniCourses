import java.util.Arrays;
import java.util.Scanner;

public class Lab04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Prices with VAT:");
        Arrays.stream(input
                .split(",\\s+"))
                .mapToDouble(Double::parseDouble)
                .map(n -> n = n * 1.2)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
