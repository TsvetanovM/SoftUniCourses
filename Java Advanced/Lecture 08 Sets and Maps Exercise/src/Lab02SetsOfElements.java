import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstLength = scanner.nextInt();
        int secondLength = scanner.nextInt();

        Set<Integer> numbers = new LinkedHashSet<>();
        Set<Integer> repeatingElements = new LinkedHashSet<>();

        while (firstLength-- > 0) {
            numbers.add(scanner.nextInt());
        }

        while (secondLength-- > 0) {
            int currentNum = scanner.nextInt();
            if (numbers.contains(currentNum)) {
                repeatingElements.add(currentNum);
            }
        }

        for (Integer e : repeatingElements) {
            System.out.print(e + " ");
        }
    }
}
