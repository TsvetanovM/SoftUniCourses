import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lab02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> partyList = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            partyList.add(input);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            partyList.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(partyList.size());
        for (String guest : partyList) {
            System.out.println(guest);
        }
    }
}
