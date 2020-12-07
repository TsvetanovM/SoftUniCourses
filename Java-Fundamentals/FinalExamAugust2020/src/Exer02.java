import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exer02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String allLocations = scan.nextLine();
        String regex = "([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(allLocations);

        List<String> destinations = new ArrayList<>();

        while (matcher.find()){
            destinations.add(matcher.group("destination"));
        }

        int travelPoints = 0;
        for (String destination : destinations) {
            travelPoints += destination.length();
        }
        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.println("Travel Points: " + travelPoints);
    }
}
