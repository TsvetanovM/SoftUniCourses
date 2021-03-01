import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = readIntArray(scanner);

        Point bottomLeft = new Point(coordinates[0], coordinates[1]);
        Point topRight = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int N = Integer.parseInt(scanner.nextLine());

        while (N-- > 0) {
            int[] currentCoordinates = readIntArray(scanner);
            int x = currentCoordinates[0];
            int y = currentCoordinates[1];
            System.out.println(rectangle.contains(new Point(x, y)));
        }
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
