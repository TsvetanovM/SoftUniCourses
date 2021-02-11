import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        Map<String, Predicate<String>> filters = new HashMap<>();

        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String condition = tokens[1];
            String argument = tokens[2];

            Predicate<String> currentPredicate = makePredicate(condition, argument);
            updateFilters(filters, command, String.join(" ", condition, argument), currentPredicate);

            input = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            printGuests(guests, filters);
        }
    }

    private static void printGuests(List<String> guests, Map<String, Predicate<String>> filters) {
        for (Predicate<String> predicate : filters.values()) {
            guests = guests
                    .stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
        }

        guests.forEach(e -> System.out.print(e + " "));
    }

    private static Predicate<String> makePredicate(String condition, String argument) {
        Predicate<String> checker;

        switch (condition) {
            case "Starts with":
                String sequence = argument;
                checker = str -> !str.startsWith(sequence);
                break;
            case "Ends with":
                sequence = argument;
                checker = str -> !str.endsWith(sequence);
                break;
            case "Length":
                int length = Integer.parseInt(argument);
                checker = str -> str.length() != length;
                break;
            case "Contains":
                sequence = argument;
                checker = str -> !str.contains(sequence);
                break;
            default:
                throw new IllegalArgumentException("Input format not supported.");
        }

        return checker;
    }

    private static void updateFilters(Map<String, Predicate<String>> list, String command, String key, Predicate<String> predicate) {
        switch (command) {
            case "Add filter":
                list.put(key, predicate);
                break;
            case "Remove filter":
                list.remove(key);
                break;
        }
    }
}
