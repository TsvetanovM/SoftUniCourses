import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lab03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> periodicTable = new TreeSet<>();

        while (n-- > 0) {
            String[] compound = scanner.nextLine().split("\\s+");
            periodicTable.addAll(Arrays.asList(compound));
        }

        for (String s : periodicTable) {
            System.out.print(s + " ");
        }
    }
}
