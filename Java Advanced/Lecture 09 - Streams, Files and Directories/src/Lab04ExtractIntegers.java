import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab04ExtractIntegers {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            FileWriter writer = new FileWriter("out.txt");
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    writer.write(String.valueOf(number));
                    writer.write(System.lineSeparator());
                }
                scanner.next();
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
