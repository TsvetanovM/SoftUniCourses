package fundamentals.java.softuni;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab03MatchAllDates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "\\b(?<day>\\d{2})(?<separator>[.\\-/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";

        Pattern pat = Pattern.compile(regex);
        Matcher dateFinder = pat.matcher(scan.nextLine());

        while (dateFinder.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",
                    dateFinder.group("day"), dateFinder.group("month"), dateFinder.group("year"));
        }
    }
}
