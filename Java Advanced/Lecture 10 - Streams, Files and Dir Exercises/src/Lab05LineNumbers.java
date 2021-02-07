import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lab05LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));

        List<String> lines = reader.lines().collect(Collectors.toList());

        PrintWriter writer = new PrintWriter("output.txt");

        int counter = 1;

        for (String line : lines) {
            writer.write(counter++ + ". ");
            writer.write(line);
            writer.println();
        }

        reader.close();
        writer.close();
    }
}
