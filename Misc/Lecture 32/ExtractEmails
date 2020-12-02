package softuni.fundamentals.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab06ExtractEmails {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String regex = "\\b[A-Za-z0-9]+([-._][A-Za-z0-9]+)?@[A-Za-z]+(-[A-Za-z]+)?(\\.[A-Za-z]+(-[A-Za-z]+)?)*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);

        while (match.find()){
            System.out.println(match.group());
        }
    }
}
