import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        Function<String, Person> parsePerson = str -> {
            String[] tokens = str.split(",\\s+");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        };

        List<Person> allPeople = new ArrayList<>();
        while (N-- > 0) {
          allPeople.add(parsePerson.apply(scanner.nextLine()));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        allPeople = condition.equals("older")
                ? filterPeople(allPeople, p -> p.age >= age)
                : filterPeople(allPeople, p -> p.age <= age);

        System.out.println(formatPeople(allPeople, getFormatterFunction(format), System.lineSeparator()));

    }

    private  static Function<Person, String> getFormatterFunction(String format) {
         switch (format) {
            case "name":
                return p -> p.name;
            case "age":
                return p -> String.valueOf(p.age);
            case "name age":
                return  p -> p.name + " - " + p.age;
            default:
                throw new IllegalStateException("Unknown format type " + format);
        }
    }

    public static List<Person> filterPeople(Collection<Person> people, Predicate<Person> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static String formatPeople(Collection<Person> people,
                                      Function<Person, String> formatter,
                                      String delimiter) {
        return people.stream()
                .map(formatter)
                .collect(Collectors.joining(delimiter));
    }

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
