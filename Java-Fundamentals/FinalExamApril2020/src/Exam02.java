import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(text);

        BigInteger coolThreshold = new BigInteger("0");
        boolean firstFind = false;
        int totalEmojis = 0;
        List<String> emojiList = new ArrayList<>();

        while (match.find()){
            if (!firstFind){
                coolThreshold = BigInteger.valueOf(1);
                firstFind = true;
            }
            coolThreshold = coolThreshold.multiply(BigInteger.valueOf(Long.parseLong(match.group())));
        }

        regex = "(::|\\*\\*)(?<letters>[A-Z][a-z]{2,})\\1";
        pattern = Pattern.compile(regex);
        match = pattern.matcher(text);

        while (match.find()){
            String emoji = match.group();
            BigInteger coolness = new BigInteger("0");
            String qualifyingLetters = match.group("letters");
            char[] letters = qualifyingLetters.toCharArray();
            for (char letter : letters) {
                coolness = coolness.add(BigInteger.valueOf(letter));
            }
            if (coolness.compareTo(coolThreshold)>=0){
                emojiList.add(emoji);
            }
            totalEmojis++;
        }

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(totalEmojis + " emojis found in the text. The cool ones are:");
        emojiList.forEach(System.out::println);
    }
}
