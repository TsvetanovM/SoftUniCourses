import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class Lab04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        UnaryOperator<Double> addVAT = e -> e * 1.20;
        System.out.println("Prices with VAT:");
        Arrays.stream(input
                .split(",\\s+"))
                .mapToDouble(Double::parseDouble)
                .map((DoubleUnaryOperator) addVAT)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
