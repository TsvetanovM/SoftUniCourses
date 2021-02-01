import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("search")) {
            String[] details = input.split("-");
            phonebook.put(details[0], details[1]);
            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }
            name = scanner.nextLine();
        }
    }
}
