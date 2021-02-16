import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Double> list = new ArrayList<>();

        while (n-- > 0) {
            double input = Double.parseDouble(scanner.nextLine());
//            Box box = new Box(input);
            list.add(input);
        }

        double comparator = Double.parseDouble(scanner.nextLine());
        System.out.println(Box.elementsGreaterThanCount(list, comparator));

    }
}
