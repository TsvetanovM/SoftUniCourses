import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String condition = tokens[1];
            String argument = tokens[2];

            Set<String> filteredList = filterList(guests, condition, argument);

            changeList(guests, filteredList, command);

            input = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            printGuests(guests);
        }
    }

    private static void printGuests(List<String> guests) {
        AtomicInteger counter = new AtomicInteger(guests.size());
        Consumer<String> printGuests = str -> {
            if (counter.decrementAndGet()>0) {
                System.out.print(str + ", ");
            } else {
                System.out.println(str + " are going to the party!");
            }
        };
        guests.stream()
                .sorted()
                .forEach(printGuests);
    }

    private static Set<String> filterList(List<String> list, String condition, String argument) {
        Predicate<String> checker;

        switch (condition) {
            case "StartsWith":
                String sequence = argument;
                checker = str -> str.startsWith(sequence);
                break;
            case "EndsWith":
                sequence = argument;
                checker = str -> str.endsWith(sequence);
                break;
            case "Length":
                int length = Integer.parseInt(argument);
                checker = str -> str.length() == length;
                break;
            default:
                throw new IllegalArgumentException ("Input format not supported.");
        }

        return list.stream()
                .filter(checker)
                .collect(Collectors.toSet());
    }

    private static void changeList(List<String> guests, Set<String> filteredList, String command) {
        for (String guest : filteredList) {
            switch (command) {
                case "Remove":
                    while (guests.contains(guest)) {
                        guests.remove(guest);
                    }
                    break;
                case "Double":
                    int counter = 0;
                    int guestNumber = guests.size();
                    while (counter<guestNumber) {
                        if (guest.equals(guests.get(counter))) {
                            guests.add(guest);
                        }
                        counter++;
                    }
            }
        }
    }
}
