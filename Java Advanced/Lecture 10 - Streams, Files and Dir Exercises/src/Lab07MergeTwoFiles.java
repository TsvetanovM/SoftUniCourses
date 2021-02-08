import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lab07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathOne = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathTwo = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        BufferedReader reader = new BufferedReader(new FileReader(pathOne));
        BufferedReader readerTwo = new BufferedReader(new FileReader(pathTwo));

        List<String> firstLines = reader.lines().collect(Collectors.toList());
        List<String> secondLines = readerTwo.lines().collect(Collectors.toList());

        firstLines.addAll(secondLines);

        for (String line : firstLines) {
            System.out.println(line);
        }
    }
}
