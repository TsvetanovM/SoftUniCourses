import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lab06SortLines {
    public static void main(String[] args) throws IOException {

        String input = "input.txt";
        List<String> lines = Files.readAllLines(Paths.get(input)).stream().sorted().collect(Collectors.toList());

//        PrintWriter writer = new PrintWriter("out.txt");

//        BufferedWriter writer = new BufferedWriter(new PrintWriter("out.txt"));
//
//        for (String line : lines) {
//            writer.write(line);
//            writer.newLine();
//        }
//
//        writer.flush();
//        writer.close();

        Files.write(Path.of("out.txt"), lines);
    }
}
