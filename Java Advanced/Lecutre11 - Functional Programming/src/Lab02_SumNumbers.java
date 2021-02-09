import java.util.Scanner;
import java.util.function.Function;

public class Lab02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array = input.split(",\\s+");
        Function<String, Integer> parseInt = Integer::parseInt;
        int totalNumbers = 0;
        int sum = 0;
        for (String s : array) {
            int currentNumber = parseInt.apply(s);
            totalNumbers++;
            sum += currentNumber;
        }

        System.out.println("Count = " + totalNumbers);
        System.out.println("Sum = " + sum);
    }
}