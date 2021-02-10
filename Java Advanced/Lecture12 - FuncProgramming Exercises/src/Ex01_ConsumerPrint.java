import java.util.Scanner;
import java.util.function.Consumer;

public class Ex01_ConsumerPrint {
    public static void main(String[] args) {
        String[] tokens = new Scanner(System.in).nextLine().split("\\s+");
        Consumer<String> printToken = System.out::println;
        for (String token : tokens) {
            printToken.accept(token);
        }
    }
}
