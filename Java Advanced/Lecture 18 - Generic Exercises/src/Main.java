import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box> boxes = new ArrayList<>();

        while (n-- > 0) {
            int input = Integer.parseInt(scanner.nextLine());
            Box box = new Box(input);
            boxes.add(box);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Box.printElements(boxes, indexes[0], indexes[1]);
    }
}
