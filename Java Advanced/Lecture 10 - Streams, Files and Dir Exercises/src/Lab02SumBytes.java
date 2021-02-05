import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Lab02SumBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\tsvet\\Desktop\\Lecture10\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;

        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));

            for (String line : allLines) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);

//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//
//           List<String> allLines = reader.lines().collect(Collectors.toList());
//
//           long sum = 0;
//
//            for (String line : allLines) {
//                for (int i = 0; i < line.length(); i++) {
//                    sum += line.charAt(i);
//                }
//            }
//
//            System.out.println(sum);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
