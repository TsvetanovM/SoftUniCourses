import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Lab03AllCapitals {
    public static void main(String[] args) {
        String path = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            List<String> strings = reader.lines().collect(Collectors.toList());
            for (String string : strings) {
                 writer.write(string.toUpperCase());
                 writer.newLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
