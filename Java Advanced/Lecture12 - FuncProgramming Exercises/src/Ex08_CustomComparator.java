import java.util.*;
import java.util.stream.Collectors;

public class Ex08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Integer> evenBeforeOdd = (e2, e1) -> {
            int result;
            if (e1 % 2 == 0) {
                result = (e2 % 2 == 0) ? 0 : 1;
            } else {
                result = (e2 % 2 == 0) ? -1 : 0;
            }
            return result;
        };
        List<Integer> list = getIntegerList(scanner);

        list.stream()
                .sorted()
                .sorted(evenBeforeOdd)
                .forEach( e -> System.out.print(e + " "));
    }

    private static List<Integer> getIntegerList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
