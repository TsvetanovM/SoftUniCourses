import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> contactList = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.contains(".us") && !email.contains(".uk") && !email.contains(".com")) {
                contactList.put(name, email);
            }
            name = scanner.nextLine();
        }

        contactList.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
