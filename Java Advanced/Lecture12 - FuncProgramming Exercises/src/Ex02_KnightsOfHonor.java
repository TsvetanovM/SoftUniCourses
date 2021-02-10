import java.util.Scanner;
import java.util.function.Consumer;

public class Ex02_KnightsOfHonor {
    public static void main(String[] args) {
        String[] tokens = new Scanner(System.in).nextLine().split("\\s+");
        Consumer<String> printToken = t -> System.out.println("Sir " + t);
        for (String token : tokens) {
            printToken.accept(token);
        }
    }
}

