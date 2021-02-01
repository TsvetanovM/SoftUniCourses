import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        Map<String, Integer> inventory = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            inventory.putIfAbsent(resource, 0);
            inventory.put(resource, inventory.get(resource) + quantity);
            resource = scanner.nextLine();
        }

        inventory.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
