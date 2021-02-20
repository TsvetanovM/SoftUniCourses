import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Magic_Box {
    private static final int MINIMUM_QUALITY = 90;
    private static int totalQuality = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(secondBox::push);

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int secondValue = secondBox.pop();
            int firstValue = firstBox.peek();
            int value = firstValue + secondValue;

            if (value % 2 == 0) {
                firstBox.poll();
                totalQuality += value;
            } else {
                firstBox.offer(secondValue);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        else {
            System.out.println("Second magic box is empty.");
        }

        if (totalQuality >= MINIMUM_QUALITY) {
            System.out.println("Wow, your prey was epic! Value: " + totalQuality);
        } else {
            System.out.println("Poor prey... Value: " + totalQuality);
        }
    }
}
