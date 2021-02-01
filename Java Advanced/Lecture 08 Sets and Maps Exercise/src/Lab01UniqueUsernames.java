import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        while (n-- > 0) {
            usernames.add(scanner.nextLine());
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
