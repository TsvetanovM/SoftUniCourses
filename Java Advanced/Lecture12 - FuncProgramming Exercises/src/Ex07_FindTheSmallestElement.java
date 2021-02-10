import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> findMin = list -> {
            int minElement = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= minElement) {
                    minElement = list.get(i);
                    index = i;
                }
            }
            return index;
        };

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(findMin.apply(numbers));
    }
}
