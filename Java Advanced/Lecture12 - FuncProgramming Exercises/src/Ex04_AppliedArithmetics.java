import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command;

        Consumer<Integer> printList = e -> System.out.print(e + " ");

        while (!"end".equals(command = scanner.nextLine())) {
            if (command.equals("print")) {
                System.out.println();
                numbers.forEach(printList);
            } else {
                numbers = updateList(numbers, command);
            }
        }
    }

    private static List<Integer> updateList(List<Integer> list, String command) {
        Function<Integer, Integer> operation;
        switch (command) {
            case "add":
                operation = e -> e += 1;
                break;
            case "multiply":
                operation = e -> e *= 2;
                break;
            case "subtract":
                operation = e -> e -= 1;
                break;
            default :
                throw new IllegalArgumentException("Command doesn't fit the requirements.");

        }
        return list.stream().map(operation).collect(Collectors.toList());
    }
}
