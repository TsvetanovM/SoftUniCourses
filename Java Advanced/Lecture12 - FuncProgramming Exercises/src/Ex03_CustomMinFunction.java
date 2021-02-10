import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Ex03_CustomMinFunction {
    public static void main(String[] args) {
       int[] numbers = Arrays.stream(new Scanner(System.in).nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findMin = arr ->
            Arrays.stream(arr).min().orElseThrow(NumberFormatException::new);

        System.out.println(findMin.apply(numbers));
    }
}
