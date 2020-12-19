import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exer02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("([*@])(?<tag>[A-Z][a-z]{2,})\\1:\\s\\[(?<word1>[A-Za-z])\\]\\|\\[(?<word2>[A-Za-z])\\]\\|\\[(?<word3>[A-Za-z])\\]\\|$");
            Matcher matcher = pattern.matcher(input);
            if (!matcher.find()){
                System.out.println("Valid message not found!");
                continue;
            }
            int word1 = matcher.group("word1").charAt(0);
            int word2 = matcher.group("word2").charAt(0);
            int word3 = matcher.group("word3").charAt(0);
            String tag = matcher.group("tag");

            System.out.printf("%s: %d %d %d%n",tag,word1,word2,word3);
        }
    }
}
