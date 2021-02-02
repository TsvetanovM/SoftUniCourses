import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstLength = scanner.nextInt();
        int secondLength = scanner.nextInt();

        Set<Integer> numbers = new LinkedHashSet<>();
        Set<Integer> numbers2 = new LinkedHashSet<>();
        Set<Integer> repeatingElements = new LinkedHashSet<>();

        while (firstLength-- > 0) {
            numbers.add(scanner.nextInt());
        }

        while (secondLength-- > 0) {
            numbers2.add(scanner.nextInt());
        }

        for (Integer number : numbers) {
            if (numbers2.contains(number)) {
                repeatingElements.add(number);
            }
        }

        for (Integer num : repeatingElements) {
            System.out.print(num + " ");
        }
    }
}
