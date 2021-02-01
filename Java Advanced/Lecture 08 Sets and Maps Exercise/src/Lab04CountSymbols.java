import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> occurrencesTrack = new TreeMap<>();


        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            occurrencesTrack.putIfAbsent(currentSymbol, 0);
            occurrencesTrack.put(currentSymbol, occurrencesTrack.get(currentSymbol) + 1);
        }

        occurrencesTrack.entrySet().forEach(e -> System.out.printf("%c: %d time/s%n", e.getKey(), e.getValue()));
    }
}
