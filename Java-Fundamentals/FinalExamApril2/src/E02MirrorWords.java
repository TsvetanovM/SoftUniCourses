import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> matchingPairs = new ArrayList<>();
        int validPairs = 0;

        while (matcher.find()) {
            validPairs++;
            String wordOne = matcher.group("wordOne");
            StringBuilder wordPair = new StringBuilder(wordOne);
            String wordTwo = matcher.group("wordTwo");
            wordPair.reverse();
            if (wordPair.toString().equals(wordTwo)) {
                matchingPairs.add(wordOne+" <=> "+wordTwo);
            }
        }
        if (validPairs==0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(validPairs + " word pairs found!");
        }
        if (matchingPairs.size()>0){
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", matchingPairs));
        }
        else {
            System.out.println("No mirror words!");
        }
    }
}
