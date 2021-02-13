import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (N-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.add(new Person(name, age));
        }

        people.stream()
                .filter(e -> e.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
