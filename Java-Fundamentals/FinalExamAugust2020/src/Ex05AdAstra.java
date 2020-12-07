import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex05AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("([|#])(?<item>[A-Za-z\\s]+)\\1(?<expiry>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(text);
        List<String[]> food = new ArrayList<>();
        int totalCalories = 0;

        while (matcher.find()){
            String[] currentItem = new String[3];
            currentItem[0] = matcher.group("item");
            currentItem[1] = matcher.group("expiry");
            currentItem[2] = matcher.group("calories");
            totalCalories += Integer.parseInt(matcher.group("calories"));
            food.add(currentItem);
        }

        int daysToLast = totalCalories/2000;
        System.out.println("You have food to last you for: " + daysToLast + " days!");
        for (String[] string : food) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", string[0], string[1], string[2]);
        }
    }
}
