import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , LinkedHashMap<String, Integer>> allCountries = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("report")) {
            String[] info = input.split("\\|");
            allCountries.putIfAbsent(info[1], new LinkedHashMap<>());
            allCountries.get(info[1]).put(info[0], Integer.parseInt(info[2]));
            input = scanner.nextLine();
        }

        allCountries.entrySet().stream().
                sorted((e1, e2) -> Integer.compare(e2.getValue().values().stream().mapToInt(Integer::intValue).sum(),
                        e1.getValue().values().stream().mapToInt(Integer::intValue).sum()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(),
                            entry.getValue().values().stream().mapToInt(Integer::intValue).sum());
                    entry.getValue().entrySet().stream().sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                            .forEach(e -> System.out.printf("=>%s: %d%n", e.getKey(), e.getValue()));
                });
    }
}
