import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Lab03_CountUppercaseWords {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();
        String[] words = text.split("\\s+");
        Predicate<String> predicate = n -> Character.isUpperCase(n.charAt(0));



        long count = filterWords(words, predicate).count();

        System.out.println(count);

        filterWords(words, predicate).forEach(System.out::println);
    }

    private static Stream<String> filterWords(String[] words, Predicate<String> predicate) {
        return Arrays.stream(words).filter(predicate);
    }
}
