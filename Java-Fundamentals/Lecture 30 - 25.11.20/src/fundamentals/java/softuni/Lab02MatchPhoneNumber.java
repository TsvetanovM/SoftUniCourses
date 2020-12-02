package fundamentals.java.softuni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b";
        String input = scan.nextLine();

        Pattern pat = Pattern.compile(regex);
        Matcher match = pat.matcher(input);
        List<String> phoneNums= new ArrayList<>();

        while (match.find()) {
            phoneNums.add(match.group());
        }

        System.out.println(String.join(", ", phoneNums));
    }
}
