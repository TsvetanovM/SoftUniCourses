import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lab04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> strings = Files.readAllLines(Paths.get(path));

        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;

        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                char current = string.charAt(i);
                if (!Character.isWhitespace(current)) {
                    if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') {
                        vowelCount++;
                    } else if (current == '!' || current == '?' || current == ',' || current == '.') {
                        punctuationCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }
        }

        PrintWriter writer = new PrintWriter("output.txt");
        writer.println("Vowels: " + vowelCount);
        writer.println("Consonants: " + consonantCount);
        writer.write("Punctuation: " + punctuationCount);

        writer.close();
    }
}
