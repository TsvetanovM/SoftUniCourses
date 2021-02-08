import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Lab06WordCount {
    public static void main(String[] args) throws IOException {
        String pathOne = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathTwo = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        BufferedReader reader = new BufferedReader(new FileReader(pathOne));

        Map<String, Integer> wordCounter = new HashMap<>();

        String[] allWords = reader.readLine().split("\\s+");

        BufferedReader textReader = new BufferedReader(new FileReader(pathTwo));

        String line;

        while ((line = textReader.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            for (String token : tokens) {
                token = token.replaceAll("[^A-Za-z]", "");
                for (String word : allWords) {
                    if (word.equals(token)) {
                        wordCounter.putIfAbsent(word, 0);
                        wordCounter.put(word, wordCounter.get(word) + 1);
                    }
                }
            }
        }
        PrintWriter writer = new PrintWriter("results.txt");
        wordCounter.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> writer.println(e.getKey() + " - " + e.getValue()));

        writer.close();
        reader.close();
    }
}
